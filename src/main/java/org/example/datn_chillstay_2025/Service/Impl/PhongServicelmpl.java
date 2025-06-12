package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Entity.Phong;
import org.example.datn_chillstay_2025.Repository.PhongRepo;
import org.example.datn_chillstay_2025.Service.PhongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongServicelmpl implements PhongService {

    private final PhongRepo phongRepo;
    private final ModelMapper modelMapper;

    public PhongServicelmpl(PhongRepo phongRepo, ModelMapper modelMapper) {
        this.phongRepo = phongRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Phong> getAllPhong() {
        return phongRepo.findAll();
    }

    @Override
    public Phong getPhongById(Integer id) {
        return phongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Phong with id " + id + " not found"));
    }

    @Override
    public Phong addPhong(Phong phong) {
        return phongRepo.save(phong);
    }

    @Override
    public Phong updatePhong(Phong phong, Integer id) {
        Optional<Phong> optional = phongRepo.findById(id);
        if (optional.isPresent()) {
            Phong phong1 = optional.get();
            phong1.setIdloaiPhong(phong.getIdloaiPhong());
            phong1.setIdhomeStay(phong.getIdhomeStay());
            phong1.setTenPhong(phong.getTenPhong());
            phong1.setDienTich(phong.getDienTich());
            phong1.setMoTa(phong.getMoTa());
            phong1.setTangSo(phong.getTangSo());
            phong1.setSoNguoiToiDa(phong.getSoNguoiToiDa());
            phong1.setTrangThai(phong.getTrangThai());
            return phongRepo.save(phong1);
        } else {
            throw new RuntimeException("Phong with id " + id + " not found");
        }
    }

    @Override
    public void deletePhong(Integer id) {
        Optional<Phong> optional = phongRepo.findById(id);
        if (optional.isPresent()) {
            Phong phong = optional.get();
            phong.setTrangThai(false);
            phongRepo.save(phong);
        } else {
            throw new RuntimeException("Phong with id " + id + " not found");
        }
    }
}
