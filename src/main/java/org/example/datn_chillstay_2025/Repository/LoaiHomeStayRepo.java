package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.LoaiHomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoaiHomeStayRepo extends JpaRepository<LoaiHomeStay, Integer> {
    Optional<LoaiHomeStay> findByTenLoaiHomestay(String tenLoaiHomestay);
}
