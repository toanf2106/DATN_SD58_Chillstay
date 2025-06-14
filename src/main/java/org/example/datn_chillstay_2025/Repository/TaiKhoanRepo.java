package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, Integer> {

  TaiKhoan findByTenDangNhap(String tenDangNhap);

}
