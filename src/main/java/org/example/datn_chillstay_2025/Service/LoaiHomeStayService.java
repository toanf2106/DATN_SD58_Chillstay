package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.LoaiHomeStay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoaiHomeStayService {
    List<LoaiHomeStay> getAllLoaiHomeStay();
    LoaiHomeStay getLoaiHomeStayById(int id);
    LoaiHomeStay addLoaiHomeStay(LoaiHomeStay loaiHomeStay);
    LoaiHomeStay updateLoaiHomeStay(LoaiHomeStay loaiHomeStay, Integer id);
    void DeleteLoaiHomestay(int id);
    LoaiHomeStay getLoaiHomeStayByTen(String tenLoaiHomestay);
}
