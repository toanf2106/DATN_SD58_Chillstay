package org.example.datn_chillstay_2025.Service;

import java.util.List;

import org.example.datn_chillstay_2025.Dto.Request.TinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.TinTucResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TinTucService {
    TinTucResponseDto add(TinTucRequestDto dto);
    TinTucResponseDto update(Integer id, TinTucRequestDto dto);
    TinTucResponseDto detail(Integer id);
    List<TinTucResponseDto> getAll();
    void delete(Integer id);
}
