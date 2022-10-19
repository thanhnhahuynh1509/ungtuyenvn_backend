package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.KyNang;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.KyNangService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ky_nang")
public class KyNangController extends BaseController<KyNang, Long> {

    public KyNangController(KyNangService baseService) {
        super(baseService);
    }
}
