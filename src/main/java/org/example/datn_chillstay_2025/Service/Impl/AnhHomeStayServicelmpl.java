package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Entity.AnhHomeStay;
import org.example.datn_chillstay_2025.Repository.AnhHomeStayRepo;
import org.example.datn_chillstay_2025.Service.AnhHomeStayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnhHomeStayServicelmpl implements AnhHomeStayService {

    private final AnhHomeStayRepo anhHomeStayRepo;
    private final ModelMapper modelMapper;

    public AnhHomeStayServicelmpl(AnhHomeStayRepo anhHomeStayRepo, ModelMapper modelMapper) {
        this.anhHomeStayRepo = anhHomeStayRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AnhHomeStay> getAllAnhHomeStay() {
        return anhHomeStayRepo.findAll();
    }

    @Override
    public AnhHomeStay getAnhHomeStayById(Integer id) {
        return anhHomeStayRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("AnhHomeStay with id " + id + " not found"));
    }

    @Override
    public AnhHomeStay addAnhHomeStay(AnhHomeStay anhHomeStay) {
        return anhHomeStayRepo.save(anhHomeStay);
    }

    @Override
    public AnhHomeStay updateAnhHomeStay(AnhHomeStay anhHomeStay, Integer id) {
        Optional<AnhHomeStay> optional = anhHomeStayRepo.findById(id);
        if (optional.isPresent()) {
            AnhHomeStay existingAnhHomeStay = optional.get();
            existingAnhHomeStay.setIdHomeStay(anhHomeStay.getIdHomeStay());
            existingAnhHomeStay.setDuongDanAnh(anhHomeStay.getDuongDanAnh());
//            existingAnhHomeStay.setNgayUpload(anhHomeStay.getNgayUpload());
            existingAnhHomeStay.setTrangThai(anhHomeStay.getTrangThai());
            return anhHomeStayRepo.save(existingAnhHomeStay);
        } else {
            throw new RuntimeException("AnhHomeStay with id " + id + " not found");
        }

    }

    @Override
    public void deleteAnhHomeStay(Integer id) {
        Optional<AnhHomeStay> optional = anhHomeStayRepo.findById(id);
        if (optional.isPresent()) {
            AnhHomeStay existingAnhHomeStay = optional.get();
            existingAnhHomeStay.setTrangThai(false);
            anhHomeStayRepo.save(existingAnhHomeStay);
        } else {
            throw new RuntimeException("AnhHomeStay voi id " + id + " khong tim thay");
        }
    }
}
