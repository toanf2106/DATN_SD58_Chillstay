package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.AnhPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhPhongRepo extends JpaRepository<AnhPhong, Integer> {
    // Custom query methods can be defined here if needed
    // For example, find by phongId or other criteria
    // List<AnhPhong> findByPhongId(Integer phongId);
}
