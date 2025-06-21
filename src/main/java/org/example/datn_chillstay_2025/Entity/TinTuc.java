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
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class TinTuc {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "Nhan_vien_ID")
  private NhanVien nhanVien;

  @Column(name = "Ma_tin_tuc", length = 50)
  private String maTinTuc;

  @Column(name = "Noi_dung")
  private String noiDung;

  @Column(name = "Ngay_dang")
  private Date ngayDang;

  @Column(name = "Anh_Bia")
  private String anhBia;

  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = true;

}