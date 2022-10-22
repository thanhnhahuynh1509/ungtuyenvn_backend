package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.BaoCao;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.services.BaoCaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/bao_cao")
public class BaoCaoController extends BaseController<BaoCao, Long> {

    public BaoCaoController(BaoCaoService baseService) {
        super(baseService);
    }

    @PostMapping("/nguoi_dung/{id}")
    public ResponseEntity<BaoCao> luuBaoCao(@PathVariable long id, @RequestBody BaoCao baoCao) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setId(id);
        baoCao.setNguoiDung(nguoiDung);
        baoCao.setNgayBaoCao(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        return new ResponseEntity<>(baseService.save(baoCao), HttpStatus.CREATED);
    }
}
