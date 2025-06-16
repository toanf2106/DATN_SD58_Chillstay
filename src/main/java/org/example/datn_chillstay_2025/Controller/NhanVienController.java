package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import java.util.List;
import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.example.datn_chillstay_2025.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("hien-thi")
    public ResponseEntity<List<NhanVienResponseDto>> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<NhanVienResponseDto> addNhanVien(@Valid @RequestBody NhanVienRequestDto dto) {
        return ResponseEntity.ok(nhanVienService.add(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NhanVienResponseDto> updateNhanVien(@PathVariable Integer id,
                                                              @Valid @RequestBody NhanVienRequestDto dto) {
        return ResponseEntity.ok(nhanVienService.update(id, dto));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<NhanVienResponseDto> detailNhanVien(@PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienService.detailNhanVien(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNhanVien(@PathVariable Integer id) {
        nhanVienService.delete(id);
        return ResponseEntity.ok("Xoá thành công");
    }


}
