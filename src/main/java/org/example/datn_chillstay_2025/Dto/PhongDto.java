package org.example.datn_chillstay_2025.Dto;

import lombok.*;
import org.example.datn_chillstay_2025.Entity.HomeStay;
import org.example.datn_chillstay_2025.Entity.LoaiPhong;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhongDto {
    private Integer id;
    private Integer idloaiPhong;
    private String maLoaiPhong;
    private Integer idhomeStay;
    private String maHomeStay;
    private String maPhong;
    private String tenPhong;
    private BigDecimal dienTich;
    private String moTa;
    private Integer tangSo;
    private Integer soNguoiToiDa;
    private LocalDate ngayTao;
    private LocalDate ngayUpdate;
    private Boolean trangThai = false;

}
