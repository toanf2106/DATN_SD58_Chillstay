package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class HomeStay {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Ma_HomeStay", nullable = false, length = 50)
    private String maHomestay;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Ten_HomeStay", nullable = false, length = 100)
    private String tenHomestay;

    @Nationalized
    @Lob
    @Column(name = "Hinh_Anh")
    private String hinhAnh;

    @Column(name = "Dien_Tich", precision = 10, scale = 2)
    private BigDecimal dienTich;

    @NotNull
    @Column(name = "Gia_Ca_HomeStay", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaCaHomestay;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Tinh_Trang", length = 50)
    private String tinhTrang;

    @Nationalized
    @Lob
    @Column(name = "Dia_Chi")
    private String diaChi;

    @Column(name = "Ngay_Tao")
    private LocalDate ngayTao;

    @Column(name = "Ngay_Update")
    private LocalDate ngayUpdate;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Trang_Thai", nullable = false)
    private Boolean trangThai = false;

}