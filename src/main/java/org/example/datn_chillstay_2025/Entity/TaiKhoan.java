package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
public class TaiKhoan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Size(max = 50)
  @NotNull
  @Column(name = "Ten_Dang_Nhap", nullable = false, length = 50)
  private String tenDangNhap;

  @Size(max = 255)
  @NotNull
  @Column(name = "Mat_Khau", nullable = false)
  private String matKhau;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "LoaiTaiKhoan_ID", nullable = false)
  private LoaiTaiKhoan loaiTaiKhoan;

  @Size(max = 100)
  @NotNull
  @Column(name = "Email", nullable = false, length = 100)
  private String email;

  @Size(max = 15)
  @Column(name = "So_Dien_Thoai", length = 15)
  private String soDienThoai;

  @ColumnDefault("getdate()")
  @Column(name = "Ngay_Tao")
  private LocalDate ngayTao;

  @Nationalized
  @Lob
  @Column(name = "Anh")
  private String anh;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}