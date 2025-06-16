package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.example.datn_chillstay_2025.Entity.NhanVien;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Repository.NhanVienRepo;
import org.example.datn_chillstay_2025.Repository.TaiKhoanRepo;
import org.example.datn_chillstay_2025.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepo nhanVienRepo;

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Override
    public List<NhanVienResponseDto> getAll() {
        return nhanVienRepo.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public NhanVienResponseDto add(NhanVienRequestDto dto) {
        if (nhanVienRepo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }
        if (nhanVienRepo.existsBySoDienThoai(dto.getSoDienThoai())) {
            throw new RuntimeException("Số điện thoại đã tồn tại");
        }
        if (nhanVienRepo.existsByTaiKhoan_Id(dto.getTaiKhoanId())) {
            throw new RuntimeException("Tài khoản đã được gán cho một nhân viên khác");
        }
        TaiKhoan taiKhoan = taiKhoanRepo.findById(dto.getTaiKhoanId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

        NhanVien nv = NhanVien.builder()
                .hoTen(dto.getHoTen())
                .soDienThoai(dto.getSoDienThoai())
                .email(dto.getEmail())
                .diaChi(dto.getDiaChi())
                .ngayVaoLam(dto.getNgayVaoLam())
                .gioiTinh(dto.getGioiTinh())
                .trangThai(dto.getTrangThai())
                .ngayNghiLam(dto.getNgayNghiLam())
                .anh(dto.getAnh())

                .taiKhoan(taiKhoan)

                .build();

        return toResponseDto(nhanVienRepo.save(nv));
    }

    @Override
    public NhanVienResponseDto update(Integer id, NhanVienRequestDto dto) {
        NhanVien nv = nhanVienRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));

        TaiKhoan taiKhoan = taiKhoanRepo.findById(dto.getTaiKhoanId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

        nv.setHoTen(dto.getHoTen());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setEmail(dto.getEmail());
        nv.setDiaChi(dto.getDiaChi());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setTrangThai(dto.getTrangThai());
        nv.setTaiKhoan(taiKhoan);
        nv.setNgayNghiLam(dto.getNgayNghiLam());
        nv.setAnh(dto.getAnh());


        return toResponseDto(nhanVienRepo.save(nv));
    }

    @Override
    public void delete(Integer id) {
        nhanVienRepo.deleteById(id);
    }

    @Override
    public NhanVienResponseDto detailNhanVien(Integer id) {
        NhanVien nv = nhanVienRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
        return toResponseDto(nv);
    }

    private NhanVienResponseDto toResponseDto(NhanVien nv) {
        return NhanVienResponseDto.builder()
                .id(nv.getId())
                .maNhanVien(nv.getMaNhanVien())
                .hoTen(nv.getHoTen())
                .soDienThoai(nv.getSoDienThoai())
                .email(nv.getEmail())
                .diaChi(nv.getDiaChi())
                .ngayVaoLam(nv.getNgayVaoLam())
                .gioiTinh(nv.getGioiTinh())
                .trangThai(nv.getTrangThai())
                .taiKhoanId(nv.getTaiKhoan().getId())
                .ngayNghiLam(nv.getNgayNghiLam())
                .anh(nv.getAnh())
                .build();
    }
}
