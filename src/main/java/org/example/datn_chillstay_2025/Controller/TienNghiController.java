package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.example.datn_chillstay_2025.Service.TienNghiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tien-nghi")
public class TienNghiController {
    private final TienNghiService tienNghiService;

    @GetMapping("hien-thi")
    public ResponseEntity <List<TienNghi>> hienThi(){
        List<TienNghi> tienNghi = tienNghiService.getTienNghi();
        return ResponseEntity.ok(tienNghi);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<TienNghi> detail(@PathVariable int id){
        TienNghi tienNghi = tienNghiService.getTienNghiById(id);
        return ResponseEntity.ok(tienNghi);
    }

    @GetMapping("detail-ten/{tenTienNghi}")
    public ResponseEntity<TienNghi> detailByTen(@PathVariable String tenTienNghi) {
        TienNghi tienNghi = tienNghiService.getTienNghiByTen(tenTienNghi);
        return ResponseEntity.ok(tienNghi);
    }

    @PutMapping("{id}")
    public ResponseEntity<TienNghi> update(@RequestBody TienNghi tienNghi, @PathVariable int id ){
        tienNghiService.updateTienNghi(tienNghi, id);
        return ResponseEntity.ok(tienNghi);
    }

    @PostMapping("add")
    public ResponseEntity<TienNghi> add(@RequestBody TienNghi tienNghi){
        tienNghiService.addTienNghi(tienNghi);
        return ResponseEntity.ok(tienNghi);
    }
    @PutMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        tienNghiService.DeleteTienNghiById(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}