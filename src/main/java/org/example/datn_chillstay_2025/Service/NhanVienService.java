package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.NhanVienDto;
import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienService {
    List<NhanVienDto> getAll();
    void delete(Integer id);
    void  restore(Integer id);
    Page<NhanVienDto> getAllDto(int page, int size);
    NhanVienDto getNhanVienById(int id);
}
