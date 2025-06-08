package org.example.datn_chillstay_2025.Controller;

import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.Phong;
import org.example.datn_chillstay_2025.Service.PhongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/phong")
public class PhongController {
    private final PhongService phongService;

    @GetMapping("/all")
    public ResponseEntity<List<Phong>> getAllPhong() {
        List<Phong> phongs = phongService.getAllPhong();
        return ResponseEntity.ok(phongs);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Phong> getPhongById(@PathVariable int id) {
        Phong phong = phongService.getPhongById(id);
        return ResponseEntity.ok(phong);
    }
    @PostMapping("/add")
    public ResponseEntity<Phong> addPhong(@RequestBody Phong phong ) {
        Phong newPhong = phongService.addPhong(phong);
        return ResponseEntity.ok(newPhong);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Phong> updatePhong(@RequestBody Phong phong, @PathVariable int id) {
        Phong updatedPhong = phongService.updatePhong(phong, id);
        return ResponseEntity.ok(updatedPhong);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deletePhong(@PathVariable int id) {
        phongService.deletePhong(id);
        return ResponseEntity.ok("Phong with id " + id + " deleted successfully");
    }

}
