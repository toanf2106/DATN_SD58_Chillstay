package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Dto.DichVuDto;
import org.example.datn_chillstay_2025.Entity.DichVu;
import org.example.datn_chillstay_2025.Repository.DichVURepo;
import org.example.datn_chillstay_2025.Service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVURepo repository;

    @Override
    public List<DichVuDto> getList() {
        return repository.findAll().stream().map(d -> new DichVuDto(
                d.getId(),
                d.getHomestayID(),
                d.getMaDichVu(),
                d.getTenDichVu(),
                d.getMoTa(),
                d.getGia(),
                d.getDonVi(),
                d.isTrangThai() ? 1 : 0
        )).collect(Collectors.toList());
    }

    @Override
    public void saveDichVu(DichVu quest) {
        DichVu k = new DichVu();
        k.setHomestayID(quest.getHomestayID());
        k.setMaDichVu(quest.getMaDichVu());
        k.setTenDichVu(quest.getTenDichVu());
        k.setMoTa(quest.getMoTa());
        k.setGia(quest.getGia());
        k.setDonVi(quest.getDonVi());
        k.setTrangThai(quest.isTrangThai());
        repository.save(k);

    }

    @Override
    public void deleteDichVu(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("khong tim thay id la" + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void updateDichVu(Integer id, DichVu quest) {
        DichVu k = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy  ID: " + id));

        k.setHomestayID(quest.getHomestayID());
        k.setMaDichVu(quest.getMaDichVu());
        k.setTenDichVu(quest.getTenDichVu());
        k.setMoTa(quest.getMoTa());
        k.setGia(quest.getGia());
        k.setDonVi(quest.getDonVi());
        k.setTrangThai(quest.isTrangThai());
        repository.save(k);
    }
}
