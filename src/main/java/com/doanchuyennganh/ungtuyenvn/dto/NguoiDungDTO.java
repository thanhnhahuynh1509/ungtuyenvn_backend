package com.doanchuyennganh.ungtuyenvn.dto;

import com.doanchuyennganh.ungtuyenvn.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NguoiDungDTO {

    private long id;
    private String email;
    private String ho;
    private String ten;
    private String avatar;
    private String moTa;
    private String ngaySinh;
    private String trangThai;
    private boolean congKhai = false;
    private String thanhPho;
    private String tieuDeUngTuyen;
    private String lyDoLamViecVoiToi;
    private LoaiNguoiDung loaiNguoiDung;
    private String cv;
    private List<DuAn> duAns = new ArrayList<>();
    private List<ThongBao> thongBaos = new ArrayList<>();
    private List<HoSoLamViec> hoSoLamViecs = new ArrayList<>();
    private List<ThongTinLienLac> thongTinLienLacs = new ArrayList<>();
    private Set<ChuyenMon> chuyenMons = new HashSet<>();
    private List<KyNang> kyNangLamViecs = new ArrayList<>();

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isCongKhai() {
        return congKhai;
    }

    public void setCongKhai(boolean congKhai) {
        this.congKhai = congKhai;
    }

    public LoaiNguoiDung getLoaiNguoiDung() {
        return loaiNguoiDung;
    }

    public void setLoaiNguoiDung(LoaiNguoiDung loaiNguoiDung) {
        this.loaiNguoiDung = loaiNguoiDung;
    }

    public List<DuAn> getDuAns() {
        return duAns;
    }

    public void setDuAns(List<DuAn> duAns) {
        this.duAns = duAns;
    }

    public List<ThongBao> getThongBaos() {
        return thongBaos;
    }

    public void setThongBaos(List<ThongBao> thongBaos) {
        this.thongBaos = thongBaos;
    }

    public List<HoSoLamViec> getHoSoLamViecs() {
        return hoSoLamViecs;
    }

    public void setHoSoLamViecs(List<HoSoLamViec> hoSoLamViecs) {
        this.hoSoLamViecs = hoSoLamViecs;
    }

    public List<ThongTinLienLac> getThongTinLienLacs() {
        return thongTinLienLacs;
    }

    public void setThongTinLienLacs(List<ThongTinLienLac> thongTinLienLacs) {
        this.thongTinLienLacs = thongTinLienLacs;
    }

    public Set<ChuyenMon> getChuyenMons() {
        return chuyenMons;
    }

    public void setChuyenMons(Set<ChuyenMon> chuyenMons) {
        this.chuyenMons = chuyenMons;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getTieuDeUngTuyen() {
        return tieuDeUngTuyen;
    }

    public void setTieuDeUngTuyen(String tieuDeUngTuyen) {
        this.tieuDeUngTuyen = tieuDeUngTuyen;
    }

    public String getLyDoLamViecVoiToi() {
        return lyDoLamViecVoiToi;
    }

    public void setLyDoLamViecVoiToi(String lyDoLamViecVoiToi) {
        this.lyDoLamViecVoiToi = lyDoLamViecVoiToi;
    }

    public List<KyNang> getKyNangLamViecs() {
        return kyNangLamViecs;
    }

    public void setKyNangLamViecs(List<KyNang> kyNangLamViecs) {
        this.kyNangLamViecs = kyNangLamViecs;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}
