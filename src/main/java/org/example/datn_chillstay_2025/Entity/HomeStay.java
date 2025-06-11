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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
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
public class HomeStay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "LoaiHomeStay_ID", nullable = false)
  private LoaiHomeStay loaiHomeStay;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "ChuHomeStay_ID", nullable = false)
  private ChuHomeStay chuHomeStay;

  @Size(max = 50)

  @Column(name = "Ma_HomeStay", nullable = false, length = 50)
  private String maHomestay;

  @Size(max = 100)
  @NotNull
  @Column(name = "Ten_HomeStay", nullable = false, length = 100)
  private String tenHomestay;



  @Column(name = "Hinh_Anh")
  private String hinhAnh;

  @Column(name = "Dien_Tich", precision = 10, scale = 2)
  private BigDecimal dienTich;

  @NotNull
  @Column(name = "Gia_Ca_HomeStay", nullable = false, precision = 10, scale = 2)
  private BigDecimal giaCaHomestay;

  @Size(max = 50)
  @Column(name = "Tinh_Trang", length = 50)
  private String tinhTrang;

  @Nationalized
  @Lob
  @Column(name = "Dia_Chi")
  private String diaChi;

//  @ColumnDefault("getdate()")
  @Column(name = "Ngay_Tao")
  @Temporal(TemporalType.DATE)
  private Date ngayTao;

  @Temporal(TemporalType.DATE)
  @Column(name = "Ngay_Update")
  private Date ngayUpdate;


  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai ;

}