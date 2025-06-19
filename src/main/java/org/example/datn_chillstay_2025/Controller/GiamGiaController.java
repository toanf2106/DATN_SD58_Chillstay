package org.example.datn_chillstay_2025.Controller;


import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.example.datn_chillstay_2025.Service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giamgia")
public class GiamGiaController {


    final GiamGiaService giamGiaService;

    public GiamGiaController(GiamGiaService giamGiaService) {
        this.giamGiaService = giamGiaService;
    }

    @PostMapping
    public ResponseEntity<GiamGiaDTO> createGiamGia(@RequestBody GiamGiaDTO giamGiaDTO) {
        GiamGiaDTO created = giamGiaService.createGiamGia(giamGiaDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiamGiaDTO> updateGiamGia(@PathVariable Integer id, @RequestBody GiamGiaDTO giamGiaDTO) {
        GiamGiaDTO updated = giamGiaService.updateGiamGia(id, giamGiaDTO);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiamGiaDTO> getGiamGiaById(@PathVariable Integer id) {
        GiamGiaDTO giamGiaDTO = giamGiaService.getGiamGiaById(id);
        return ResponseEntity.ok(giamGiaDTO);
    }

    @GetMapping
    public ResponseEntity<List<GiamGiaDTO>> getAllGiamGia() {
        List<GiamGiaDTO> giamGiaList = giamGiaService.getAllGiamGia();
        return ResponseEntity.ok(giamGiaList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiamGia(@PathVariable Integer id) {
        giamGiaService.deleteGiamGia(id);
        return ResponseEntity.noContent().build();
    }
}
