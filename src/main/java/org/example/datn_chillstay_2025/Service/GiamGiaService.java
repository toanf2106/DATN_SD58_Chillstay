package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;

import java.util.List;

public interface GiamGiaService {
    GiamGiaDTO createGiamGia(GiamGiaDTO giamGiaDTO);
    GiamGiaDTO updateGiamGia(Integer id, GiamGiaDTO giamGiaDTO);
    GiamGiaDTO getGiamGiaById(Integer id);
    List<GiamGiaDTO> getAllGiamGia();
    void deleteGiamGia(Integer id);
    List<GiamGiaDTO> findByTenGiamGia(String tenGiamGia); //Thêm phương thức findByTenGiamGia để hỗ trợ tìm kiếm theo tenGiamGia.
}