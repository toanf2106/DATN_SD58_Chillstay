package org.example.datn_chillstay_2025.Service;


import java.util.List;
import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.springframework.stereotype.Service;

@Service
public interface GiamGiaService {

    GiamGiaDTO createGiamGia(GiamGiaDTO giamGiaDTO);
    GiamGiaDTO updateGiamGia(Integer id, GiamGiaDTO giamGiaDTO);
    GiamGiaDTO getGiamGiaById(Integer id);
    List<GiamGiaDTO> getAllGiamGia();
    void deleteGiamGia(Integer id);

}
