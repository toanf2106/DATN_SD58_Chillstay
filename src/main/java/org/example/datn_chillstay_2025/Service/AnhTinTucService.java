package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.Request.AnhTinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.AnhTinTucResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AnhTinTucService {
    AnhTinTucResponseDto add(AnhTinTucRequestDto dto);
    AnhTinTucResponseDto update(Integer id, AnhTinTucRequestDto dto);
    void delete(Integer id);
    List<AnhTinTucResponseDto> getAll();
    AnhTinTucResponseDto detail(Integer id);

}