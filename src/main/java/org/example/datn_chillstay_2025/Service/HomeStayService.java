package org.example.datn_chillstay_2025.Service;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.HomeStayDto;
import org.example.datn_chillstay_2025.Entity.HomeStay;
import org.springframework.stereotype.Service;

@Service
public interface HomeStayService {

//  HomeStayDto getHomeStayByTenHomestayDto(String ten);

  HomeStayDto getHomeStayByIdDto(int id);

  List<HomeStayDto> getAllHomeStays();

  HomeStay getHomeStayById(int id);

  HomeStay addHomeStay(HomeStay homeStay);

  HomeStay updateHomeStay(HomeStay homeStay, int id);

  void deleteHomeStay(int id);
}
