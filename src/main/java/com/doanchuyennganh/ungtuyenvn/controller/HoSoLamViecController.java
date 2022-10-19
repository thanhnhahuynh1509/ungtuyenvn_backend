package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.HoSoLamViec;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.HoSoLamViecService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ho_so_lam_viec")
public class HoSoLamViecController extends BaseController<HoSoLamViec, Long> {

    public HoSoLamViecController(HoSoLamViecService baseService) {
        super(baseService);
    }
}
