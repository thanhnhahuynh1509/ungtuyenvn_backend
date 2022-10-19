package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.HoSoLamViec;
import com.doanchuyennganh.ungtuyenvn.repository.HoSoLamViecRepository;
import org.springframework.stereotype.Service;

@Service
public class HoSoLamViecService extends BaseService<HoSoLamViec, Long> {

    public HoSoLamViecService(HoSoLamViecRepository baseRepository) {
        super(baseRepository, HoSoLamViec.class.getSimpleName());
    }

    @Override
    public HoSoLamViec update(Long id, HoSoLamViec model) {
        HoSoLamViec hoSoLamViec = getSingleResultById(id);
        hoSoLamViec.setMoTa(model.getMoTa());
        hoSoLamViec.setTenCongViec(model.getTenCongViec());
        hoSoLamViec.setNgayBatDau(model.getNgayBatDau());
        hoSoLamViec.setNgayKetThuc(model.getNgayKetThuc());
        return baseRepository.save(hoSoLamViec);
    }
}
