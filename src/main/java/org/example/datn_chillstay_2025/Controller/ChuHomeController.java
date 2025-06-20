package org.example.datn_chillstay_2025.Controller;

import java.util.List;
import org.example.datn_chillstay_2025.Entity.ChuHomeStay;
import org.example.datn_chillstay_2025.Service.ChuHomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chu-home")
@CrossOrigin
public class ChuHomeController {

  public final ChuHomeService chuHomeService;

  public ChuHomeController(ChuHomeService chuHomeService) {
    this.chuHomeService = chuHomeService;
  }
  @GetMapping("/all")
  public ResponseEntity<List<ChuHomeStay>> getAllChuHomes() {
    return ResponseEntity.ok(chuHomeService.getAllChuHomes());
  }

  @GetMapping("/one/{id}")
  public ResponseEntity<ChuHomeStay> getChuHomeById(@PathVariable Integer id) {

    return ResponseEntity.ok(chuHomeService.getChuHomeById(id));
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<String> updateChuHome(@PathVariable Integer id,@RequestBody ChuHomeStay chuHome) {
    chuHomeService.updateChuHome(id, chuHome);
    return ResponseEntity.ok("ChuHome with ID: " + id + " updated successfully");
  }
  @PostMapping("/add")
  public ResponseEntity<String> addChuHome(@RequestBody ChuHomeStay chuHome) {
    chuHomeService.saveChuHome(chuHome);
    return ResponseEntity.ok("ChuHome added successfully");
  }
  @PutMapping("/delete/{id}")
  public ResponseEntity<String> deleteChuHome(@PathVariable Integer id) {
    chuHomeService.deleteChuHome(id);
    return ResponseEntity.ok("ChuHome with ID: " + id + " deleted successfully");
  }
}
