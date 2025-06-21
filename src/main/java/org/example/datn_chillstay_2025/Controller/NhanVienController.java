package org.example.datn_chillstay_2025.Controller;

import jakarta.validation.Valid;
import java.util.List;
import org.example.datn_chillstay_2025.Dto.NhanVienDto;
//import org.example.datn_chillstay_2025.Dto.Request.NhanVienRequestDto;
//import org.example.datn_chillstay_2025.Dto.Response.NhanVienResponseDto;
import org.example.datn_chillstay_2025.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping("/all")
    public ResponseEntity<List<NhanVienDto>> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<String> restore(@PathVariable Integer id) {
        nhanVienService.restore(id);
        return ResponseEntity.ok("Nhân viên đã được khôi phục với ID: " + id);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        nhanVienService.delete(id);
        return ResponseEntity.ok("Nhân viên đã được xóa với ID: " + id);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<NhanVienDto>> getAllPage(@RequestParam(defaultValue = "0" ,name = "page")  int page) {
        return ResponseEntity.ok(nhanVienService.getAllDto(page, 5));
    }
@GetMapping("/{id}")
    public ResponseEntity<String> getNhanVienById(@PathVariable int id) {
    nhanVienService.getNhanVienById(id);
        return ResponseEntity.ok("Nhân viên đã được lấy thành công với ID: " + id);
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> add(@Valid @RequestBody NhanVienDto nhanVienDto) {
//        nhanVienService.add(nhanVienDto);
//        return ResponseEntity.ok("Nhân viên đã được thêm thành công");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> update(@PathVariable int id, @Valid @RequestBody NhanVienDto nhanVienDto) {
//        nhanVienService.update(id, nhanVienDto);
//        return ResponseEntity.ok("Nhân viên đã được cập nhật thành công với ID: " + id);
//    }

}
