package org.example.datn_chillstay_2025.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRequestDto {
    private String maNhanVien;

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "0\\d{9}", message = "Số điện thoại không hợp lệ")
    private String soDienThoai;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    private String diaChi;
    private Date ngayVaoLam;
    private Boolean gioiTinh;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

    @NotNull(message = "ID tài khoản không được để trống")
    private Integer taiKhoanId;
    private Date ngayNghiLam;

    @Size(max = 1000)
    private String anh;



}
