package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.AnhPhong;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnhPhongService {
    List<AnhPhong> getAllAnhPhong();
    AnhPhong getAnhPhongById(Integer id);
    AnhPhong addAnhPhong(AnhPhong anhPhong);
    AnhPhong updateAnhPhong(AnhPhong anhPhong, Integer id);
    void deleteAnhPhong(Integer id);
}
