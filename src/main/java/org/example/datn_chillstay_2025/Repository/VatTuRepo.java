package org.example.datn_chillstay_2025.Repository;

import java.util.List;
import org.example.datn_chillstay_2025.Entity.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VatTuRepo extends JpaRepository<VatTu, Integer> {
  @Query("SELECT v FROM VatTu v WHERE (:ten IS NOT NULL AND LOWER(v.tenVatTu) LIKE LOWER(CONCAT('%', :ten, '%'))) OR (:id IS NOT NULL AND v.id = :id)")
  List<VatTu> findByTenOrId(@Param("ten") String ten, @Param("id") Integer id);
}