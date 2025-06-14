package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
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
public class NhanVien {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "TaiKhoan_ID", nullable = false)
  private org.example.datn_chillstay_2025.Entity.TaiKhoan taiKhoan;

  @Size(max = 50)

  @Column(name = "Ma_Nhan_Vien", length = 50)
  private String maNhanVien;

  @Size(max = 100)
  @NotNull

  @Column(name = "Ho_Ten", nullable = false, length = 100)
  private String hoTen;

  @Size(max = 20)

  @Column(name = "So_Dien_Thoai", length = 20)
  private String soDienThoai;

  @Size(max = 100)

  @Column(name = "Email", length = 100)
  private String email;

  @Column(name = "Dia_Chi")
  private String diaChi;

  @ColumnDefault("getdate()")
  @Column(name = "Ngay_Vao_Lam")
  private LocalDate ngayVaoLam;

  @Column(name = "Ngay_Nghi_Lam")
  private LocalDate ngayNghiLam;

  @Column(name = "Gioi_Tinh")
  private Boolean gioiTinh;

  @Nationalized
  @Lob
  @Column(name = "Anh")
  private String anh;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}