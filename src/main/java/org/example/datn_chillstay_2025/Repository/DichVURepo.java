package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.DichVu;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVURepo extends JpaRepository<DichVu, Integer> {
}
