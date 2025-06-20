package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiamGiaService {
    GiamGiaDTO createGiamGia(GiamGiaDTO giamGiaDTO);
    GiamGiaDTO updateGiamGia(Integer id, GiamGiaDTO giamGiaDTO);
    GiamGiaDTO getGiamGiaById(Integer id);
    Page<GiamGiaDTO> getAllGiamGia(Pageable pageable); // Thay List bằng Page với Pageable
    void deleteGiamGia(Integer id);
    List<GiamGiaDTO> findByTenGiamGia(String tenGiamGia); // Hỗ trợ tìm kiếm theo tenGiamGia.
}