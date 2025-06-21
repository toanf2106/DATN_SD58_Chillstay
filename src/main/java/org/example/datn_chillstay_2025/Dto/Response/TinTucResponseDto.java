package org.example.datn_chillstay_2025.Dto.Response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinTucResponseDto {
    private Integer id;
    private String maTinTuc;
    private String noiDung;
    private Boolean trangThai;
    private Date ngayDang;
    private Integer nhanVienId;
    private String anhBia;

}
