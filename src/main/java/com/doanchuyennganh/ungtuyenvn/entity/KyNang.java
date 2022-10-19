package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;

@Entity
public class KyNang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_ky_nang")
    private String tenKyNang;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenKyNang() {
        return tenKyNang;
    }

    public void setTenKyNang(String tenKyNang) {
        this.tenKyNang = tenKyNang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


}
