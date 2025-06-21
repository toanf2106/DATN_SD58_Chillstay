package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Dto.Request.TinTucRequestDto;
import org.example.datn_chillstay_2025.Service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/tin-tuc")
@RequiredArgsConstructor
public class TinTucController {
    @Autowired
    private TinTucService tinTucService;

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody TinTucRequestDto dto) {
        return ResponseEntity.ok(tinTucService.add(dto));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody TinTucRequestDto dto) {
        return ResponseEntity.ok(tinTucService.update(id, dto));
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(tinTucService.detail(id));
    }

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(tinTucService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        tinTucService.delete(id);
        return ResponseEntity.ok("Đã xoá mềm tin tức (trangThai = false)");
    }
    @GetMapping("/phan-trang")
    public ResponseEntity<?> getAllWithPaginationAndSearch(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam(defaultValue = "") String tieuDe,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngayDang
    ) {
        return ResponseEntity.ok(tinTucService.getAllWithPaginationAndSearch(page, size, tieuDe, ngayDang));
    }

}