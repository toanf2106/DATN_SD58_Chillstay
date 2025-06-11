package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class AnhPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Phong_ID", nullable = false)
    private Phong idphong;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "Duong_Dan_Anh", nullable = false)
    private String duongDanAnh;

    @ColumnDefault("getdate()")
    @Column(name = "Ngay_Upload")
    private LocalDate ngayUpload;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Trang_Thai", nullable = false)
    private Boolean trangThai = false;

}