package org.example.datn_chillstay_2025.Repository;


import org.example.datn_chillstay_2025.Entity.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepo extends JpaRepository<GiamGia,Integer> {
    List<GiamGia> findByTrangThaiTrue(); // lấy mã giảm giá còn hiệu lực
    GiamGia findByMaGiamGia(String maGiamGia); //tìm theo mã.
}
