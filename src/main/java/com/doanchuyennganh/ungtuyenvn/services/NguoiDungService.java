package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.ChuyenMon;
import com.doanchuyennganh.ungtuyenvn.entity.DuAn;
import com.doanchuyennganh.ungtuyenvn.entity.LoaiNguoiDung;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.exception.model.UserExistsException;
import com.doanchuyennganh.ungtuyenvn.repository.NguoiDungRepository;
import com.doanchuyennganh.ungtuyenvn.utils.FileUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        nguoiDung.setAvatar(model.getAvatar());
        nguoiDung.setCongKhai(model.isCongKhai());
        nguoiDung.setHo(model.getHo());
        nguoiDung.setTen(model.getTen());
        nguoiDung.setMoTa(model.getMoTa());
        nguoiDung.setNgaySinh(model.getNgaySinh());
        nguoiDung.setTrangThai(model.getMoTa());
        nguoiDung.setTieuDeUngTuyen(model.getTieuDeUngTuyen());
        nguoiDung.setThanhPho(model.getThanhPho());
        nguoiDung.setLoaiNguoiDung(model.getLoaiNguoiDung());
        nguoiDung.setLyDoLamViecVoiToi(model.getLyDoLamViecVoiToi());
        nguoiDung.setHoSoLamViecs(model.getHoSoLamViecs());
        nguoiDung.setKyNangLamViecs(model.getKyNangLamViecs());
        nguoiDung.setChuyenMons(model.getChuyenMons());
        nguoiDung.setThongTinLienLacs(model.getThongTinLienLacs());
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
        FileUtils.delete(nguoiDung.getAvatar());
        nguoiDung.setAvatar(imagePath);
        return baseRepository.save(nguoiDung);
    }
}
