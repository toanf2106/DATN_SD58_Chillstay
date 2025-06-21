  package org.example.datn_chillstay_2025.Service.Impl;

  import java.util.List;
  import java.util.Optional;
  import java.util.stream.Collectors;
  import org.example.datn_chillstay_2025.Dto.HomeStayDto;
  import org.example.datn_chillstay_2025.Entity.HomeStay;
  import org.example.datn_chillstay_2025.Entity.TienNghi;
  import org.example.datn_chillstay_2025.Repository.HomeStayRepo;
  import org.example.datn_chillstay_2025.Repository.TienNghiRepo;
  import org.example.datn_chillstay_2025.Service.HomeStayService;
  import org.example.datn_chillstay_2025.Service.TienNghiService;
  import org.modelmapper.ModelMapper;
  import org.springframework.data.domain.Page;
  import org.springframework.data.domain.Pageable;
  import org.springframework.stereotype.Service;

  @Service
  public class HomeStayServiceImpl implements HomeStayService {
    private final HomeStayRepo homeStayRepo;
    private final ModelMapper modelMapper;


    public HomeStayServiceImpl(HomeStayRepo homeStayRepo, ModelMapper modelMapper) {
      this.homeStayRepo = homeStayRepo;
      this.modelMapper = modelMapper;
    }
  //  @Override
  //  public HomeStayDto getHomeStayByTenHomestayDto(String ten) {
  //    return homeStayRepo.findByTenHomestay(ten).map(homeStay -> modelMapper.map(homeStay, HomeStayDto.class))
  //        .orElse(null);
  //  }

    @Override
    public HomeStayDto getHomeStayByIdDto(int id) {
      return homeStayRepo.findById(id)
          .map(homeStay -> modelMapper.map(homeStay, HomeStayDto.class))
          .orElse(null);
    }

    @Override
    public List<HomeStayDto> getAllHomeStays() {
      return homeStayRepo.findAll().stream()
          .map(homeStay -> modelMapper.map(homeStay, HomeStayDto.class)).collect(Collectors.toList());

    }

    @Override
    public HomeStay getHomeStayById(int id) {
      return homeStayRepo.findById(id).orElse(null);
    }

    @Override
    public HomeStay addHomeStay(HomeStay homeStay) {
      return homeStayRepo.save(homeStay);

    }

    @Override
    public HomeStay updateHomeStay(HomeStay homeStay, int id) {
  Optional<HomeStay> optional = homeStayRepo.findById(id);
      if (optional.isPresent()) {
        HomeStay existingHomeStay = optional.get();
        existingHomeStay.setChuHomeStay(homeStay.getChuHomeStay());
        existingHomeStay.setLoaiHomeStay(homeStay.getLoaiHomeStay());
        existingHomeStay.setTenHomestay(homeStay.getTenHomestay());
        existingHomeStay.setDienTich(homeStay.getDienTich());
        existingHomeStay.setHinhAnh(homeStay.getHinhAnh());
        existingHomeStay.setDienTich(homeStay.getDienTich());
        existingHomeStay.setGiaCaHomestay(homeStay.getGiaCaHomestay());
        existingHomeStay.setTinhTrang(homeStay.getTinhTrang());
        existingHomeStay.setDiaChi(homeStay.getDiaChi());
        existingHomeStay.setTrangThai(homeStay.getTrangThai());
        return homeStayRepo.save(existingHomeStay);
      } else {
        throw new RuntimeException("Khong Tim Thay");
      }
    }

    @Override
    public void deleteHomeStay(int id) {
  Optional<HomeStay> homeStay = homeStayRepo.findById(id);
      if (homeStay.isPresent()) {
        HomeStay homeStayToDelete = homeStay.get();
        homeStayToDelete.setTrangThai(false); // Set trangThai to false instead of deleting
        homeStayRepo.save(homeStayToDelete); // Save the updated entity
      } else {
        throw new RuntimeException("Khong Tim Thay");
      }
    }



  }
