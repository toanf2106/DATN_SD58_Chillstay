package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class KhachHang {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "TaiKhoan_ID", nullable = false)
  private org.example.datn_chillstay_2025.Entity.TaiKhoan taiKhoan;

  @Size(max = 50)
  @Column(name = "Ma_Khach_Hang", length = 50)
  private String maKhachHang;

  @Size(max = 100)
  @NotNull
  @Column(name = "Ho_Ten", nullable = false, length = 100)
  private String hoTen;

  @Size(max = 20)
  @NotNull
  @Nationalized
  @Column(name = "So_Dien_Thoai", nullable = false, length = 20)
  private String soDienThoai;

  @Size(max = 100)
  @NotNull
  @Column(name = "Email", nullable = false, length = 100)
  private String email;

  @Column(name = "Gioi_Tinh")
  private Boolean gioiTinh;

  @ColumnDefault("getdate()")
  @Column(name = "Ngay_Tao")
  private LocalDate ngayTao;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}