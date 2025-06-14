package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.KhachHangDto;
import org.example.datn_chillstay_2025.Entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHangDto> getList();

    void saveKhachHang(KhachHang quest);
    void deleteKhachHang(Integer id);
    void updateKhachHang(Integer id, KhachHang quest);
}
