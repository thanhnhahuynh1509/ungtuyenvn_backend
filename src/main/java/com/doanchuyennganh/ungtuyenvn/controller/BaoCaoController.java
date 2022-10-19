package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.BaoCao;
import com.doanchuyennganh.ungtuyenvn.services.BaoCaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bao_cao")
public class BaoCaoController extends BaseController<BaoCao, Long> {

    public BaoCaoController(BaoCaoService baseService) {
        super(baseService);
    }
}
