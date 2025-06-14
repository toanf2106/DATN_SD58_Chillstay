package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Dto.KhachHangDto;
import org.example.datn_chillstay_2025.Entity.KhachHang;
import org.example.datn_chillstay_2025.Repository.KhachHangRepo;
import org.example.datn_chillstay_2025.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepo repository;

    @Override
    public List<KhachHangDto> getList() {
        return repository.findAll().stream().map(d-> new KhachHangDto(
                d.getId(),
                d.getTaikhoanID(),
                d.getMaKhachHang(),
                d.getTenKhachHang(),
                d.getsDT(),
                d.getEmail(),
                d.getDiaChi(),
                d.getNgaySinh(),
                d.isGioiTinh() ? 1 : 0,
                d.getAnh(),
                d.isTrangThai()? 1 : 0
        )).collect(Collectors.toList());
    }
    @Override
    public void saveKhachHang(KhachHang quest){
        KhachHang k= new KhachHang();
        k.setTaikhoanID(quest.getTaikhoanID());
        k.setMaKhachHang(quest.getMaKhachHang());
        k.setTenKhachHang(quest.getTenKhachHang());
        k.setsDT(quest.getsDT());
        k.setEmail(quest.getEmail());
        k.setDiaChi(quest.getDiaChi());
        k.setNgaySinh(quest.getNgaySinh());
        k.setGioiTinh(quest.isGioiTinh());
        k.setAnh(quest.getAnh());
        k.setTrangThai(quest.isTrangThai());
        repository.save(k);

    }
    @Override
    public void deleteKhachHang(Integer id){
        if (!repository.existsById(id)){
            throw new RuntimeException("khong tim thay id la" + id);
        }
        repository.deleteById(id);
    }
    @Override
    public void updateKhachHang(Integer id, KhachHang quest) {
        KhachHang existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng với ID: " + id));

        existing.setTaikhoanID(quest.getTaikhoanID());
        existing.setMaKhachHang(quest.getMaKhachHang());
        existing.setTenKhachHang(quest.getTenKhachHang());
        existing.setsDT(quest.getsDT());
        existing.setEmail(quest.getEmail());
        existing.setDiaChi(quest.getDiaChi());
        existing.setNgaySinh(quest.getNgaySinh());
        existing.setGioiTinh(quest.isGioiTinh());
        existing.setAnh(quest.getAnh());
        existing.setTrangThai(quest.isTrangThai());

        repository.save(existing);
    }
}
