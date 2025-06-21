package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TienNghiRepo extends JpaRepository<TienNghi, Integer> {
    Optional<TienNghi> findByTenTienNghi(String tenTienNghi);

    @Query("SELECT t FROM TienNghi t WHERE " +
            "(:keyword IS NULL OR t.tenTienNghi LIKE %:keyword%) AND " +
            "(:status IS NULL OR t.trangThai = :status)")
    Page<TienNghi> searchAndFilter(@Param("keyword") String keyword,
                                   @Param("status") Boolean status,
                                   Pageable pageable); // <-- Tham số này là chìa khóa

}
