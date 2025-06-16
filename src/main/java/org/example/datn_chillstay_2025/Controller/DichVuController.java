package org.example.datn_chillstay_2025.Controller;

import org.example.datn_chillstay_2025.Entity.DichVu;
import org.example.datn_chillstay_2025.Service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api")
public class DichVuController {
    @Autowired
    private DichVuService service;

    @GetMapping
    public ResponseEntity<?> getDichVU() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DichVu quest) {
        service.saveDichVu(quest);
        return ResponseEntity.ok("Thêm  thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDichVu(@PathVariable Integer id){
        service.deleteDichVu(id);
        return ResponseEntity.ok("Delete thành công " + id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateKhachHang(@PathVariable Integer id, @RequestBody DichVu quest) {
        service.updateDichVu(id, quest);
        return ResponseEntity.ok("Cập nhật thành công với ID: " + id);
    }

}
