package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepo taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username);
        if (taiKhoan == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng: " + username);
        }

        String role;
        if (taiKhoan.getLoaiTaiKhoan() != null) {
            // Lấy ID của loại tài khoản
            Integer accountTypeId = taiKhoan.getLoaiTaiKhoan().getId();
            // Nếu ID = 2 thì là ADMIN, ngược lại là USER
            role = accountTypeId == 2 ? "ADMIN" : "USER";
        } else {
            role = "USER";
        }

        return new User(
                taiKhoan.getTenDangNhap(),
                taiKhoan.getMatKhau(),
                Collections.singletonList(new SimpleGrantedAuthority(role)));
    }
}