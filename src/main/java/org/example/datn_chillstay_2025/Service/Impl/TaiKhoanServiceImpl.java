package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Dto.AccountInfoResponse;
import org.example.datn_chillstay_2025.Dto.LoginRequest;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Repository.TaiKhoanRepo;
import org.example.datn_chillstay_2025.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepo taiKhoanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TaiKhoan authenticate(String username, String password) {
        TaiKhoan user = taiKhoanRepository.findByTenDangNhap(username);
        if (user != null && passwordEncoder.matches(password, user.getMatKhau())) {
            return user;
        }
        return null;
    }

    @Override
    public TaiKhoan getTaiKhoanByUsername(String username) {
        return taiKhoanRepository.findByTenDangNhap(username);
    }

    @Override
    public AccountInfoResponse getAccountInfo(String username) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username);
        if (taiKhoan == null) {
            return null;
        }

        return mapToAccountInfoResponse(taiKhoan);
    }

    @Override
    public AccountInfoResponse checkAccountAndGetPermission(String username, String password) {
        TaiKhoan taiKhoan = authenticate(username, password);
        if (taiKhoan == null) {
            return null;
        }

        return mapToAccountInfoResponse(taiKhoan);
    }

    private AccountInfoResponse mapToAccountInfoResponse(TaiKhoan taiKhoan) {
        AccountInfoResponse response = new AccountInfoResponse();
        response.setId(taiKhoan.getId());
        response.setUsername(taiKhoan.getTenDangNhap());
        response.setEmail(taiKhoan.getEmail());
        response.setPhone(taiKhoan.getSoDienThoai());
        response.setAccountStatus(taiKhoan.getTrangThai());

        if (taiKhoan.getLoaiTaiKhoan() != null) {
            response.setAccountTypeId(taiKhoan.getLoaiTaiKhoan().getId());
            response.setAccountTypeName(taiKhoan.getLoaiTaiKhoan().getTenLoai());
        }

        return response;
    }
}
