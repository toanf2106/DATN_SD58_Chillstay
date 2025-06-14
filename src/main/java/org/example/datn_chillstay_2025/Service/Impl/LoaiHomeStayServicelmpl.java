package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.example.datn_chillstay_2025.Entity.LoaiHomeStay;

import org.example.datn_chillstay_2025.Repository.LoaiHomeStayRepo;

import org.example.datn_chillstay_2025.Service.LoaiHomeStayService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LoaiHomeStayServicelmpl implements LoaiHomeStayService {

  private final LoaiHomeStayRepo loaiHomeStayRepo;
  private final ModelMapper modelMapper;

  public LoaiHomeStayServicelmpl(LoaiHomeStayRepo loaiHomeStayRepo, ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
    this.loaiHomeStayRepo = loaiHomeStayRepo;
  }
  @Override
  public List<LoaiHomeStay> getAllLoaiHomeStay() {
    return loaiHomeStayRepo.findAll();
  }

  @Override
  public LoaiHomeStay getLoaiHomeStayById(int id) {
    return loaiHomeStayRepo.findById(id).get();
  }

  @Override
  public LoaiHomeStay addLoaiHomeStay(LoaiHomeStay loaiHomeStay) {
    return loaiHomeStayRepo.save(loaiHomeStay);
  }


  @Override
  public LoaiHomeStay updateLoaiHomeStay(LoaiHomeStay loaiHomeStay,Integer id) {
    Optional<LoaiHomeStay> optional = loaiHomeStayRepo.findById(id);
    if (optional.isPresent()) {
      LoaiHomeStay loaiHomeStay1 = optional.get();
      loaiHomeStay1.setTenLoaiHomestay(loaiHomeStay.getTenLoaiHomestay());
      loaiHomeStay1.setMoTa(loaiHomeStay.getMoTa());
      loaiHomeStay1.setNgayTao(loaiHomeStay.getNgayTao());
//      loaiHomeStay1.setNgayUpdate(loaiHomeStay.getNgayUpdate());
      return loaiHomeStayRepo.save(loaiHomeStay1);
    }else {
      throw new RuntimeException("LoaiHomeStay id not found");
    }
  }

  @Override
  public void DeleteLoaiHomestay(int id) {
    Optional<LoaiHomeStay> optional = loaiHomeStayRepo.findById(id);
    if (optional.isPresent()) {
      LoaiHomeStay loaiHomeStay = optional.get();
      loaiHomeStay.setTrangThai(false);
      loaiHomeStayRepo.save(loaiHomeStay);
    } else {
      throw new RuntimeException("Loai Home Stay Not Found");
    }
  }

  @Override
  public LoaiHomeStay getLoaiHomeStayByTen(String tenLoaiHomestay) {
    return loaiHomeStayRepo.findByTenLoaiHomestay(tenLoaiHomestay)
        .orElseThrow(() -> new RuntimeException("LoaiHomeStay Not Found"));
  }
}