package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TinTucRepo extends JpaRepository<TinTuc, Integer> {
    // Nếu tìm theo maTinTuc
    Page<TinTuc> findByMaTinTucContainingIgnoreCase(String maTinTuc, Pageable pageable);

    // Nếu thêm ngày đăng
    Page<TinTuc> findByMaTinTucContainingIgnoreCaseAndNgayDang(String maTinTuc, Date ngayDang, Pageable pageable);

    List<TinTuc> findAllByTrangThaiTrue();
}
