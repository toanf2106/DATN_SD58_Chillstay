package org.example.datn_chillstay_2025.Controller;

import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.AnhPhong;
import org.example.datn_chillstay_2025.Service.AnhPhongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anh_phong")
public class AnhPhongController {
    private final AnhPhongService anhPhongService;

    @GetMapping("/all")
    public ResponseEntity<List<AnhPhong>> getAllAnhPhong() {
        List<AnhPhong> anhPhong = anhPhongService.getAllAnhPhong();
        return ResponseEntity.ok(anhPhong);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AnhPhong> getAnhPhongById(@PathVariable int id) {
        AnhPhong anhPhong = anhPhongService.getAnhPhongById(id);
        return ResponseEntity.ok(anhPhong);
    }

    @PostMapping("/add")
    public ResponseEntity<AnhPhong> addAnhPhong(@RequestBody AnhPhong anhPhong) {
        AnhPhong newAnhPhong = anhPhongService.addAnhPhong(anhPhong);
        return ResponseEntity.ok(newAnhPhong);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AnhPhong> updateAnhPhong(@RequestBody AnhPhong anhPhong, @PathVariable int id) {
        AnhPhong updatedAnhPhong = anhPhongService.updateAnhPhong(anhPhong, id);
        return ResponseEntity.ok(updatedAnhPhong);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnhPhong(@PathVariable int id) {
        anhPhongService.deleteAnhPhong(id);
        return ResponseEntity.ok("Anh phong with id " + id + " deleted successfully");
    }
}
