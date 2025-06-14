package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="TaiKhoan_ID")
    private int taikhoanID;
    @Column(name="Ma_Khach_Hang")
    private String maKhachHang;
    @Column(name="Ho_Ten")
    private String tenKhachHang;
    @Column(name="So_Dien_Thoai")
    private String sDT ;
    @Column(name="Email")
    private String email ;
    @Column(name="Dia_Chi")
    private String diaChi;
    @Column(name="Ngay_Sinh")
    private String ngaySinh ;
    @Column(name="Gioi_Tinh")
    private boolean gioiTinh;
    @Column(name="Anh")
    private String anh ;
    @Column(name="Trang_Thai")
    private boolean trangThai ;

    public KhachHang() {
    }

    public KhachHang(int id, int taikhoanID, String maKhachHang, String tenKhachHang, String sDT, String email, String diaChi, String ngaySinh, boolean gioiTinh, String anh, boolean trangThai) {
        this.id = id;
        this.taikhoanID = taikhoanID;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    public KhachHang(int taikhoanID, String maKhachHang, String tenKhachHang, String sDT, String email, String diaChi, String ngaySinh, boolean gioiTinh, String anh, boolean trangThai) {
        this.taikhoanID = taikhoanID;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.anh = anh;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
