package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Dto.Request.TinTucRequestDto;
import org.example.datn_chillstay_2025.Service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok("Xoá thành công");
    }
}