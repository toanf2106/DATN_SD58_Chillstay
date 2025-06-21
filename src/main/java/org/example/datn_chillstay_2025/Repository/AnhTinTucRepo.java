package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.AnhTinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnhTinTucRepo extends JpaRepository<AnhTinTuc, Integer> {
    List<AnhTinTuc> findAllByTrangThaiTrue();


}
