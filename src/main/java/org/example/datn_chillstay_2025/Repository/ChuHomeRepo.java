package org.example.datn_chillstay_2025.Repository;

import org.example.datn_chillstay_2025.Entity.ChuHomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuHomeRepo extends JpaRepository<ChuHomeStay, Integer> {
    // Custom query methods can be defined here if needed
    // For example, find by name or location
    // List<ChuHomeStay> findByName(String name);

    // You can also define methods for pagination and sorting if required
}
