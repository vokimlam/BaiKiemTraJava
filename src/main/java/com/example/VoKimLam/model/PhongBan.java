package com.example.VoKimLam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "ma_phong", length = 2, nullable = false)
    private String maPhong;

    @Column(name = "ten_phong", length = 30, nullable = false)
    private String tenPhong;
}