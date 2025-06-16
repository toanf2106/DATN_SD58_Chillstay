package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinTucRepo extends JpaRepository<TinTuc, Integer> {
}
