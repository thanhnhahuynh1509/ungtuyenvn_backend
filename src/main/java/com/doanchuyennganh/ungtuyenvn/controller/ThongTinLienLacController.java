package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.ThongTinLienLac;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.ThongTinLienLacService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/thong_tin_lien_lac")
public class ThongTinLienLacController extends BaseController<ThongTinLienLac, Long> {

    public ThongTinLienLacController(ThongTinLienLacService baseService) {
        super(baseService);
    }
}
