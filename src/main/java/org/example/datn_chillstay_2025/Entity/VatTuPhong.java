package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VatTuPhong")
public class VatTuPhong {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "Phong_ID", nullable = false)
  private Phong phong;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "VatTu_ID", nullable = false)
  private VatTu vatTu;

  @NotNull
  @Column(name = "So_Luong", nullable = false)
  private Integer soLuong;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}