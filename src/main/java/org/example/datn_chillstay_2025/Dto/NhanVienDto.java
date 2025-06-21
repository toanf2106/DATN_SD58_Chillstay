package org.example.datn_chillstay_2025.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVienDto {

  private Integer id;
  private String maNhanVien;
  private String hoTen;
  private String soDienThoai;
  private String email;
  private String diaChi;
  private Boolean gioiTinh;
  private String ngayVaoLam;
  private String ngayNghiLam;
  private Integer taiKhoanId;
  private String anh;
  private Boolean trangThai;


}
