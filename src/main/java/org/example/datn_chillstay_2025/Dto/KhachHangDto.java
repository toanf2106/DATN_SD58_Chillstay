package org.example.datn_chillstay_2025.Dto;

import java.time.LocalDate;

public class KhachHangDto {
    private int id;
    private int taikhoanID;
    private String maKhachHang;
    private String tenKhachHang;
    private String sDT ;
    private String email ;
    private int gioiTinh;
    private LocalDate ngayTao ;
    private int trangThai ;

    public KhachHangDto() {
    }

    public KhachHangDto(int id, int taikhoanID, String maKhachHang, String tenKhachHang, String sDT, String email, int gioiTinh, LocalDate ngayTao, int trangThai) {
        this.id = id;
        this.taikhoanID = taikhoanID;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sDT = sDT;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaikhoanID() {
        return taikhoanID;
    }

    public void setTaikhoanID(int taikhoanID) {
        this.taikhoanID = taikhoanID;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
