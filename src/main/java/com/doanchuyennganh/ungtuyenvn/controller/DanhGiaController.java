package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.DanhGia;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.DanhGiaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/danh_gia")
public class DanhGiaController extends BaseController<DanhGia, Long> {

    public DanhGiaController(DanhGiaService baseService) {
        super(baseService);
    }
}
