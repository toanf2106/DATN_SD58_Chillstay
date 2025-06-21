package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.datn_chillstay_2025.Dto.NhanVienDto;
import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.example.datn_chillstay_2025.Entity.NhanVien;
import org.example.datn_chillstay_2025.Entity.TaiKhoan;
import org.example.datn_chillstay_2025.Repository.NhanVienRepo;
import org.example.datn_chillstay_2025.Repository.TaiKhoanRepo;
import org.example.datn_chillstay_2025.Service.NhanVienService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {

  @Override
  public NhanVienDto getNhanVienById(int id) {
    return nhanVienRepo.findById(id)
        .map(nhanVien -> modelMapper.map(nhanVien, NhanVienDto.class))
        .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại với ID: " + id));
  }

  @Override
  public Page<NhanVienDto> getAllDto(int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    return nhanVienRepo.findAll(pageRequest)
        .map(nhanVien -> modelMapper.map(nhanVien, NhanVienDto.class));
  }

  @Override
  public void restore(Integer id) {
    Optional<NhanVien> nhanVienOptional = nhanVienRepo.findById(id);
    if (nhanVienOptional.isPresent()) {
      NhanVien nhanVien = nhanVienOptional.get();
      nhanVien.setTrangThai(true);
      nhanVienRepo.save(nhanVien);
    } else {
      throw new RuntimeException("Nhân viên không tồn tại với ID: " + id);
    }
  }

  @Override
  public void delete(Integer id) {
    Optional<NhanVien> nhanVienOptional = nhanVienRepo.findById(id);
    if (nhanVienOptional.isPresent()) {
      NhanVien nhanVien = nhanVienOptional.get();
      nhanVien.setTrangThai(false);
      nhanVienRepo.save(nhanVien);
    } else {
      throw new RuntimeException("Nhân viên không tồn tại với ID: " + id);
    }
  }

  private final NhanVienRepo nhanVienRepo;
private final TaiKhoanRepo taiKhoanRepo;
private final ModelMapper modelMapper;

  public NhanVienServiceImpl(NhanVienRepo nhanVienRepo, TaiKhoanRepo taiKhoanRepo,
      ModelMapper modelMapper) {
    this.nhanVienRepo = nhanVienRepo;
    this.taiKhoanRepo = taiKhoanRepo;
    this.modelMapper = modelMapper;
  }

  @Override
    public List<NhanVienDto> getAll() {
        return nhanVienRepo.findAll().stream()
                .map(nhanVien -> modelMapper.map(nhanVien, NhanVienDto.class))
                .collect(Collectors.toList());
    }

}
