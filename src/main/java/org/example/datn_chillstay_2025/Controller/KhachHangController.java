package org.example.datn_chillstay_2025.Controller;

import org.example.datn_chillstay_2025.Entity.KhachHang;
import org.example.datn_chillstay_2025.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KhachHangController {
    @Autowired
    private KhachHangService service;

    @GetMapping
    public ResponseEntity<?> getKhachHang() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody KhachHang quest) {
        service.saveKhachHang(quest);
        return ResponseEntity.ok("Thêm khách hàng thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKhachHang(@PathVariable Integer id){
        service.deleteKhachHang(id);
        return ResponseEntity.ok("Delete thành công " + id);
    }
    @PutMapping("/khachhang/{id}")
    public ResponseEntity<String> updateKhachHang(@PathVariable Integer id, @RequestBody KhachHang quest) {
        service.updateKhachHang(id, quest);
        return ResponseEntity.ok("Cập nhật khách hàng thành công với ID: " + id);
    }

}
