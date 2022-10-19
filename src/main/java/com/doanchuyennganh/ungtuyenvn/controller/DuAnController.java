package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.DuAn;
import com.doanchuyennganh.ungtuyenvn.entity.HinhAnhDuAn;
import com.doanchuyennganh.ungtuyenvn.services.BaseService;
import com.doanchuyennganh.ungtuyenvn.services.DuAnService;
import com.doanchuyennganh.ungtuyenvn.utils.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/du_an")
public class DuAnController extends BaseController<DuAn, Long> {

    public DuAnController(DuAnService baseService) {
        super(baseService);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        DuAn duAn = baseService.get(id);
        if (duAn.getHinhAnhDuAns().size() > 0) {
            for (HinhAnhDuAn hinhAnhDuAn : duAn.getHinhAnhDuAns()) {
                FileUtils.delete(hinhAnhDuAn.getLienKet());
            }
        }
        if (duAn.getHinhAnh() != null)
            FileUtils.delete(duAn.getHinhAnh());
        baseService.delete(id);
        return ResponseEntity.ok("Xóa thanh công");
    }
}
