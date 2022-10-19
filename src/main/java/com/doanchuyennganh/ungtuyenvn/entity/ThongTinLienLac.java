package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;

@Entity
public class ThongTinLienLac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_thong_tin")
    private String tenThongTin;

    @Column(name = "gia_tri_thong_tin")
    private String giaTriThongTin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenThongTin() {
        return tenThongTin;
    }

    public void setTenThongTin(String tenThongTin) {
        this.tenThongTin = tenThongTin;
    }

    public String getGiaTriThongTin() {
        return giaTriThongTin;
    }

    public void setGiaTriThongTin(String giaTriThongTin) {
        this.giaTriThongTin = giaTriThongTin;
    }
}
