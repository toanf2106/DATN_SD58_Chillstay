package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.GiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GiamGiaRepo extends JpaRepository<GiamGia, Integer> {
    // Tìm voucher còn hạn (đang hoạt động VÀ chưa hết hạn)
    @Query("SELECT g FROM GiamGia g WHERE g.trangThai = true AND g.ngayKetThuc >= :currentDate")
    Page<GiamGia> findValidVouchers(@Param("currentDate") LocalDate currentDate, Pageable pageable);

    // Tìm voucher hết hạn (không hoạt động HOẶC đã hết hạn)
    @Query("SELECT g FROM GiamGia g WHERE g.trangThai = false OR g.ngayKetThuc < :currentDate")
    Page<GiamGia> findExpiredVouchers(@Param("currentDate") LocalDate currentDate, Pageable pageable);

    // Tìm theo tên và còn hạn
    @Query("SELECT g FROM GiamGia g WHERE LOWER(g.tenGiamGia) LIKE LOWER(CONCAT('%', :tenGiamGia, '%')) AND g.ngayKetThuc >= :currentDate AND g.trangThai = true")
    List<GiamGia> findByTenGiamGiaAndValid(@Param("tenGiamGia") String tenGiamGia, @Param("currentDate") LocalDate currentDate);

    // Tìm theo tên và hết hạn
    @Query("SELECT g FROM GiamGia g WHERE LOWER(g.tenGiamGia) LIKE LOWER(CONCAT('%', :tenGiamGia, '%')) AND (g.ngayKetThuc < :currentDate OR g.trangThai = false)")
    List<GiamGia> findByTenGiamGiaAndExpired(@Param("tenGiamGia") String tenGiamGia, @Param("currentDate") LocalDate currentDate);

    Page<GiamGia> findAll(Pageable pageable);
    GiamGia findByMaGiamGia(String maGiamGia);
    List<GiamGia> findByTenGiamGiaContainingIgnoreCase(String tenGiamGia);

    // Tìm kiếm cơ bản theo nhiều trường - loại bỏ tìm kiếm theo loại
    @Query("SELECT g FROM GiamGia g WHERE " +
           "LOWER(g.maGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(g.tenGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "CAST(g.giaTri AS string) LIKE CONCAT('%', :searchTerm, '%')")
    List<GiamGia> searchByMultipleFields(@Param("searchTerm") String searchTerm);

    // Tìm kiếm voucher còn hạn - loại bỏ tìm kiếm theo loại
    @Query("SELECT g FROM GiamGia g WHERE " +
           "(LOWER(g.maGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(g.tenGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "CAST(g.giaTri AS string) LIKE CONCAT('%', :searchTerm, '%')) " +
           "AND g.ngayKetThuc >= CURRENT_DATE AND g.trangThai = true")
    List<GiamGia> searchByMultipleFieldsAndValid(@Param("searchTerm") String searchTerm);

    // Tìm kiếm voucher hết hạn - loại bỏ tìm kiếm theo loại
    @Query("SELECT g FROM GiamGia g WHERE " +
           "(LOWER(g.maGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(g.tenGiamGia) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "CAST(g.giaTri AS string) LIKE CONCAT('%', :searchTerm, '%')) " +
           "AND (g.ngayKetThuc < CURRENT_DATE OR g.trangThai = false)")
    List<GiamGia> searchByMultipleFieldsAndExpired(@Param("searchTerm") String searchTerm);

    @Query("SELECT g FROM GiamGia g WHERE g.ngayKetThuc >= CURRENT_DATE AND g.trangThai = true")
    Page<GiamGia> findValidVouchers(Pageable pageable);

    @Query("SELECT g FROM GiamGia g WHERE g.ngayKetThuc < CURRENT_DATE OR g.trangThai = false")
    Page<GiamGia> findExpiredVouchers(Pageable pageable);
}