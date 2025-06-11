package org.example.datn_chillstay_2025.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
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
public class AnhHomeStay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "HomeStay_ID", nullable = false)
    private HomeStay idHomeStay;

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