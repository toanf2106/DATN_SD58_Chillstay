package org.example.datn_chillstay_2025;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Danh sách mật khẩu cần mã hóa
        String[] passwords = {
                // Thay bằng mật khẩu thực tế của bạn
                "kh2", // Thay bằng mật khẩu khác nếu có
                // Thêm các mật khẩu khác nếu cần
        };

        // Mã hóa và in ra mật khẩu
        for (String password : passwords) {
            String encodedPassword = encoder.encode(password);
            System.out.println("Mật khẩu gốc: " + password);
            System.out.println("Mật khẩu đã mã hóa: " + encodedPassword);
            System.out.println("----------------------------------");
        }
    }
}