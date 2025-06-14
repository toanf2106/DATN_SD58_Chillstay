package org.example.datn_chillstay_2025.Dto;

public class KhachHangDto {
    private int id;
    private int taikhoanID;
    private String maKhachHang;
    private String tenKhachHang;
    private String sDT ;
    private String email ;
    private String diaChi;
    private String ngaySinh ;
    private  int gioiTinh;
    private String anh ;
    private int trangThai;

    public KhachHangDto() {
    }

    public KhachHangDto(int id, int taikhoanID, String maKhachHang, String tenKhachHang, String sDT, String email, String diaChi, String ngaySinh, int gioiTinh, String anh, int trangThai) {
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

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
