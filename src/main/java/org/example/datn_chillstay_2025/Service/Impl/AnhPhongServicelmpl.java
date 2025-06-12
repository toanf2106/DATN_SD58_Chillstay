package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Entity.AnhPhong;
import org.example.datn_chillstay_2025.Repository.AnhPhongRepo;
import org.example.datn_chillstay_2025.Service.AnhPhongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnhPhongServicelmpl implements AnhPhongService {
    public final AnhPhongRepo anhPhongRepo;
    public final ModelMapper modelMapper;

    public AnhPhongServicelmpl(AnhPhongRepo anhPhongRepo, ModelMapper modelMapper) {
        this.anhPhongRepo = anhPhongRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AnhPhong> getAllAnhPhong() {
        return anhPhongRepo.findAll();
    }

    @Override
    public AnhPhong getAnhPhongById(Integer id) {
        return anhPhongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay anh phong voi ID: " + id));
    }

    @Override
    public AnhPhong addAnhPhong(AnhPhong anhPhong) {
        return anhPhongRepo.save(anhPhong);
    }

    @Override
    public AnhPhong updateAnhPhong(AnhPhong anhPhong, Integer id) {
        Optional<AnhPhong> existingAnhPhong = anhPhongRepo.findById(id);
        if (existingAnhPhong.isPresent()) {
            AnhPhong updatedAnhPhong = existingAnhPhong.get();
            updatedAnhPhong.setIdphong(anhPhong.getIdphong());
            updatedAnhPhong.setDuongDanAnh(anhPhong.getDuongDanAnh());
//            updatedAnhPhong.setNgayUpload(anhPhong.getNgayUpload());
            updatedAnhPhong.setTrangThai(anhPhong.getTrangThai());
            // Add any other fields that need to be updated
            return anhPhongRepo.save(updatedAnhPhong);
        } else {
            throw new RuntimeException("Khong tim thay anh phong voi ID: " + id);
        }

    }

    @Override
    public void deleteAnhPhong(Integer id) {
            Optional<AnhPhong> anhPhong = anhPhongRepo.findById(id);
            if (anhPhong.isPresent()) {
                AnhPhong existingAnhPhong = anhPhong.get();
                existingAnhPhong.setTrangThai(false);
                anhPhongRepo.save(existingAnhPhong);
            } else {
                throw new RuntimeException("Khong tim thay anh phong voi ID: " + id);
            }
    }

}
