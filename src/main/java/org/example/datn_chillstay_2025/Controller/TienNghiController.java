package org.example.datn_chillstay_2025.Controller;


import lombok.RequiredArgsConstructor;
import org.example.datn_chillstay_2025.Entity.TienNghi;
import org.example.datn_chillstay_2025.Service.TienNghiService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;



import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tien-nghi")
public class TienNghiController {
    private final TienNghiService tienNghiService;

    @GetMapping("/all")
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


    @GetMapping("/search")
    public ResponseEntity<Page<TienNghi>> search(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(required = false) Boolean status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size // Chắc chắn size khớp với frontend
    ) {
        // Tạo đối tượng Pageable từ page và size
        Pageable pageable = PageRequest.of(page, size);

        // Gọi service và truyền ĐẦY ĐỦ tham số, bao gồm cả pageable
        Page<TienNghi> resultPage = tienNghiService.searchTienNghi(keyword, status, pageable);

        return ResponseEntity.ok(resultPage);
    }

}