package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiamGiaService {
    GiamGiaDTO createGiamGia(GiamGiaDTO giamGiaDTO);
    GiamGiaDTO updateGiamGia(Integer id, GiamGiaDTO giamGiaDTO);
    GiamGiaDTO getGiamGiaById(Integer id);
    Page<GiamGiaDTO> getAllGiamGia(Pageable pageable);
    Page<GiamGiaDTO> getValidVouchers(Pageable pageable);
    Page<GiamGiaDTO> getExpiredVouchers(Pageable pageable);
    void deleteGiamGia(Integer id);
    List<GiamGiaDTO> findByTenGiamGia(String tenGiamGia);
    List<GiamGiaDTO> findByTenGiamGiaAndValid(String tenGiamGia);
    List<GiamGiaDTO> findByTenGiamGiaAndExpired(String tenGiamGia);
    List<GiamGiaDTO> searchByMultipleFields(String searchTerm);
    List<GiamGiaDTO> searchByMultipleFieldsAndValid(String searchTerm);
    List<GiamGiaDTO> searchByMultipleFieldsAndExpired(String searchTerm);
}