package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.LoaiNguoiDung;
import com.doanchuyennganh.ungtuyenvn.repository.LoaiNguoiDungRepository;
import org.springframework.stereotype.Service;

@Service
public class LoaiNguoiDungService extends BaseService<LoaiNguoiDung, Long> {

    public LoaiNguoiDungService(LoaiNguoiDungRepository baseRepository) {
        super(baseRepository, LoaiNguoiDung.class.getSimpleName());
    }

    @Override
    public LoaiNguoiDung update(Long id, LoaiNguoiDung model) {
        LoaiNguoiDung loaiNguoiDung = getSingleResultById(id);
        loaiNguoiDung.setMoTa(model.getMoTa());
        loaiNguoiDung.setTenLoai(model.getTenLoai());
        return baseRepository.save(loaiNguoiDung);
    }
}
