package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.DanhGia;
import com.doanchuyennganh.ungtuyenvn.repository.DanhGiaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DanhGiaService extends BaseService<DanhGia, Long> {

    public DanhGiaService(DanhGiaRepository baseRepository) {
        super(baseRepository, DanhGia.class.getSimpleName());
    }

    @Override
    public DanhGia update(Long id, DanhGia model) {
        DanhGia danhGia = getSingleResultById(id);
        danhGia.setTieuDe(model.getTieuDe());
        danhGia.setNoiDung(model.getNoiDung());
        return baseRepository.save(danhGia);
    }
}
