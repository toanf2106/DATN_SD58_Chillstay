package org.example.datn_chillstay_2025.Controller;

import org.example.datn_chillstay_2025.Config.JwtUtil;
import org.example.datn_chillstay_2025.Dto.AccountInfoResponse;
import org.example.datn_chillstay_2025.Dto.LoginRequest;
import org.example.datn_chillstay_2025.Dto.LoginResponse;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Repository.TaiKhoanRepo;
import org.example.datn_chillstay_2025.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Xác thực bằng AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));

            // Nếu không ném ngoại lệ, xác thực thành công
            TaiKhoan taiKhoan = taiKhoanService.getTaiKhoanByUsername(loginRequest.getUsername());

            // Tạo token JWT
            String token = jwtUtil.generateToken(taiKhoan);

            // Tạo đối tượng LoginResponse để trả về
            LoginResponse response = new LoginResponse();
            response.setId(taiKhoan.getId());
            response.setUsername(taiKhoan.getTenDangNhap());
            response.setEmail(taiKhoan.getEmail());
            response.setPhone(taiKhoan.getSoDienThoai());
            response.setToken(token);

            if (taiKhoan.getLoaiTaiKhoan() != null) {
                response.setAccountTypeId(taiKhoan.getLoaiTaiKhoan().getId());
                response.setAccountTypeName(taiKhoan.getLoaiTaiKhoan().getTenLoai());
            }

            response.setAccountStatus(taiKhoan.getTrangThai());

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Tên đăng nhập hoặc mật khẩu không đúng");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Lỗi đăng nhập: " + e.getMessage());
        }
    }

    @GetMapping("/account/{username}")
    public ResponseEntity<?> getAccountInfo(@PathVariable String username) {
        AccountInfoResponse accountInfo = taiKhoanService.getAccountInfo(username);
        if (accountInfo == null) {
            return ResponseEntity.status(404).body("Tài khoản không tồn tại");
        }
        return ResponseEntity.ok(accountInfo);
    }

    @PostMapping("/account/verify")
    public ResponseEntity<?> verifyAccountAndGetPermission(@RequestBody LoginRequest loginRequest) {
        try {
            // Xác thực bằng AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));

            // Nếu không ném ngoại lệ, xác thực thành công
            AccountInfoResponse accountInfo = taiKhoanService.getAccountInfo(loginRequest.getUsername());

            return ResponseEntity.ok(accountInfo);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Tên đăng nhập hoặc mật khẩu không đúng");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Lỗi xác thực: " + e.getMessage());
        }
    }

    // Endpoint để mã hóa lại tất cả mật khẩu hiện tại
    @PostMapping("/admin/encode-all-passwords")
    public ResponseEntity<?> encodeAllPasswords() {
        try {
            List<TaiKhoan> taiKhoans = taiKhoanRepo.findAll();
            int count = 0;

            for (TaiKhoan taiKhoan : taiKhoans) {
                // Kiểm tra xem mật khẩu đã được mã hóa chưa
                String currentPassword = taiKhoan.getMatKhau();
                if (!currentPassword.startsWith("$2a$")) { // BCrypt passwords start with $2a$
                    // Mã hóa mật khẩu với BCrypt
                    String encodedPassword = passwordEncoder.encode(currentPassword);
                    taiKhoan.setMatKhau(encodedPassword);
                    taiKhoanRepo.save(taiKhoan);
                    count++;
                }
            }

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Đã mã hóa " + count + " tài khoản thành công");
            response.put("total", taiKhoans.size());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Lỗi khi mã hóa mật khẩu: " + e.getMessage());
        }
    }

    // Endpoint đăng ký tài khoản mới
    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody TaiKhoan taiKhoan) {
        try {
            // Kiểm tra tài khoản đã tồn tại chưa
            TaiKhoan existingAccount = taiKhoanService.getTaiKhoanByUsername(taiKhoan.getTenDangNhap());
            if (existingAccount != null) {
                return ResponseEntity.status(400).body("Tài khoản đã tồn tại");
            }

            // Mã hóa mật khẩu trước khi lưu
            String encodedPassword = passwordEncoder.encode(taiKhoan.getMatKhau());
            taiKhoan.setMatKhau(encodedPassword);

            // Lưu tài khoản mới
            TaiKhoan savedAccount = taiKhoanRepo.save(taiKhoan);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Đăng ký tài khoản thành công");
            response.put("username", savedAccount.getTenDangNhap());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Lỗi khi đăng ký tài khoản: " + e.getMessage());
        }
    }
}
