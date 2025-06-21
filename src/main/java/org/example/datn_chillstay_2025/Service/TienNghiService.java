package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TienNghiService {
    Page<TienNghi> searchTienNghi(String keyword, Boolean status, Pageable pageable);
    List<TienNghi> getTienNghi();
    TienNghi getTienNghiById(int id);
    void DeleteTienNghiById(int id);
    TienNghi addTienNghi(TienNghi tienNghi);
    TienNghi updateTienNghi(TienNghi tienNghi, Integer id);
    TienNghi getTienNghiByTen(String tenTienNghi);
    void khoiPhucTienNghi(Integer id);
}
