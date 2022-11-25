package com.doanchuyennganh.ungtuyenvn.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "NguoiDung")
public class NguoiDung {

    public static final String imagePath = "assets/common/image/nguoi_dung";
    public static final String cvPath = "assets/common/cv";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, nullable = false, length = 200)
    private String email;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(nullable = false)
    private String ho = "";

    @Column(nullable = false)
    private String ten = "";

    private String avatar;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa = "";

    @Column(name = "ngay_sinh")
    private String ngaySinh = "";

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "cong_khai")
    private boolean congKhai = false;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "tieu_de_ung_tuyen")
    private String tieuDeUngTuyen = "";

    @Column(name = "ly_do_lam_viec_voi_toi", columnDefinition = "TEXT")
    private String lyDoLamViecVoiToi = "";

    @Column(columnDefinition = "TEXT")
    private String cv;

    private boolean enabled = true;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name = "ma_loai")
    private LoaiNguoiDung loaiNguoiDung;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "ma_nguoi_dung")
    private List<DuAn> duAns = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "ma_nguoi_dung")
    private List<ThongBao> thongBaos = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "ma_nguoi_dung")
    private List<HoSoLamViec> hoSoLamViecs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "ma_nguoi_dung")
    private List<KyNang> kyNangLamViecs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "ma_nguoi_dung")
    private List<ThongTinLienLac> thongTinLienLacs = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ChuyenMonNguoiDung",
    joinColumns = @JoinColumn(name = "ma_nguoi_dung"),
    inverseJoinColumns = @JoinColumn(name = "ma_chuyen_mon"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ChuyenMon> chuyenMons = new LinkedHashSet<>();

    public NguoiDung() {
    }

    public NguoiDung(long id) {
        this.id = id;
    }

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

    public List<DuAn> getDuAns() {
        return duAns;
    }

    public void setDuAns(List<DuAn> duAns) {
        this.duAns.clear();
        this.duAns.addAll(duAns);
    }

    public List<ThongBao> getThongBaos() {
        return thongBaos;
    }

    public void setThongBaos(List<ThongBao> thongBaos) {
        this.thongBaos.clear();
        this.thongBaos.addAll(thongBaos);
    }

    public List<HoSoLamViec> getHoSoLamViecs() {
        return hoSoLamViecs;
    }

    public void setHoSoLamViecs(List<HoSoLamViec> hoSoLamViecs) {
        this.hoSoLamViecs.clear();
        this.hoSoLamViecs.addAll(hoSoLamViecs);
    }

    public List<ThongTinLienLac> getThongTinLienLacs() {
        return thongTinLienLacs;
    }

    public void setThongTinLienLacs(List<ThongTinLienLac> thongTinLienLacs) {
        this.thongTinLienLacs.clear();
        this.thongTinLienLacs.addAll(thongTinLienLacs);
    }

    public LoaiNguoiDung getLoaiNguoiDung() {
        return loaiNguoiDung;
    }

    public void setLoaiNguoiDung(LoaiNguoiDung loaiNguoiDung) {
        this.loaiNguoiDung = loaiNguoiDung;
    }

    public Set<ChuyenMon> getChuyenMons() {
        return chuyenMons;
    }

    public void setChuyenMons(Set<ChuyenMon> chuyenMons) {
        this.chuyenMons.clear();
        this.chuyenMons.addAll(chuyenMons);
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
        this.kyNangLamViecs.clear();
        this.kyNangLamViecs.addAll(kyNangLamViecs);
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
