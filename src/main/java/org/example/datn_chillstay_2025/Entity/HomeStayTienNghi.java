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
public class HomeStayTienNghi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "HomeStay_ID", nullable = false)
  private HomeStay homeStay;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "TienNghi_ID", nullable = false)
  private TienNghi tienNghi;

  @Size(max = 50)
  @Nationalized
  @Column(name = "Ma_HomeStay_TienNghi", length = 50)
  private String maHomestayTiennghi;

  @Column(name = "So_Luong")
  private Integer soLuong;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}