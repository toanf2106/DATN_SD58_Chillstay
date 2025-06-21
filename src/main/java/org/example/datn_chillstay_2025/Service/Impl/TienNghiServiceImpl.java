package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.example.datn_chillstay_2025.Repository.TienNghiRepo;
import org.example.datn_chillstay_2025.Service.TienNghiService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TienNghiServiceImpl implements TienNghiService {

  private final TienNghiRepo tienNghiRepo;
  private final ModelMapper modelMapper;

  public TienNghiServiceImpl(TienNghiRepo tienNghiRepo, ModelMapper modelMapper) {
    this.tienNghiRepo = tienNghiRepo;
    this.modelMapper = modelMapper;
  }


  @Override
  public List<TienNghi> getTienNghi() {
    return tienNghiRepo.findAll();
  }

  @Override
  public TienNghi getTienNghiById(int id) {
    return tienNghiRepo.findById(id).get();
  }

  @Override
  public void DeleteTienNghiById(int id) {
    Optional<TienNghi> optional = tienNghiRepo.findById(id);
    if (optional.isPresent()) {
      TienNghi tienNghi = optional.get();
      tienNghi.setTrangThai(false);
      tienNghiRepo.save(tienNghi);
    } else {
      throw new RuntimeException("Tien Nghi Not Found");
    }
  }


  @Override
  public TienNghi addTienNghi(TienNghi tienNghi) {
    return tienNghiRepo.save(tienNghi);
  }

  @Override
  public TienNghi updateTienNghi(TienNghi tienNghi, Integer id) {
    Optional<TienNghi> optional = tienNghiRepo.findById(id);
    if (optional.isPresent()) {
      TienNghi tienNghi1 = optional.get();
      tienNghi1.setTenTienNghi(tienNghi.getTenTienNghi());
      tienNghi1.setMoTa(tienNghi.getMoTa());
      tienNghi1.setDonVi(tienNghi.getDonVi());
      tienNghi1.setTrangThai(tienNghi.isTrangThai());
      return tienNghiRepo.save(tienNghi1);
    }else {
      throw new RuntimeException("Tien Nghi Not Found");
    }
  }

  @Override
  public TienNghi getTienNghiByTen(String tenTienNghi) {
    return tienNghiRepo.findByTenTienNghi(tenTienNghi)
        .orElseThrow(() -> new RuntimeException("Tien Nghi Not Found"));
  }
  @Override
  public Page<TienNghi> searchTienNghi(String keyword, Boolean status, Pageable pageable) {
    // QUAN TRỌNG: Phải truyền `pageable` vào hàm của repository
    return tienNghiRepo.searchAndFilter(keyword, status, pageable);
  }

}
