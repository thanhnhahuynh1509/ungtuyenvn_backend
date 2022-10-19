package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.HinhAnhDuAn;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.HinhAnhDuAnService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/hinh_anh_du_an")
public class HinhAnhDuAnController extends BaseController<HinhAnhDuAn, Long> {

    public HinhAnhDuAnController(HinhAnhDuAnService baseService) {
        super(baseService);
    }

    @PostMapping("/upload")
    public List<HinhAnhDuAn> save(@RequestPart MultipartFile[] files, @RequestPart HinhAnhDuAn[] hinhAnhDuAns) {
        return null;
    }

}
