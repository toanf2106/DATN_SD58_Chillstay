package org.example.datn_chillstay_2025.Controller;

import java.util.List;
import org.example.datn_chillstay_2025.Dto.HomeStayDto;
import org.example.datn_chillstay_2025.Entity.HomeStay;
import org.example.datn_chillstay_2025.Service.HomeStayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homestay")
public class HomeStayController {
private final HomeStayService homeStayService;

    public HomeStayController(HomeStayService homeStayService) {
        this.homeStayService = homeStayService;
    }
@GetMapping("/all")
    public ResponseEntity<List<HomeStayDto>> getAllHomeStays() {
        return ResponseEntity.ok(homeStayService.getAllHomeStays());
    }


    // Add other methods as needed
     @GetMapping("/{id}")
    public ResponseEntity<HomeStayDto> getHomeStayById(@PathVariable int id) {
        HomeStayDto homeStay = homeStayService.getHomeStayByIdDto(id);
        if (homeStay != null) {
            return ResponseEntity.ok(homeStay);
        } else {
            return ResponseEntity.notFound().build();
        }
}
@PostMapping("/add")
    public ResponseEntity<HomeStay> addHomeStay(@RequestBody HomeStay homeStay) {
         homeStayService.addHomeStay(homeStay);
        return ResponseEntity.ok(homeStay);
    }
@PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteHomeStay(@PathVariable int id) {
        homeStayService.deleteHomeStay(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HomeStay> updateHomeStay(@RequestBody HomeStay homeStay, @PathVariable int id) {
        HomeStay updatedHomeStay = homeStayService.updateHomeStay(homeStay, id);
        if (updatedHomeStay != null) {
            return ResponseEntity.ok(updatedHomeStay);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
