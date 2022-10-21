package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.*;
import com.doanchuyennganh.ungtuyenvn.exception.model.UserExistsException;
import com.doanchuyennganh.ungtuyenvn.repository.NguoiDungRepository;
import com.doanchuyennganh.ungtuyenvn.utils.FileUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungService extends BaseService<NguoiDung, Long> {

    private final PasswordEncoder passwordEncoder;

    public NguoiDungService(NguoiDungRepository baseRepository, PasswordEncoder passwordEncoder) {
        super(baseRepository, NguoiDung.class.getSimpleName());
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public NguoiDung save(NguoiDung model) {
        if(isEmailExists(model.getEmail()))
            throw new UserExistsException("Email da ton tai");
        model.setMatKhau(passwordEncoder.encode(model.getMatKhau()));
        model.setLoaiNguoiDung(new LoaiNguoiDung(5));
        model.setThanhPho("Khác");
        return super.save(model);
    }

    @Override
    public NguoiDung update(Long id, NguoiDung model) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.setCongKhai(model.isCongKhai());
        nguoiDung.setHo(model.getHo());
        nguoiDung.setTen(model.getTen());
        nguoiDung.setMoTa(model.getMoTa());
        nguoiDung.setNgaySinh(model.getNgaySinh());
        nguoiDung.setTrangThai(model.getTrangThai());
        nguoiDung.setTieuDeUngTuyen(model.getTieuDeUngTuyen());
        nguoiDung.setThanhPho(model.getThanhPho());
        nguoiDung.setLoaiNguoiDung(model.getLoaiNguoiDung());
        nguoiDung.setLyDoLamViecVoiToi(model.getLyDoLamViecVoiToi());
        nguoiDung.setHoSoLamViecs(model.getHoSoLamViecs());
        nguoiDung.setKyNangLamViecs(model.getKyNangLamViecs());
        nguoiDung.setChuyenMons(model.getChuyenMons());
        nguoiDung.setThongTinLienLacs(model.getThongTinLienLacs());
        if(nguoiDung.getAvatar() != null
                && nguoiDung.getAvatar().length() > 0
                && nguoiDung.getMoTa().length() > 0
                && nguoiDung.getChuyenMons().size() > 0
                && nguoiDung.getHoSoLamViecs().size() > 0
                && nguoiDung.getLyDoLamViecVoiToi().length() > 0
                && nguoiDung.getTieuDeUngTuyen().length() > 0
                && nguoiDung.getKyNangLamViecs().size() > 0
                && nguoiDung.getThongTinLienLacs().size() > 0
                && nguoiDung.getTen().length() > 0
                && nguoiDung.getHo().length() > 0) {
            nguoiDung.setCongKhai(true);
        } else {
            nguoiDung.setCongKhai(false);
        }
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung themVaCapNhatCV(Long id, String cv) {
        NguoiDung nguoiDung = getSingleResultById(id);
        if(nguoiDung.getCv() != null) {
            FileUtils.delete(nguoiDung.getCv());
        }
        nguoiDung.setCv(cv);
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung themThongBao(long id, ThongBao thongBao) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.getThongBaos().add(thongBao);
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung themVaCapNhatDuAn(Long id, DuAn duAn) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.getDuAns().add(duAn);
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung addChuyenMon(Long id, ChuyenMon chuyenMon) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.getChuyenMons().add(chuyenMon);
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung removeChuyenMon(Long id, ChuyenMon chuyenMon) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.getChuyenMons().remove(chuyenMon);
        return baseRepository.save(nguoiDung);
    }

    public NguoiDung getByEmail(String email) {
        return ((NguoiDungRepository)baseRepository).findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Tai khoan hoac mat khau khong dung"));
    }

    private boolean isEmailExists(String email) {
        return ((NguoiDungRepository)baseRepository).findByEmail(email).isPresent();
    }

    public NguoiDung capNhatHinhAnh(long id, String imagePath) {
        NguoiDung nguoiDung = getSingleResultById(id);
        if(nguoiDung.getAvatar() != null) {
            FileUtils.delete(nguoiDung.getAvatar());
        }
        nguoiDung.setAvatar(imagePath);
        return baseRepository.save(nguoiDung);
    }
}
