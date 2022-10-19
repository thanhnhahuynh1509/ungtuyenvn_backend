package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;

@Entity
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tieu_de")
    private String tieuDe;
    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;
    private String ho;
    private String ten;
    private String email;

    @Column(name = "ngay_danh_gia", length = 100)
    private String ngayDanhGia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(String ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
}
