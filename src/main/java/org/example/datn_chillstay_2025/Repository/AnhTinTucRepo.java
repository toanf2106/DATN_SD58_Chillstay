package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.AnhTinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhTinTucRepo extends JpaRepository<AnhTinTuc, Integer> {
}
