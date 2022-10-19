package com.doanchuyennganh.ungtuyenvn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class ChuyenMon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_chuyen_mon")
    private String tenChuyenMon;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    // Foreign Keys
    @JsonIgnore
    @ManyToMany(mappedBy = "chuyenMons")
    private Set<NguoiDung> nguoiDungs = new HashSet<>();

    public ChuyenMon() {

    }

    public ChuyenMon(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenChuyenMon() {
        return tenChuyenMon;
    }

    public void setTenChuyenMon(String tenChuyenMon) {
        this.tenChuyenMon = tenChuyenMon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<NguoiDung> getNguoiDungs() {
        return nguoiDungs;
    }

    public void setNguoiDungs(Set<NguoiDung> nguoiDungs) {
        this.nguoiDungs = nguoiDungs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChuyenMon chuyenMon = (ChuyenMon) o;
        return id == chuyenMon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
