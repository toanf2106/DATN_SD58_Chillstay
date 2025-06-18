package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepo extends JpaRepository<GiamGia, Integer> {
    List<GiamGia> findByTrangThaiTrue();
    GiamGia findByMaGiamGia(String maGiamGia);
    List<GiamGia> findByTenGiamGiaContainingIgnoreCase(String tenGiamGia); // hỗ trợ tìm kiếm mã giảm giá theo tenGiamGia (không phân biệt hoa thường).
}