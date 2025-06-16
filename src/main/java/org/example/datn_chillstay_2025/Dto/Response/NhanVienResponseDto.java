package org.example.datn_chillstay_2025.Dto.Response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NhanVienResponseDto {
    private Integer id;
    private String maNhanVien;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngayVaoLam;
    private Boolean gioiTinh;
    private Boolean trangThai;
    private Integer taiKhoanId;
    private Date ngayNghiLam;
    private String anh;

}
