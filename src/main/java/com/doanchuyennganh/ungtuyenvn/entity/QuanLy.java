package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class QuanLy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "mat_khau",nullable = false)
    private String matKhau;

    private String ho;

    private String ten;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi", columnDefinition = "TEXT")
    private String diaChi;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    // Foreign keys

    @ManyToMany
    @JoinTable(name = "QuyenQuanLy", joinColumns = @JoinColumn(name = "ma_quan_ly"), inverseJoinColumns = @JoinColumn(name = "ma_quyen"))
    private Set<Quyen> quyens = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Set<Quyen> getQuyens() {
        return quyens;
    }

    public void setQuyens(Set<Quyen> quyens) {
        this.quyens = quyens;
    }
}
