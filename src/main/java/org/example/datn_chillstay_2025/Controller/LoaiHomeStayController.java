package org.example.datn_chillstay_2025.Controller;

import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.LoaiHomeStay;
import org.example.datn_chillstay_2025.Service.LoaiHomeStayService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("loai-homestay")
public class LoaiHomeStayController {

    private final LoaiHomeStayService loaiHomeStayService;

    @GetMapping("hien-thi")
    public ResponseEntity<List<LoaiHomeStay>> hienThi(){
        List<LoaiHomeStay> loaiHomeStays = loaiHomeStayService.getAllLoaiHomeStay();
        return ResponseEntity.ok(loaiHomeStayService.getAllLoaiHomeStay());
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<LoaiHomeStay> detail(@PathVariable int id){
        LoaiHomeStay loaiHomeStay = loaiHomeStayService.getLoaiHomeStayById(id);
        return ResponseEntity.ok(loaiHomeStay);
    }

    @GetMapping("detail-ten/{tenLoaiHomestay}")
    public ResponseEntity<LoaiHomeStay> detailByTen(@PathVariable String tenLoaiHomestay) {
        LoaiHomeStay loaiHomeStay = loaiHomeStayService.getLoaiHomeStayByTen(tenLoaiHomestay);
        return ResponseEntity.ok(loaiHomeStay);
    }

    @PutMapping("{id}")
    public ResponseEntity<LoaiHomeStay> update(@RequestBody LoaiHomeStay loaiHomeStay, @PathVariable int id){
        loaiHomeStayService.updateLoaiHomeStay(loaiHomeStay, id);
        return ResponseEntity.ok(loaiHomeStay);
    }

    @PostMapping("add")
    public ResponseEntity<LoaiHomeStay> add(@RequestBody LoaiHomeStay loaiHomeStay){
        loaiHomeStayService.addLoaiHomeStay(loaiHomeStay);
        return ResponseEntity.ok(loaiHomeStay);
    }
    @PutMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        loaiHomeStayService.DeleteLoaiHomestay(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
