package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GiamGia")
public class GiamGia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Size(max = 20)
  @Nationalized
  @Column(name = "Ma_Giam_Gia", length = 20)
  private String maGiamGia;

  @Size(max = 255)
  @NotNull
  @Nationalized
  @Column(name = "Ten_Giam_Gia", nullable = false, length = 255)
  private String tenGiamGia;

  @Column(name = "Loai_Giam_Gia", nullable = false)
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
  private Boolean trangThai = true;

}