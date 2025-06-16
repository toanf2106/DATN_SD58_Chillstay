package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienService {
    List<NhanVienResponseDto> getAll();
    NhanVienResponseDto add(NhanVienRequestDto dto);
    NhanVienResponseDto update(Integer id, NhanVienRequestDto dto);
    void delete(Integer id);
    NhanVienResponseDto detailNhanVien(Integer id);

}
