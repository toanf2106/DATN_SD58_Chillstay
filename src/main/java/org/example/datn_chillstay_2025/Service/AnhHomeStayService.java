package org.example.datn_chillstay_2025.Service;

import org.example.datn_chillstay_2025.Entity.AnhHomeStay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnhHomeStayService {

    List<AnhHomeStay> getAllAnhHomeStay();
    AnhHomeStay getAnhHomeStayById(Integer id);
    AnhHomeStay addAnhHomeStay(AnhHomeStay anhHomeStay);
    AnhHomeStay updateAnhHomeStay(AnhHomeStay anhHomeStay, Integer id);
    void deleteAnhHomeStay(Integer id);
}
