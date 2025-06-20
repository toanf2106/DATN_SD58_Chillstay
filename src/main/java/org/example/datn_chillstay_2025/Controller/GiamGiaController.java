package org.example.datn_chillstay_2025.Controller;


import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.example.datn_chillstay_2025.Service.GiamGiaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/giamgia")
public class GiamGiaController {


    final GiamGiaService giamGiaService;

    public GiamGiaController(GiamGiaService giamGiaService) {
        this.giamGiaService = giamGiaService;
    }

    @PostMapping
    public ResponseEntity<?> createGiamGia(@RequestBody GiamGiaDTO giamGiaDTO) {
        try {
            GiamGiaDTO created = giamGiaService.createGiamGia(giamGiaDTO);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGiamGia(@PathVariable Integer id, @RequestBody GiamGiaDTO giamGiaDTO) {
        try {
            GiamGiaDTO updated = giamGiaService.updateGiamGia(id, giamGiaDTO);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiamGiaDTO> getGiamGiaById(@PathVariable Integer id) {
        GiamGiaDTO giamGiaDTO = giamGiaService.getGiamGiaById(id);
        return ResponseEntity.ok(giamGiaDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllGiamGia(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) String tenGiamGia) {
        try {
            if (page != null) {
                Pageable pageable = PageRequest.of(page, size);
                Page<GiamGiaDTO> giamGiaPage;
                if (tenGiamGia != null && !tenGiamGia.isEmpty()) {
                    List<GiamGiaDTO> allMatches = giamGiaService.findByTenGiamGia(tenGiamGia);
                    int start = (int) pageable.getOffset();
                    int end = Math.min((start + pageable.getPageSize()), allMatches.size());
                    giamGiaPage = new PageImpl<>(allMatches.subList(start, end), pageable, allMatches.size());
                } else {
                    giamGiaPage = giamGiaService.getAllGiamGia(pageable);
                }
                return ResponseEntity.ok(giamGiaPage);
            } else {
                List<GiamGiaDTO> giamGiaList;
                if (tenGiamGia != null && !tenGiamGia.isEmpty()) {
                    giamGiaList = giamGiaService.findByTenGiamGia(tenGiamGia);
                } else {
                    giamGiaList = giamGiaService.getAllGiamGia(null).getContent();
                }
                return ResponseEntity.ok(giamGiaList);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi khi lấy danh sách mã giảm giá: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiamGia(@PathVariable Integer id) {
        giamGiaService.deleteGiamGia(id);
        return ResponseEntity.noContent().build();
    }
}
