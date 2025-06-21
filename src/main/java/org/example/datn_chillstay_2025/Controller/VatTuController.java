package org.example.datn_chillstay_2025.Controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.example.datn_chillstay_2025.Entity.VatTu;
import org.example.datn_chillstay_2025.Service.VatTuService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vattu")
@CrossOrigin
public class VatTuController {

  private final VatTuService vatTuService;

  public VatTuController(VatTuService vatTuService) {
    this.vatTuService = vatTuService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<VatTu>> getAllVatTu() {
    return ResponseEntity.ok(vatTuService.getAllVatTu());
  }

  @GetMapping("/one/{id}")
  public ResponseEntity<VatTu> getVatTuById(@PathVariable Integer id) {
    return ResponseEntity.ok(vatTuService.getVatTuById(id));
  }

  @PostMapping("/add")
  public ResponseEntity<String> addVatTu(@RequestBody VatTu vatTu) {
    vatTuService.saveVatTu(vatTu);
    return ResponseEntity.ok("Thanh Cong");
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<String> updateVatTu(@RequestBody VatTu vatTu, @PathVariable Integer id) {
    vatTuService.updateVatTu(id, vatTu);
    return ResponseEntity.ok("Thanh Cong");
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<String> deleteVatTu(@PathVariable Integer id) {
    vatTuService.deleteVatTu(id);
    return ResponseEntity.ok("Xoa Thanh Cong");
  }
  @PutMapping("/reset/{id}")
  public ResponseEntity<String> resetVatu(@PathVariable Integer id) {
    vatTuService.khoiPhucVatTu(id);
    return ResponseEntity.ok("Khoi phuc Thanh Cong");
  }

  @GetMapping("/search")
  public ResponseEntity<List<VatTu>> findByTenOrId(@RequestParam Map<String, String> allParams) {
    String ten = null;
    Integer id = null;

    // Duyệt qua tất cả query parameters
    for (Map.Entry<String, String> entry : allParams.entrySet()) {
      String value = entry.getValue();
      // Decode giá trị để thay %20 thành khoảng trắng
      value = URLDecoder.decode(value, StandardCharsets.UTF_8);
      try {
        // Nếu giá trị có thể parse thành Integer, gán cho id
        id = Integer.parseInt(value);
      } catch (NumberFormatException e) {
        // Nếu không parse được, coi giá trị là ten
        ten = value;
      }
    }

    return ResponseEntity.ok(vatTuService.findByTenOrId(ten, id));
  }
    @GetMapping("/paged")
    public ResponseEntity<Page<VatTu>> getPagedVatTu(@RequestParam(defaultValue = "0",name = "page") int page) {
      int size = 2;
      Page<VatTu> paged = vatTuService.getVatTuByPage(page, size);
      return ResponseEntity.ok(paged);
    }
}