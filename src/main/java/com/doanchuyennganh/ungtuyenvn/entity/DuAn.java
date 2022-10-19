package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DuAn {

    public static final String duAnImage = "assets/common/image/du_an";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_du_an", nullable = false)
    private String tenDuAn;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "lien_ket")
    private String lienKet;

    // Foreign Keys
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ma_du_an")
    private List<HinhAnhDuAn> hinhAnhDuAns = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public List<HinhAnhDuAn> getHinhAnhDuAns() {
        return hinhAnhDuAns;
    }

    public void setHinhAnhDuAns(List<HinhAnhDuAn> hinhAnhDuAns) {
        this.hinhAnhDuAns.clear();
        this.hinhAnhDuAns.addAll(hinhAnhDuAns);
    }
}
