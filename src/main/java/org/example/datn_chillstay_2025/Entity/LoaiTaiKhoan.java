package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class LoaiTaiKhoan {

  @Id
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Size(max = 20)
  @NotNull
  @Column(name = "Ten_Loai", nullable = false, length = 20)
  private String tenLoai;

  @Column(name = "Mo_Ta")
  private String moTa;

  @ColumnDefault("getdate()")
  @Column(name = "Ngay_Tao")
  private LocalDate ngayTao;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;

}