package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.DuAn;
import com.doanchuyennganh.ungtuyenvn.repository.DuAnRepository;
import org.springframework.stereotype.Service;

@Service
public class DuAnService extends BaseService<DuAn, Long> {

    public DuAnService(DuAnRepository baseRepository) {
        super(baseRepository, DuAn.class.getSimpleName());
    }

    @Override
    public DuAn update(Long id, DuAn model) {
        DuAn duAn = getSingleResultById(id);
        duAn.setHinhAnh(model.getHinhAnh());
        duAn.setLienKet(model.getLienKet());
        duAn.setMoTa(model.getMoTa());
        duAn.setTenDuAn(model.getTenDuAn());
        return baseRepository.save(duAn);
    }
}
