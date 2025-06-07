package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TienNghiRepo extends JpaRepository<TienNghi, Integer> {
    Optional<TienNghi> findByTenTienNghi(String tenTienNghi);
}
