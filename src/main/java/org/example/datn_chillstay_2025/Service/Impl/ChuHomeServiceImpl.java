package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.example.datn_chillstay_2025.Entity.ChuHomeStay;
import org.example.datn_chillstay_2025.Repository.ChuHomeRepo;
import org.example.datn_chillstay_2025.Service.ChuHomeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ChuHomeServiceImpl implements ChuHomeService {

  @Override
  public List<ChuHomeStay> getAllChuHomes() {
    return chuHomeRepo.findAll();
  }

  @Override
  public ChuHomeStay getChuHomeById(Integer id) {
    return chuHomeRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Khong Tim Thay Chu Home voi ID: " + id));
  }

  @Override
  public ChuHomeStay saveChuHome(ChuHomeStay chuHome) {
    return chuHomeRepo.save(chuHome);
  }

  @Override
  public ChuHomeStay updateChuHome(Integer id, ChuHomeStay chuHome) {
    Optional<ChuHomeStay> existingChuHome = chuHomeRepo.findById(id);
    if (existingChuHome.isPresent()) {
      ChuHomeStay updatedChuHome = existingChuHome.get();
      updatedChuHome.setHotenChuHomestay(chuHome.getHotenChuHomestay());
      updatedChuHome.setDiaChi(chuHome.getDiaChi());
      updatedChuHome.setSoDienThoai(chuHome.getSoDienThoai());
      updatedChuHome.setQueQuan(chuHome.getQueQuan());
      updatedChuHome.setGioiTinh(chuHome.getGioiTinh());
      updatedChuHome.setTrangThai(chuHome.getTrangThai());
      return chuHomeRepo.save(updatedChuHome);
    } else {
      throw new RuntimeException("Khong Tim Thay Chu Home voi ID: " + id);
    }
  }

  @Override
  public void deleteChuHome(Integer id) {
    Optional<ChuHomeStay> chuHome = chuHomeRepo.findById(id);
    if (chuHome.isPresent()) {
      ChuHomeStay existingChuHome = chuHome.get();
      existingChuHome.setTrangThai(false); // Set trangThai to false instead of deleting
      chuHomeRepo.save(existingChuHome); // Save the updated ChuHome
    } else {
      throw new RuntimeException("Khong Tim Thay Chu Home voi ID: " + id);
    }
  }

  public final ChuHomeRepo chuHomeRepo;
  public final ModelMapper modelMapper;


  public ChuHomeServiceImpl(ChuHomeRepo chuHomeRepo, ModelMapper modelMapper) {
    this.chuHomeRepo = chuHomeRepo;
    this.modelMapper = modelMapper;
  }
}
