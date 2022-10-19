package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;

@Entity
public class LoaiNguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_loai", unique = true, nullable = false)
    private String tenLoai;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    public LoaiNguoiDung() {

    }

    public LoaiNguoiDung(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
