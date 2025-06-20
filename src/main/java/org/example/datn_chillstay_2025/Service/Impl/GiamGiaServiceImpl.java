package org.example.datn_chillstay_2025.Service.Impl;

import org.example.datn_chillstay_2025.Dto.GiamGiaDTO;
import org.example.datn_chillstay_2025.Entity.GiamGia;
import org.example.datn_chillstay_2025.Entity.HomeStay;
import org.example.datn_chillstay_2025.Repository.GiamGiaRepo;
import org.example.datn_chillstay_2025.Repository.HomeStayRepo;
import org.example.datn_chillstay_2025.Service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiamGiaServiceImpl implements GiamGiaService {

    @Autowired
    private GiamGiaRepo giamGiaRepository;

    @Autowired
    private HomeStayRepo homeStayRepository;

    @Override
    public GiamGiaDTO createGiamGia(GiamGiaDTO giamGiaDTO) {
        GiamGia giamGia = mapToEntity(giamGiaDTO);
        giamGia = giamGiaRepository.save(giamGia);
        return mapToDTO(giamGia);
    }

    @Override
    public GiamGiaDTO updateGiamGia(Integer id, GiamGiaDTO giamGiaDTO) {
        GiamGia giamGia = giamGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy mã giảm giá với ID: " + id));
        updateEntityFromDTO(giamGia, giamGiaDTO);
        giamGia = giamGiaRepository.save(giamGia);
        return mapToDTO(giamGia);
    }

    @Override
    public GiamGiaDTO getGiamGiaById(Integer id) {
        GiamGia giamGia = giamGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy mã giảm giá với ID: " + id));
        return mapToDTO(giamGia);
    }

    @Override
    public Page<GiamGiaDTO> getAllGiamGia(Pageable pageable) {
        Page<GiamGia> giamGiaPage = giamGiaRepository.findAll(pageable);
        return giamGiaPage.map(this::mapToDTO);
    }

    @Override
    public Page<GiamGiaDTO> getValidVouchers(Pageable pageable) {
        return giamGiaRepository.findValidVouchers(pageable)
                .map(this::mapToDTO);
    }

    @Override
    public Page<GiamGiaDTO> getExpiredVouchers(Pageable pageable) {
        return giamGiaRepository.findExpiredVouchers(pageable)
                .map(this::mapToDTO);
    }

    @Override
    public void deleteGiamGia(Integer id) {
        GiamGia giamGia = giamGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy mã giảm giá với ID: " + id));
        giamGia.setTrangThai(false);
        giamGiaRepository.save(giamGia);
    }

    @Override
    public List<GiamGiaDTO> findByTenGiamGia(String tenGiamGia) {
        return giamGiaRepository.findByTenGiamGiaContainingIgnoreCase(tenGiamGia)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiamGiaDTO> findByTenGiamGiaAndValid(String tenGiamGia) {
        return giamGiaRepository.findByTenGiamGiaAndValid(tenGiamGia, LocalDate.now())
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiamGiaDTO> findByTenGiamGiaAndExpired(String tenGiamGia) {
        return giamGiaRepository.findByTenGiamGiaAndExpired(tenGiamGia, LocalDate.now())
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiamGiaDTO> searchByMultipleFields(String searchTerm) {
        System.out.println("Service - searchByMultipleFields with term: " + searchTerm);
        List<GiamGia> results = giamGiaRepository.searchByMultipleFields(searchTerm);
        System.out.println("Found " + results.size() + " results");
        return results.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiamGiaDTO> searchByMultipleFieldsAndValid(String searchTerm) {
        System.out.println("Service - searchByMultipleFieldsAndValid with term: " + searchTerm);
        List<GiamGia> results = giamGiaRepository.searchByMultipleFieldsAndValid(searchTerm);
        System.out.println("Found " + results.size() + " valid results");
        return results.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiamGiaDTO> searchByMultipleFieldsAndExpired(String searchTerm) {
        System.out.println("Service - searchByMultipleFieldsAndExpired with term: " + searchTerm);
        List<GiamGia> results = giamGiaRepository.searchByMultipleFieldsAndExpired(searchTerm);
        System.out.println("Found " + results.size() + " expired results");
        return results.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private GiamGia mapToEntity(GiamGiaDTO dto) {
        GiamGia giamGia = new GiamGia();
        giamGia.setMaGiamGia(dto.getMaGiamGia());
        giamGia.setTenGiamGia(dto.getTenGiamGia());

        // Validate and normalize loaiGiamGia
        String loaiGiamGia = dto.getLoaiGiamGia();
        if (loaiGiamGia == null) {
            throw new IllegalArgumentException("Loại giảm giá không được để trống");
        }
        
        // Normalize to match database constraint - chỉ chấp nhận 'PhanTram' hoặc 'SoTien'
        System.out.println("Original loaiGiamGia: " + loaiGiamGia);
        
        // Trim whitespace and normalize
        loaiGiamGia = loaiGiamGia.trim();
        
        if ("Phần trăm".equals(loaiGiamGia) || 
            "PhanTram".equals(loaiGiamGia) || 
            "%".equals(loaiGiamGia) ||
            "phan tram".equalsIgnoreCase(loaiGiamGia)) {
            loaiGiamGia = "PhanTram";
        } else if ("Số tiền".equals(loaiGiamGia) || 
                   "SoTien".equals(loaiGiamGia) || 
                   "so tien".equalsIgnoreCase(loaiGiamGia)) {
            loaiGiamGia = "SoTien";
        } else {
            // Giá trị mặc định nếu không khớp
            System.err.println("Invalid loaiGiamGia value: '" + loaiGiamGia + "'");
            throw new IllegalArgumentException("Loại giảm giá phải là 'PhanTram' hoặc 'SoTien', nhận được: '" + loaiGiamGia + "'");
        }
        
        System.out.println("Normalized loaiGiamGia: " + loaiGiamGia);
        
        giamGia.setLoaiGiamGia(loaiGiamGia);
        giamGia.setGiaTri(dto.getGiaTri());
        giamGia.setGiaTriToiThieu(dto.getGiaTriToiThieu());
        giamGia.setNgayBatDau(dto.getNgayBatDau());
        giamGia.setNgayKetThuc(dto.getNgayKetThuc());
        giamGia.setSoLuong(dto.getSoLuong());
        giamGia.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : true);
        if (dto.getHomeStayId() != null) {
            HomeStay homeStay = homeStayRepository.findById(dto.getHomeStayId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy homestay với ID: " + dto.getHomeStayId()));
            giamGia.setHomeStay(homeStay);
        }
        return giamGia;
    }

    private GiamGiaDTO mapToDTO(GiamGia giamGia) {
        GiamGiaDTO dto = new GiamGiaDTO();
        dto.setId(giamGia.getId());
        dto.setMaGiamGia(giamGia.getMaGiamGia());
        dto.setTenGiamGia(giamGia.getTenGiamGia());
        dto.setLoaiGiamGia(giamGia.getLoaiGiamGia());
        dto.setGiaTri(giamGia.getGiaTri());
        dto.setGiaTriToiThieu(giamGia.getGiaTriToiThieu());
        dto.setNgayBatDau(giamGia.getNgayBatDau());
        dto.setNgayKetThuc(giamGia.getNgayKetThuc());
        dto.setSoLuong(giamGia.getSoLuong());
        dto.setTrangThai(giamGia.getTrangThai());
        if (giamGia.getHomeStay() != null) {
            dto.setHomeStayId(giamGia.getHomeStay().getId());
        }
        return dto;
    }

    private void updateEntityFromDTO(GiamGia giamGia, GiamGiaDTO dto) {
        giamGia.setTenGiamGia(dto.getTenGiamGia());
        
        // Validate and normalize loaiGiamGia
        String loaiGiamGia = dto.getLoaiGiamGia();
        if (loaiGiamGia == null) {
            throw new IllegalArgumentException("Loại giảm giá không được để trống");
        }
        
        // Normalize to match database constraint - chỉ chấp nhận 'PhanTram' hoặc 'SoTien'
        System.out.println("Update - Original loaiGiamGia: " + loaiGiamGia);
        
        // Trim whitespace and normalize
        loaiGiamGia = loaiGiamGia.trim();
        
        if ("Phần trăm".equals(loaiGiamGia) || 
            "PhanTram".equals(loaiGiamGia) || 
            "%".equals(loaiGiamGia) ||
            "phan tram".equalsIgnoreCase(loaiGiamGia)) {
            loaiGiamGia = "PhanTram";
        } else if ("Số tiền".equals(loaiGiamGia) || 
                   "SoTien".equals(loaiGiamGia) || 
                   "so tien".equalsIgnoreCase(loaiGiamGia)) {
            loaiGiamGia = "SoTien";
        } else {
            // Giá trị mặc định nếu không khớp
            System.err.println("Update - Invalid loaiGiamGia value: '" + loaiGiamGia + "'");
            throw new IllegalArgumentException("Loại giảm giá phải là 'PhanTram' hoặc 'SoTien', nhận được: '" + loaiGiamGia + "'");
        }
        
        System.out.println("Update - Normalized loaiGiamGia: " + loaiGiamGia);
        
        giamGia.setLoaiGiamGia(loaiGiamGia);
        giamGia.setGiaTri(dto.getGiaTri());
        giamGia.setGiaTriToiThieu(dto.getGiaTriToiThieu());
        giamGia.setNgayBatDau(dto.getNgayBatDau());
        giamGia.setNgayKetThuc(dto.getNgayKetThuc());
        giamGia.setSoLuong(dto.getSoLuong());
        giamGia.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : true);
        if (dto.getHomeStayId() != null) {
            HomeStay homeStay = homeStayRepository.findById(dto.getHomeStayId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy homestay với ID: " + dto.getHomeStayId()));
            giamGia.setHomeStay(homeStay);
        } else {
            giamGia.setHomeStay(null);
        }
    }
}