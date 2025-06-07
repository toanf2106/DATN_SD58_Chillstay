package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Entity.ChuHomeStay;
import org.springframework.stereotype.Service;

@Service
public interface ChuHomeService{

     List<ChuHomeStay> getAllChuHomes();
     ChuHomeStay getChuHomeById(Integer id);
     ChuHomeStay saveChuHome(ChuHomeStay chuHome);
     ChuHomeStay updateChuHome(Integer id, ChuHomeStay chuHome);
     void deleteChuHome(Integer id);
}
