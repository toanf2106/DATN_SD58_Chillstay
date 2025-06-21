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
public class AnhTinTucRequestDto {
    @NotNull(message = "Tin tức không được để trống")
    private Integer tinTucId;

    @NotBlank(message = "Đường dẫn ảnh không được để trống")
    @Size(max = 255, message = "Đường dẫn ảnh tối đa 255 ký tự")
    private String duongDanAnh;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;
}
