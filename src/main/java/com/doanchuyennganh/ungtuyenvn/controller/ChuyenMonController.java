package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.ChuyenMon;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.ChuyenMonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chuyen_mon")
public class ChuyenMonController extends BaseController<ChuyenMon, Long> {

    public ChuyenMonController(ChuyenMonService baseService) {
        super(baseService);
    }

}
