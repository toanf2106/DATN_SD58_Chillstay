package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.example.datn_chillstay_2025.Entity.ChuHomeStay;
import org.example.datn_chillstay_2025.Entity.LoaiHomeStay;
import org.example.datn_chillstay_2025.Repository.ChuHomeRepo;
import org.example.datn_chillstay_2025.Repository.LoaiHomeStayRepo;
import org.example.datn_chillstay_2025.Service.ChuHomeService;
import org.example.datn_chillstay_2025.Service.LoaiHomeStayService;
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

  @Service
  public static class LoaiHomeStayServicelmpl implements LoaiHomeStayService {
      private LoaiHomeStayRepo loaiHomeStayRepo;
      private ModelMapper modelMapper;

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
//              loaiHomeStay1.setNgayUpdate(loaiHomeStay.getNgayUpdate());
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
}
