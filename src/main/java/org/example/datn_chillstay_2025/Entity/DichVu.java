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
import java.math.BigDecimal;
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
public class DichVu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "HomeStay_ID", nullable = false)
  private HomeStay homeStay;

  @Size(max = 50)
  @Nationalized
  @Column(name = "Ma_Dich_Vu", length = 50)
  private String maDichVu;

  @Size(max = 100)
  @NotNull
  @Nationalized
  @Column(name = "Ten_Dich_Vu", nullable = false, length = 100)
  private String tenDichVu;

  @Nationalized
  @Lob
  @Column(name = "Mo_Ta")
  private String moTa;

  @NotNull
  @Column(name = "Gia", nullable = false, precision = 10, scale = 2)
  private BigDecimal gia;

  @Size(max = 20)
  @NotNull
  @Nationalized
  @Column(name = "Don_Vi", nullable = false, length = 20)
  private String donVi;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}