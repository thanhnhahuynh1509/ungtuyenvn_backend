package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvn.services.QuanLyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quan_ly")
public class QuanLyController extends BaseController<QuanLy, Long> {

    public QuanLyController(QuanLyService baseService) {
        super(baseService);
    }
}
