package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.Quyen;
import com.doanchuyennganh.ungtuyenvn.repository.QuyenRepository;
import org.springframework.stereotype.Service;

@Service
public class QuyenService extends BaseService<Quyen, Long> {

    public QuyenService(QuyenRepository baseRepository) {
        super(baseRepository, Quyen.class.getSimpleName());
    }

    @Override
    public Quyen update(Long id, Quyen model) {
        Quyen quyen = getSingleResultById(id);
        quyen.setTenQuyen(model.getTenQuyen());
        quyen.setMoTa(model.getMoTa());
        return baseRepository.save(quyen);
    }
}
