package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.ThongBao;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.ThongBaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/thong_bao")
public class ThongBaoController extends BaseController<ThongBao, Long> {

    public ThongBaoController(ThongBaoService baseService) {
        super(baseService);
    }
}
