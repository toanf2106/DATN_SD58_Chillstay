package org.example.datn_chillstay_2025.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.example.datn_chillstay_2025.Dto.Request.TinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.TinTucResponseDto;
import org.example.datn_chillstay_2025.Entity.NhanVien;
import org.example.datn_chillstay_2025.Entity.TinTuc;
import org.example.datn_chillstay_2025.Repository.NhanVienRepo;
import org.example.datn_chillstay_2025.Repository.TinTucRepo;
import org.example.datn_chillstay_2025.Service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TinTucServiceImpl implements TinTucService {
    @Autowired
    private TinTucRepo tinTucRepo;
    @Autowired
    private NhanVienRepo nhanVienRepo;

    private TinTucResponseDto convertToDto(TinTuc entity) {
        TinTucResponseDto dto = new TinTucResponseDto();
        dto.setId(entity.getId());
        dto.setMaTinTuc(entity.getMaTinTuc());
        dto.setNoiDung(entity.getNoiDung());
        dto.setTrangThai(entity.getTrangThai());
        dto.setNgayDang(entity.getNgayDang());
        dto.setNhanVienId(entity.getNhanVien().getId());
        dto.setAnhBia(entity.getAnhBia());
        return dto;
    }

    @Override
    public TinTucResponseDto add(TinTucRequestDto dto) {
        NhanVien nv = nhanVienRepo.findById(dto.getNhanVienId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));

        TinTuc tinTuc = new TinTuc();
        tinTuc.setNoiDung(dto.getNoiDung());
        tinTuc.setTrangThai(dto.getTrangThai());
        tinTuc.setNgayDang(new Date());
        tinTuc.setAnhBia(dto.getAnhBia());
        tinTuc.setNhanVien(nv);

        return convertToDto(tinTucRepo.save(tinTuc));
    }

    @Override
    public TinTucResponseDto update(Integer id, TinTucRequestDto dto) {
        TinTuc tinTuc = tinTucRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin tức"));

        NhanVien nv = nhanVienRepo.findById(dto.getNhanVienId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
        tinTuc.setNoiDung(dto.getNoiDung());
        tinTuc.setTrangThai(dto.getTrangThai());
        tinTuc.setNhanVien(nv);
        tinTuc.setAnhBia(dto.getAnhBia());


        return convertToDto(tinTucRepo.save(tinTuc));
    }

    @Override
    public TinTucResponseDto detail(Integer id) {
        TinTuc tinTuc = tinTucRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin tức"));
        return convertToDto(tinTuc);
    }

    @Override
    public List<TinTucResponseDto> getAll() {
        return tinTucRepo.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        TinTuc tinTuc = tinTucRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin tức"));
        tinTucRepo.delete(tinTuc);
    }
}
