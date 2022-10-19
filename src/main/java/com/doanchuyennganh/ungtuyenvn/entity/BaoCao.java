package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;

@Entity
public class BaoCao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "ngay_bao_cao", length = 100)
    private String ngayBaoCao;

    @Column(name = "yeu_cau")
    private String yeuCau;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNgayBaoCao() {
        return ngayBaoCao;
    }

    public void setNgayBaoCao(String ngayBaoCao) {
        this.ngayBaoCao = ngayBaoCao;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }
}
