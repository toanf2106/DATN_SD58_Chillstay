package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
    boolean existsByEmail(String email); // Kiểm tra email đã tồn tại chưa
    boolean existsBySoDienThoai(String soDienThoai);
    boolean existsByTaiKhoan_Id(Integer taiKhoanId);


}
