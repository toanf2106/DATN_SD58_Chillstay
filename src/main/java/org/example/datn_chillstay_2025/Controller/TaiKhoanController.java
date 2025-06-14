package org.example.datn_chillstay_2025.Controller;

import org.example.datn_chillstay_2025.Config.JwtUtil;
import org.example.datn_chillstay_2025.Dto.AccountInfoResponse;
import org.example.datn_chillstay_2025.Dto.LoginRequest;
import org.example.datn_chillstay_2025.Dto.LoginResponse;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

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
}
