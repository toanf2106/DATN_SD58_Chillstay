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

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LoaiHomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Ten_Loai_HomeStay", nullable = false, length = 100)
    private String tenLoaiHomestay;

    @Nationalized
    @Lob
    @Column(name = "Mo_Ta")
    private String moTa;

    @ColumnDefault("getdate()")
    @Column(name = "Ngay_Tao")
    private LocalDate ngayTao;

    @Column(name = "Ngay_Update")
    private LocalDate ngayUpdate;

    @Column(name = "Trang_Thai")
    private boolean trangThai;

}