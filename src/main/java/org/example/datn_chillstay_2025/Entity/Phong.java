package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Phong")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "LoaiPhong_ID", nullable = false)
    private LoaiPhong idloaiPhong;


    @ManyToOne
    @JoinColumn(name = "HomeStay_ID", nullable = false)
    private HomeStay idhomeStay;

    @Size(max = 50)

    @Nationalized
    @Column(name = "Ma_Phong", nullable = false, length = 50)
    private String maPhong;

    @Size(max = 100)

    @Nationalized
    @Column(name = "Ten_Phong", nullable = false, length = 100)
    private String tenPhong;

    @Column(name = "Dien_Tich", precision = 10, scale = 2)
    private BigDecimal dienTich;

    @Nationalized
    @Lob
    @Column(name = "Mo_Ta")
    private String moTa;

    @Column(name = "Tang_So")
    private Integer tangSo;

    @Column(name = "So_Nguoi_Toi_Da")
    private Integer soNguoiToiDa;

    @Column(name = "Ngay_Tao")
    private LocalDate ngayTao;

    @Column(name = "Ngay_Update")
    private LocalDate ngayUpdate;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Trang_Thai", nullable = false)
    private Boolean trangThai = false;

}