package org.example.datn_chillstay_2025.Repository;

import java.util.Optional;
import org.example.datn_chillstay_2025.Dto.HomeStayDto;
import org.example.datn_chillstay_2025.Entity.HomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeStayRepo extends JpaRepository<HomeStay, Integer> {


}
