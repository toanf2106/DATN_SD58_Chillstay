package org.example.datn_chillstay_2025.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class ChuHomeStay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Nationalized
  @Column(name = "Ma_Chu_HomeStay", nullable = false, length = 50)
  private String maChuHomestay;

  @Nationalized
  @Column(name = "HoTen_Chu_HomeStay", nullable = false, length = 100)
  private String hotenChuHomestay;

  @Nationalized
  @Column(name = "So_Dien_Thoai", length = 15)
  private String soDienThoai;

  @Nationalized
  @Lob
  @Column(name = "Dia_Chi")
  private String diaChi;

  @Nationalized
  @Column(name = "Que_Quan", length = 100)
  private String queQuan;

  @Column(name = "Gioi_Tinh")
  private Boolean gioiTinh;

  @ColumnDefault("1")
  @Column(name = "Trang_Thai", nullable = false)
  private Boolean trangThai = false;
//  @Transient
//  @JsonProperty("gioiTinhText")
//  public String getGioiTinhText() {
//    if (gioiTinh == null) {
//      return "Không rõ";
//    }
//    return gioiTinh ? "Nữ" : "Nam";
//  }

}