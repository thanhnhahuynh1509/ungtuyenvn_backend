package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.LoaiNguoiDung;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.LoaiNguoiDungService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loai_nguoi_dung")
public class LoaiNguoiDungController extends BaseController<LoaiNguoiDung, Long> {

    public LoaiNguoiDungController(LoaiNguoiDungService baseService) {
        super(baseService);
    }
}
