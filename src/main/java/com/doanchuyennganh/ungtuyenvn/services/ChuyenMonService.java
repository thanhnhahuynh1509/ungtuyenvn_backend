package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.ChuyenMon;
import com.doanchuyennganh.ungtuyenvn.repository.ChuyenMonRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChuyenMonService extends BaseService<ChuyenMon, Long> {

    public ChuyenMonService(ChuyenMonRepository baseRepository) {
        super(baseRepository, ChuyenMon.class.getSimpleName());
    }

    @Override
    public List<ChuyenMon> gets() {
        return super.gets().stream().sorted(Comparator.comparing(ChuyenMon::getTenChuyenMon))
                .collect(Collectors.toList());
    }

    @Override
    public ChuyenMon update(Long id, ChuyenMon model) {
        ChuyenMon chuyenMon = getSingleResultById(id);
        chuyenMon.setTenChuyenMon(model.getTenChuyenMon());
        chuyenMon.setMoTa(chuyenMon.getMoTa());
        return baseRepository.save(chuyenMon);
    }
}
