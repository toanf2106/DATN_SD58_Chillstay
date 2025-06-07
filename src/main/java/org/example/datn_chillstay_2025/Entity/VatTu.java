package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class VatTu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Nationalized
  @Column(name = "Ten_Vat_Tu", nullable = false, length = 100)
  private String tenVatTu;

  @Nationalized
  @Column(name = "Don_Vi", length = 20)
  private String donVi;

  @Nationalized
  @Lob
  @Column(name = "Mo_Ta")
  private String moTa;
  @Column(name = "Trang_Thai", nullable = false)
 private boolean trangThai;


}