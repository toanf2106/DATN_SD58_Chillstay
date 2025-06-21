package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.example.datn_chillstay_2025.Entity.VatTu;
import org.example.datn_chillstay_2025.Repository.VatTuRepo;
import org.example.datn_chillstay_2025.Service.VatTuService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class VatTuServiceImpl implements VatTuService {

  private final VatTuRepo vatTuRepo;
  private final ModelMapper modelMapper;

  public VatTuServiceImpl(VatTuRepo vatTuRepo, ModelMapper modelMapper) {
    this.vatTuRepo = vatTuRepo;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<VatTu> findByTenOrId(String ten, Integer id) {
    if (ten == null && id == null) {
      return vatTuRepo.findAll();
    }else {

      return vatTuRepo.findByTenOrId(ten, id);}

  }

  @Override
  public void deleteVatTu(Integer id) {
    Optional<VatTu> vatTu = vatTuRepo.findById(id);
    if (vatTu.isPresent()) {
      VatTu existingVatTu = vatTu.get();
      existingVatTu.setTrangThai(false);
      vatTuRepo.save(existingVatTu);
    } else {
      throw new RuntimeException("Khong Tim Thay Vat Tu voi ID: " + id);
    }
  }

  @Override
  public void khoiPhucVatTu(Integer id) {
    Optional<VatTu> vatTu = vatTuRepo.findById(id);
    if (vatTu.isPresent()) {
      VatTu existingVatTu = vatTu.get();
      existingVatTu.setTrangThai(true);
      vatTuRepo.save(existingVatTu);
    } else {
      throw new RuntimeException("Khong Tim Thay Vat Tu voi ID: " + id);
    }
  }

  @Override
  public Page<VatTu> getVatTuByPage(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return vatTuRepo.findAll(pageable).map(vatTu -> modelMapper.map(vatTu, VatTu.class));
  }


  @Override
  public VatTu saveVatTu(VatTu vatTu) {
    return vatTuRepo.save(vatTu);
  }

  @Override
  public VatTu updateVatTu(Integer id, VatTu vatTu) {
    Optional<VatTu> existingVatTu = vatTuRepo.findById(id);
    if (existingVatTu.isPresent()) {
      VatTu updatedVatTu = existingVatTu.get();
      updatedVatTu.setTenVatTu(vatTu.getTenVatTu());
      updatedVatTu.setDonVi(vatTu.getDonVi());
      updatedVatTu.setMoTa(vatTu.getMoTa());
      return vatTuRepo.save(updatedVatTu);
    } else {
      throw new RuntimeException("Khong Tim Thay Vat Tu voi ID: " + id);
    }
  }

  @Override
  public List<VatTu> getAllVatTu() {
    return vatTuRepo.findAll();
  }

  @Override
  public VatTu getVatTuById(Integer id) {
    Optional<VatTu> vatTu = vatTuRepo.findById(id);
    if (vatTu.isPresent()) {
      return vatTu.get();
    } else {
      throw new RuntimeException("Khong Tim Thay Vat Tu voi ID: " + id);
    }
  }
}