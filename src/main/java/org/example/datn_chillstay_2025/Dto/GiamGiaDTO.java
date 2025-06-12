package org.example.datn_chillstay_2025.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiamGiaDTO {

    private Integer id;
    private String maGiamGia;
    private String loaiGiamGia;
    private BigDecimal giaTri;
    private Integer homeStayId;
    private BigDecimal giaTriToiThieu;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Integer soLuong;
    private Boolean trangThai;
}
