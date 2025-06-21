package org.example.datn_chillstay_2025.Service;

import java.util.Date;
import java.util.List;

import org.example.datn_chillstay_2025.Dto.Request.TinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.TinTucResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TinTucService {
    TinTucResponseDto add(TinTucRequestDto dto);
    TinTucResponseDto update(Integer id, TinTucRequestDto dto);
    TinTucResponseDto detail(Integer id);
    List<TinTucResponseDto> getAll();
    void delete(Integer id);
    Page<TinTucResponseDto> getAllWithPaginationAndSearch(int page, int size, String tieuDe, Date ngayDang);

}
