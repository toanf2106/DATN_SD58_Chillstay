package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.AccountInfoResponse;
import org.example.datn_chillstay_2025.Dto.LoginRequest;
import java.util.Map;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.springframework.stereotype.Service;

@Service
public interface TaiKhoanService {
    TaiKhoan authenticate(String username, String password);

    TaiKhoan getTaiKhoanByUsername(String username);

    // New methods
    AccountInfoResponse getAccountInfo(String username);

    AccountInfoResponse checkAccountAndGetPermission(String username, String password);
}
