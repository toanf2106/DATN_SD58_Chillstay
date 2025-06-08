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

@Getter
@Setter
@Entity
public class LoaiPhong {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Ma_Loai_Phong", nullable = false, length = 50)
    private String maLoaiPhong;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Ten_Loai_Phong", nullable = false, length = 100)
    private String tenLoaiPhong;

    @Nationalized
    @Lob
    @Column(name = "Mo_Ta")
    private String moTa;

    @Column(name = "So_Luong")
    private Integer soLuong;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Trang_Thai", nullable = false)
    private Boolean trangThai = false;

}