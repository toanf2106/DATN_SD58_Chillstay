package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Dto.Request.AnhTinTucRequestDto;
import org.example.datn_chillstay_2025.Dto.Response.AnhTinTucResponseDto;
import org.example.datn_chillstay_2025.Repository.AnhTinTucRepo;
import org.example.datn_chillstay_2025.Service.AnhTinTucService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/anh-tin-tuc")
@RequiredArgsConstructor
public class AnhTinTucController {
    private final AnhTinTucService anhTinTucService;
    private final AnhTinTucRepo anhTinTucRepo;

    @PostMapping("/add")
    public ResponseEntity<AnhTinTucResponseDto> add(@RequestBody @Valid AnhTinTucRequestDto dto) {
        return ResponseEntity.ok(anhTinTucService.add(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id,
                                         @RequestBody @Valid AnhTinTucRequestDto dto) {
        anhTinTucService.update(id, dto);
        return ResponseEntity.ok("Cập nhật ảnh tin tức thành công");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (!anhTinTucRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Xoá thất bại: Không tìm thấy ảnh tin tức với ID = " + id
            );
        }

        anhTinTucService.delete(id);
        return ResponseEntity.ok("Xoá ảnh tin tức thành công ");
    }


    @GetMapping("/hien-thi")
    public ResponseEntity<List<AnhTinTucResponseDto>> getAll() {
        return ResponseEntity.ok(anhTinTucService.getAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AnhTinTucResponseDto> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(anhTinTucService.detail(id));
    }
}