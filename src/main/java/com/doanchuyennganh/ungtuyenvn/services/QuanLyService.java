package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvn.repository.QuanLyRepository;
import org.springframework.stereotype.Service;

@Service
public class QuanLyService extends BaseService<QuanLy, Long> {

    public QuanLyService(QuanLyRepository baseRepository) {
        super(baseRepository, QuanLy.class.getSimpleName());
    }

    @Override
    public QuanLy update(Long id, QuanLy model) {
        QuanLy quanLy = getSingleResultById(id);
        quanLy.setHo(model.getHo());
        quanLy.setDiaChi(model.getDiaChi());
        quanLy.setNgaySinh(model.getNgaySinh());
        quanLy.setSoDienThoai(model.getSoDienThoai());
        quanLy.setTen(model.getTen());
        return baseRepository.save(quanLy);
    }
}
