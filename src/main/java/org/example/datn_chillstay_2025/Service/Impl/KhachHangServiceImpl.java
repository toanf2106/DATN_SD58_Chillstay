package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.example.datn_chillstay_2025.Dto.KhachHangDto;
import org.example.datn_chillstay_2025.Entity.KhachHang;
import org.example.datn_chillstay_2025.Repository.KhachHangRepo;
import org.example.datn_chillstay_2025.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepo repository;

    @Override
    public List<KhachHangDto> getList() {
        return repository.findAll().stream().map(d-> new KhachHangDto(
                d.getId(),
                d.getTaiKhoan().getId(),
                d.getMaKhachHang(),
                d.getHoTen(),
                d.getSoDienThoai(),
                d.getEmail(),
                d.getGioiTinh() ? 1 : 0,
                d.getNgayTao(),
                d.getTrangThai()? 1 : 0
        )).collect(Collectors.toList());
    }
    @Override
    public void saveKhachHang(KhachHang quest){
        KhachHang k= new KhachHang();
        k.setTaiKhoan(quest.getTaiKhoan());
//        k.setMaKhachHang(quest.getMaKhachHang());
        k.setHoTen(quest.getHoTen());
        k.setSoDienThoai(quest.getSoDienThoai());
        k.setEmail(quest.getEmail());
        k.setGioiTinh(quest.getGioiTinh());
//        k.setNgayTao(quest.getNgayTao());
        k.setTrangThai(quest.getTrangThai());
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

        existing.setTaiKhoan(quest.getTaiKhoan());
//        existing.setMaKhachHang(quest.getMaKhachHang());
        existing.setHoTen(quest.getHoTen());
        existing.setSoDienThoai(quest.getSoDienThoai());
        existing.setEmail(quest.getEmail());
        existing.setGioiTinh(quest.getGioiTinh());
//        existing.setNgayTao(quest.getNgayTao());
        existing.setTrangThai(quest.getTrangThai());

        repository.save(existing);
    }
}
