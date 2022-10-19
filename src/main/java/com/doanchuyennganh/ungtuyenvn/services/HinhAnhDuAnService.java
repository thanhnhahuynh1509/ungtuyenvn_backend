package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.HinhAnhDuAn;
import com.doanchuyennganh.ungtuyenvn.repository.HinhAnhDuAnRepository;
import org.springframework.stereotype.Service;

@Service
public class HinhAnhDuAnService extends BaseService<HinhAnhDuAn, Long> {

    public HinhAnhDuAnService(HinhAnhDuAnRepository baseRepository) {
        super(baseRepository, HinhAnhDuAn.class.getSimpleName());
    }

    @Override
    public HinhAnhDuAn update(Long id, HinhAnhDuAn model) {
        HinhAnhDuAn hinhAnhDuAn = getSingleResultById(id);
        hinhAnhDuAn.setLienKet(model.getLienKet());
        return baseRepository.save(hinhAnhDuAn);
    }
}
