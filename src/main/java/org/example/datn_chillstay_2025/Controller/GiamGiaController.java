package org.example.datn_chillstay_2025.Controller;


import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.example.datn_chillstay_2025.Service.GiamGiaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            System.out.println("Received GiamGia data: " + giamGiaDTO);
            System.out.println("LoaiGiamGia: " + giamGiaDTO.getLoaiGiamGia());
            System.out.println("LoaiGiamGia type: " + (giamGiaDTO.getLoaiGiamGia() != null ? giamGiaDTO.getLoaiGiamGia().getClass().getName() : "null"));
            
            GiamGiaDTO created = giamGiaService.createGiamGia(giamGiaDTO);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            System.err.println("Exception creating GiamGia: " + e.getMessage());
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi khi tạo mã giảm giá: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "all") String status) {
        try {
            System.out.println("Original search term: " + searchTerm);
            
            // Đảm bảo searchTerm không null và được trim
            String trimmedSearchTerm = searchTerm != null ? searchTerm.trim() : "";
            System.out.println("Trimmed search term: " + trimmedSearchTerm);
            
            if (page != null) {
                Pageable pageable = PageRequest.of(page, size);
                Page<GiamGiaDTO> giamGiaPage;
                
                if (!trimmedSearchTerm.isEmpty()) {
                    List<GiamGiaDTO> allMatches;
                    if ("valid".equals(status)) {
                        allMatches = giamGiaService.searchByMultipleFieldsAndValid(trimmedSearchTerm);
                    } else if ("expired".equals(status)) {
                        allMatches = giamGiaService.searchByMultipleFieldsAndExpired(trimmedSearchTerm);
                    } else {
                        allMatches = giamGiaService.searchByMultipleFields(trimmedSearchTerm);
                    }
                    
                    System.out.println("Found matches: " + allMatches.size());
                    
                    int start = (int) pageable.getOffset();
                    int end = Math.min((start + pageable.getPageSize()), allMatches.size());
                    
                    if (start > allMatches.size()) {
                        giamGiaPage = new PageImpl<>(new ArrayList<>(), pageable, allMatches.size());
                    } else {
                        giamGiaPage = new PageImpl<>(allMatches.subList(start, end), pageable, allMatches.size());
                    }
                } else {
                    if ("valid".equals(status)) {
                        giamGiaPage = giamGiaService.getValidVouchers(pageable);
                    } else if ("expired".equals(status)) {
                        giamGiaPage = giamGiaService.getExpiredVouchers(pageable);
                    } else {
                        giamGiaPage = giamGiaService.getAllGiamGia(pageable);
                    }
                }
                return ResponseEntity.ok(giamGiaPage);
            } else {
                List<GiamGiaDTO> giamGiaList;
                if (!trimmedSearchTerm.isEmpty()) {
                    if ("valid".equals(status)) {
                        giamGiaList = giamGiaService.searchByMultipleFieldsAndValid(trimmedSearchTerm);
                    } else if ("expired".equals(status)) {
                        giamGiaList = giamGiaService.searchByMultipleFieldsAndExpired(trimmedSearchTerm);
                    } else {
                        giamGiaList = giamGiaService.searchByMultipleFields(trimmedSearchTerm);
                    }
                    System.out.println("Found matches (no paging): " + giamGiaList.size());
                } else {
                    if ("valid".equals(status)) {
                        giamGiaList = giamGiaService.getValidVouchers(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
                    } else if ("expired".equals(status)) {
                        giamGiaList = giamGiaService.getExpiredVouchers(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
                    } else {
                        giamGiaList = giamGiaService.getAllGiamGia(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
                    }
                }
                return ResponseEntity.ok(giamGiaList);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Thêm log để debug
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

    @GetMapping("/search")
    public ResponseEntity<?> searchVouchers(
            @RequestParam String term,
            @RequestParam(defaultValue = "all") String status) {
        
        System.out.println("Original search term: " + term);
        String trimmedTerm = term.trim();
        System.out.println("Trimmed search term: " + trimmedTerm);

        List<GiamGiaDTO> results = new ArrayList<>();
        
        try {
            System.out.println("Service - searchByMultipleFields with term: " + trimmedTerm);
            
            switch (status) {
                case "valid":
                    results = giamGiaService.searchByMultipleFieldsAndValid(trimmedTerm);
                    break;
                case "expired":
                    results = giamGiaService.searchByMultipleFieldsAndExpired(trimmedTerm);
                    break;
                default:
                    results = giamGiaService.searchByMultipleFields(trimmedTerm);
            }
            
            System.out.println("Found " + results.size() + " results");
            System.out.println("Found matches: " + results.size());
            
            // Debug: print first result if available
            if (!results.isEmpty()) {
                GiamGiaDTO first = results.get(0);
                System.out.println("First result - ID: " + first.getId() + 
                                   ", Name: " + first.getTenGiamGia() + 
                                   ", Type: " + first.getLoaiGiamGia());
            }
            
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            System.out.println("Error in search: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
