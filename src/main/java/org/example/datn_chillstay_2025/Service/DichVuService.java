package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Dto.DichVuDto;
import org.example.datn_chillstay_2025.Entity.DichVu;

import java.util.List;

public interface DichVuService {
    List<DichVuDto> getList();
    void saveDichVu(DichVu quest);
    void deleteDichVu(Integer id);
    void updateDichVu(Integer id, DichVu quest);
}
