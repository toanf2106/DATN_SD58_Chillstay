package org.example.datn_chillstay_2025.Dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeStayDto {

  private Integer id;

  private Integer idLoaiHomeStay;
  private String tenLoaiHomestay;

  private Integer idChuHomeStay;
  private String hotenChuHomestay;

  private String maHomestay;

  private String tenHomestay;

  private String hinhAnh;

  private BigDecimal dienTich;

  private BigDecimal giaCaHomestay;

  private String tinhTrang;

  private String diaChi;

  private Date ngayTao;

  private Date ngayUpdate;

  private Boolean trangThai;

}
