package org.example.datn_chillstay_2025.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TienNghi")
public class TienNghi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "Ten_Tien_Nghi", nullable = false, length = 100)
    private String tenTienNghi;

    @Nationalized
    @Column(name = "Mo_Ta")
    private String moTa;

    @Nationalized
    @Column(name = "Don_Vi", length = 20)
    private String donVi;

    @Column(name = "Trang_Thai")
    private boolean trangThai;

}
