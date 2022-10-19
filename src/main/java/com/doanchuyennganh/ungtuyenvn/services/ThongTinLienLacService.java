package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.ThongTinLienLac;
import com.doanchuyennganh.ungtuyenvn.repository.ThongTinLienLacRepository;
import org.springframework.stereotype.Service;

@Service
public class ThongTinLienLacService extends BaseService<ThongTinLienLac, Long> {

    public ThongTinLienLacService(ThongTinLienLacRepository baseRepository) {
        super(baseRepository, ThongTinLienLac.class.getSimpleName());
    }

    @Override
    public ThongTinLienLac update(Long id, ThongTinLienLac model) {
        ThongTinLienLac thongTinLienLac = getSingleResultById(id);
        thongTinLienLac.setTenThongTin(model.getTenThongTin());
        thongTinLienLac.setGiaTriThongTin(model.getGiaTriThongTin());
        return baseRepository.save(thongTinLienLac);
    }
}
