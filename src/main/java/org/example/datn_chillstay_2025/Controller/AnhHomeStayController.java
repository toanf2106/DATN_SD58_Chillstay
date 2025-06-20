package org.example.datn_chillstay_2025.Controller;

import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.AnhHomeStay;
import org.example.datn_chillstay_2025.Service.AnhHomeStayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anh_homestay")
@CrossOrigin
public class AnhHomeStayController {
    private final AnhHomeStayService anhHomeStayService;

    @GetMapping("/all")
    public ResponseEntity<List<AnhHomeStay>> getAllAnhHomeStay() {
        List<AnhHomeStay> anhHomeStays = anhHomeStayService.getAllAnhHomeStay();
        return ResponseEntity.ok(anhHomeStays);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AnhHomeStay> getAnhHomeStayById(Integer id) {
        AnhHomeStay anhHomeStay = anhHomeStayService.getAnhHomeStayById(id);
        return ResponseEntity.ok(anhHomeStay);
    }

    @PostMapping("/add")
    public ResponseEntity<AnhHomeStay> addAnhHomeStay(@RequestBody AnhHomeStay anhHomeStay) {
        AnhHomeStay newAnhHomeStay = anhHomeStayService.addAnhHomeStay(anhHomeStay);
        return ResponseEntity.ok(newAnhHomeStay);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AnhHomeStay> updateAnhHomeStay(@RequestBody AnhHomeStay anhHomeStay,@PathVariable int id) {
        AnhHomeStay updatedAnhHomeStay = anhHomeStayService.updateAnhHomeStay(anhHomeStay, id);
        return ResponseEntity.ok(updatedAnhHomeStay);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnhHomeStay(@PathVariable int id) {
        anhHomeStayService.deleteAnhHomeStay(id);
        return ResponseEntity.ok("Anh Home Stay with id " + id + " deleted successfully");
    }

}
