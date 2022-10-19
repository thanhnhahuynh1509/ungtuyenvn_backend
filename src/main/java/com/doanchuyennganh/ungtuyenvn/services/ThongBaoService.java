package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.ThongBao;
import com.doanchuyennganh.ungtuyenvn.repository.ThongBaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ThongBaoService extends BaseService<ThongBao, Long> {

    public ThongBaoService(ThongBaoRepository baseRepository) {
        super(baseRepository, ThongBao.class.getSimpleName());
    }

    @Override
    public ThongBao update(Long id, ThongBao model) {
        ThongBao thongBao = getSingleResultById(id);
        thongBao.setMucDo(model.getMucDo());
        thongBao.setNoiDung(model.getNoiDung());
        thongBao.setTieuDe(model.getTieuDe());
        thongBao.setNgayThongBao(model.getNgayThongBao());
        return baseRepository.save(thongBao);
    }
}
