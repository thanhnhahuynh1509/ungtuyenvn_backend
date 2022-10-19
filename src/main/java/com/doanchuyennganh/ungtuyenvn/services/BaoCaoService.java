package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.BaoCao;
import com.doanchuyennganh.ungtuyenvn.repository.BaoCaoRepository;
import org.springframework.stereotype.Service;

@Service
public class BaoCaoService extends BaseService<BaoCao, Long> {

    public BaoCaoService(BaoCaoRepository baseRepository) {
        super(baseRepository, BaoCao.class.getSimpleName());
    }

    @Override
    public BaoCao update(Long id, BaoCao model) {
        BaoCao baoCao = getSingleResultById(id);
        baoCao.setTieuDe(model.getTieuDe());
        baoCao.setNoiDung(model.getNoiDung());
        baoCao.setYeuCau(model.getYeuCau());
        return baseRepository.save(baoCao);
    }
}
