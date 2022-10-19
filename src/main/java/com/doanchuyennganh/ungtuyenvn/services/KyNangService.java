package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.KyNang;
import com.doanchuyennganh.ungtuyenvn.repository.KyNangRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class KyNangService extends BaseService<KyNang, Long> {
    public KyNangService(KyNangRepository baseRepository) {
        super(baseRepository, KyNang.class.getSimpleName());
    }

    @Override
    public KyNang update(Long id, KyNang model) {
        KyNang kyNang = getSingleResultById(id);
        kyNang.setTenKyNang(model.getTenKyNang());
        kyNang.setMoTa(model.getMoTa());
        return baseRepository.save(kyNang);
    }
}
