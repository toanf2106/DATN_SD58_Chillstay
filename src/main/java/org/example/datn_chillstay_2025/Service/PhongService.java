package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.Phong;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhongService {
    List<Phong> getAllPhong();
    Phong getPhongById(Integer id);
    Phong addPhong(Phong phong);
    Phong updatePhong(Phong phong, Integer id);
    void deletePhong(Integer id);

}
