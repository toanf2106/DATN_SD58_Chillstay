package org.example.datn_chillstay_2025.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.datn_chillstay_2025.Dto.Request.AnhTinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.AnhTinTucResponseDto;
import org.example.datn_chillstay_2025.Entity.AnhTinTuc;
import org.example.datn_chillstay_2025.Entity.TinTuc;
import org.example.datn_chillstay_2025.Repository.AnhTinTucRepo;
import org.example.datn_chillstay_2025.Repository.TinTucRepo;
import org.example.datn_chillstay_2025.Service.AnhTinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnhTinTucServiceImpl implements AnhTinTucService {

    @Autowired
    private AnhTinTucRepo anhTinTucRepo;
    @Autowired
    private TinTucRepo tinTucRepo;
    private AnhTinTucResponseDto convertToDto(AnhTinTuc entity) {
        return new AnhTinTucResponseDto(
                entity.getId(),
                entity.getTinTuc().getId(),
                entity.getDuongDanAnh(),
                entity.getTrangThai()
        );
    }

    @Override
    public AnhTinTucResponseDto add(AnhTinTucRequestDto dto) {
        TinTuc tinTuc = tinTucRepo.findById(dto.getTinTucId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin tức"));

        AnhTinTuc entity = new AnhTinTuc();
        entity.setTinTuc(tinTuc);
        entity.setDuongDanAnh(dto.getDuongDanAnh());
        entity.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : false);

        return convertToDto(anhTinTucRepo.save(entity));
    }

    @Override
    public AnhTinTucResponseDto update(Integer id, AnhTinTucRequestDto dto) {
        AnhTinTuc entity = anhTinTucRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ảnh tin tức"));
        TinTuc tinTuc = tinTucRepo.findById(dto.getTinTucId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin tức"));

        entity.setTinTuc(tinTuc);
        entity.setDuongDanAnh(dto.getDuongDanAnh());
        entity.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : false);

        return convertToDto(anhTinTucRepo.save(entity));
    }

    @Override
    public void delete(Integer id) {
        Optional<AnhTinTuc> optional = anhTinTucRepo.findById(id);
        if (optional.isPresent()) {
            AnhTinTuc entity = optional.get();
            entity.setTrangThai(false); // Xoá mềm: đánh dấu là không còn hoạt động
            anhTinTucRepo.save(entity);
        } else {
            throw new RuntimeException("Không tìm thấy ảnh tin tức với id: " + id);
        }
    }



    @Override
    public AnhTinTucResponseDto detail(Integer id) {
        AnhTinTuc entity = anhTinTucRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ảnh tin tức"));
        return convertToDto(entity);
    }
    @Override
    public List<AnhTinTucResponseDto> getAll() {
        return anhTinTucRepo.findAllByTrangThaiTrue()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}