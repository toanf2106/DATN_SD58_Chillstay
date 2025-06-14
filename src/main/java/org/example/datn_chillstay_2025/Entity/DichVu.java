package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DichVu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="HomeStay_ID")
    private int homestayID;
    @Column(name="Ma_Dich_Vu")
    private String maDichVu;
    @Column(name="Ten_Dich_Vu")
    private String tenDichVu;
    @Column(name="Mo_Ta")
    private String moTa ;
    @Column(name="Gia")
    private BigDecimal gia  ;
    @Column(name="Don_Vi")
    private String donVi;
    @Column(name = "Trang_Thai")
    private boolean trangThai  ;

    public DichVu() {
    }

    public DichVu(int id, int homestayID, String maDichVu, String tenDichVu, String moTa, BigDecimal gia, String donVi, boolean trangThai) {
        this.id = id;
        this.homestayID = homestayID;
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.gia = gia;
        this.donVi = donVi;
        this.trangThai = trangThai;
    }

    public DichVu(int homestayID, String maDichVu, String tenDichVu, String moTa, BigDecimal gia, String donVi, boolean trangThai) {
        this.homestayID = homestayID;
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.gia = gia;
        this.donVi = donVi;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomestayID() {
        return homestayID;
    }

    public void setHomestayID(int homestayID) {
        this.homestayID = homestayID;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
