package org.example.datn_chillstay_2025.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnhTinTucResponseDto {
    private Integer id;
    private Integer tinTucId;
    private String duongDanAnh;
    private Boolean trangThai;
}
