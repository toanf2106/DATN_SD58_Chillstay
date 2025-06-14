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
import java.math.BigDecimal;
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
public class GiamGia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Size(max = 50)
  @Nationalized
  @Column(name = "Ma_Giam_Gia", length = 50)
  private String maGiamGia;

  @Size(max = 20)
  @NotNull
  @Nationalized
  @Column(name = "Loai_Giam_Gia", nullable = false, length = 20)
  private String loaiGiamGia;

  @NotNull
  @Column(name = "Gia_Tri", nullable = false, precision = 10, scale = 2)
  private BigDecimal giaTri;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "HomeStay_ID")
  private HomeStay homeStay;

  @Column(name = "Gia_Tri_Toi_Thieu", precision = 10, scale = 2)
  private BigDecimal giaTriToiThieu;

  @NotNull
  @Column(name = "Ngay_Bat_Dau", nullable = false)
  private LocalDate ngayBatDau;

  @NotNull
  @Column(name = "Ngay_Ket_Thuc", nullable = false)
  private LocalDate ngayKetThuc;

  @Column(name = "So_Luong")
  private Integer soLuong;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}