package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Entity.VatTu;
import org.springframework.stereotype.Service;

@Service
public interface VatTuService {
  List<VatTu> findByTenOrId(String ten, Integer id);
  List<VatTu> getAllVatTu();
  VatTu getVatTuById(Integer id);
  VatTu saveVatTu(VatTu vatTu);
  VatTu updateVatTu(Integer id, VatTu vatTu);
  void deleteVatTu(Integer id);
}