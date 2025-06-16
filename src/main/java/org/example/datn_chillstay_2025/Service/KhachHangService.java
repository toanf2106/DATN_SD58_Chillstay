package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.KhachHangDto;
import org.example.datn_chillstay_2025.Entity.KhachHang;

public interface KhachHangService {
    List<KhachHangDto> getList();

    void saveKhachHang(KhachHang quest);
    void deleteKhachHang(Integer id);
    void updateKhachHang(Integer id, KhachHang quest);
}
