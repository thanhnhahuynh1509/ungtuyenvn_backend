package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.Quyen;
import com.doanchuyennganh.ungtuyenvn.services.QuyenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quyen")
public class QuyenController extends BaseController<Quyen, Long> {

    public QuyenController(QuyenService baseService) {
        super(baseService);
    }
}
