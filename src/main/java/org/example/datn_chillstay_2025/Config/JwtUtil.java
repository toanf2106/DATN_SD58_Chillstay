package org.example.datn_chillstay_2025.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretString;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    private SecretKey getSigningKey() {
        byte[] keyBytes = secretString.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Lấy username từ token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Lấy thời gian hết hạn
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Trích xuất thông tin từ token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Giải mã token để lấy thông tin
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Kiểm tra token hết hạn chưa
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Tạo token từ đối tượng TaiKhoan
    public String generateToken(TaiKhoan taiKhoan) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", taiKhoan.getId());
        claims.put("accountType", taiKhoan.getLoaiTaiKhoan().getId());
        claims.put("email", taiKhoan.getEmail());

        return createToken(claims, taiKhoan.getTenDangNhap());
    }

    // Tạo token với thông tin claims và chủ đề (subject)
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Xác thực token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}