package org.example.datn_chillstay_2025.Dto;

import java.math.BigDecimal;


public class DichVuDto {
    private int id;
    private int homestayID;
    private String maDichVu;
    private String tenDichVu;
    private String moTa;
    private BigDecimal gia;
    private String donVi;
    private int trangThai;

    public DichVuDto() {
    }

    public DichVuDto(int id, int homestayID, String maDichVu, String tenDichVu, String moTa, BigDecimal gia, String donVi, int trangThai) {
        this.id = id;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
