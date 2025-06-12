package org.example.datn_chillstay_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GiamGia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma_Giam_Gia", length = 50)
    private String maGiamGia;

    @NotBlank(message = "Loai_Giam_Gia is required")
    @Column(name = "Loai_Giam_Gia", nullable = false, length = 20)
    private String loaiGiamGia;

    @NotNull(message = "Gia_Tri is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Gia_Tri must be greater than 0")
    @Column(name = "Gia_Tri", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaTri;

    // Loại bỏ hoặc giữ lại homeStayId nếu cần
    @Column(name = "HomeStay_ID")
    private Integer homeStayId;

    @DecimalMin(value = "0.0", message = "Gia_Tri_Toi_Thieu must be non-negative")
    @Column(name = "Gia_Tri_Toi_Thieu", precision = 10, scale = 2)
    private BigDecimal giaTriToiThieu;

    @NotNull(message = "Ngay_Bat_Dau is required")
    @Column(name = "Ngay_Bat_Dau", nullable = false)
    private LocalDate ngayBatDau;

    @NotNull(message = "Ngay_Ket_Thuc is required")
    @Column(name = "Ngay_Ket_Thuc", nullable = false)
    private LocalDate ngayKetThuc;

    @Column(name = "So_Luong")
    private Integer soLuong;

    @NotNull(message = "Trang_Thai is required")
    @Column(name = "Trang_Thai", nullable = false)
    private Boolean trangThai;

    // Thêm mối quan hệ với HomeStay
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HomeStay_ID", insertable = false, updatable = false)
    private HomeStay homeStay;

    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (ngayBatDau != null && ngayKetThuc != null && ngayBatDau.isAfter(ngayKetThuc)) {
            throw new IllegalArgumentException("Ngay_Bat_Dau must be before Ngay_Ket_Thuc");
        }
    }

}
