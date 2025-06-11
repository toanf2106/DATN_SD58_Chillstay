package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.AnhHomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhHomeStayRepo extends JpaRepository<AnhHomeStay, Integer> {
}
