package org.example.datn_chillstay_2025.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinTucRequestDto {
    @Size(max = 50)
    private String maTinTuc;

    @NotBlank(message = "Nội dung không được để trống")
    private String noiDung;

    @Size(max = 500, message = "Đường dẫn ảnh bìa quá dài")
    private String anhBia;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

    @NotNull(message = "ID nhân viên không được để trống")
    private Integer nhanVienId;
}
