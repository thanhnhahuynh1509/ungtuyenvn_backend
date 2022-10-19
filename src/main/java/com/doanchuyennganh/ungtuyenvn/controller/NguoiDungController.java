package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.dto.NguoiDungDTO;
import com.doanchuyennganh.ungtuyenvn.entity.ChuyenMon;
import com.doanchuyennganh.ungtuyenvn.entity.DuAn;
import com.doanchuyennganh.ungtuyenvn.entity.HinhAnhDuAn;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.security.JWTProvider;
import com.doanchuyennganh.ungtuyenvn.services.DuAnService;
import com.doanchuyennganh.ungtuyenvn.services.NguoiDungService;
import com.doanchuyennganh.ungtuyenvn.utils.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/nguoi_dung")
public class NguoiDungController extends BaseController<NguoiDung, Long> {

    private final NguoiDungService nguoiDungService;
    private final DuAnService duAnService;
    private final JWTProvider jwtProvider;

    private final ModelMapper modelMapper;

    public NguoiDungController(NguoiDungService baseService, DuAnService duAnService, JWTProvider jwtProvider, ModelMapper modelMapper) {
        super(baseService);
        nguoiDungService = (NguoiDungService) baseService;
        this.duAnService = duAnService;
        this.jwtProvider = jwtProvider;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/get_by_token")
    public ResponseEntity<NguoiDungDTO> getByToken(@RequestBody String token) {
        String username = jwtProvider.getUsernameFromToken(token);
        return ResponseEntity.ok(modelMapper.map(nguoiDungService.getByEmail(username), NguoiDungDTO.class));
    }

    @PostMapping("/{id}/chuyen_mon/{maChuyenMon}")
    public ResponseEntity<NguoiDung> addChuyenMon(@PathVariable Long id, @PathVariable Long maChuyenMon) {
        return ResponseEntity.ok(nguoiDungService.addChuyenMon(id, new ChuyenMon(maChuyenMon)));
    }

    @DeleteMapping("/{id}/chuyen_mon/{maChuyenMon}")
    public ResponseEntity<NguoiDung> deleteChuyenMon(@PathVariable Long id, @PathVariable Long maChuyenMon) {
        return ResponseEntity.ok(nguoiDungService.removeChuyenMon(id, new ChuyenMon(maChuyenMon)));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> capNhatHinhAnh(@PathVariable long id, @RequestPart MultipartFile imageFile) {
        String result = "";
        try {
            String imageName = FileUtils.generateFileName(imageFile);

            File file = new File(NguoiDung.imagePath);

            if(!file.exists())
                file.mkdir();
            String path = file.getAbsolutePath();
            FileUtils.upload(path, imageName, imageFile);
            result = NguoiDung.imagePath + "/" + imageName;

            nguoiDungService.capNhatHinhAnh(id, result);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("NOT OK");
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/{id}/du_an")
    public ResponseEntity<NguoiDungDTO> luuDuAnNguoiDung(@PathVariable long id,
                                                         @RequestPart(required = false) MultipartFile primaryImageFile,
                                                         @RequestPart(required = false) MultipartFile[] optionalImageFiles,
                                                         @RequestPart DuAn duAn) throws IOException {
        // hình ảnh chính dự án
        if(primaryImageFile != null && !primaryImageFile.isEmpty()) {
            String imagePrimaryName = FileUtils.generateFileName(primaryImageFile);
            File file = new File(DuAn.duAnImage);
            if(!file.exists()) {
                file.mkdir();
            }
            duAn.setHinhAnh(DuAn.duAnImage + "/" + imagePrimaryName);
            FileUtils.upload(file.getAbsolutePath(), imagePrimaryName, primaryImageFile);
        }

        // hình ảnh bổ sung
        if(optionalImageFiles != null && optionalImageFiles.length > 0) {
            List<HinhAnhDuAn> hinhAnhDuAns = new ArrayList<>();
            for(MultipartFile multipartFile : optionalImageFiles) {
                String imageOptionalName = FileUtils.generateFileName(multipartFile);
                HinhAnhDuAn hinhAnhDuAn = new HinhAnhDuAn();
                hinhAnhDuAns.add(hinhAnhDuAn);
                hinhAnhDuAn.setLienKet(DuAn.duAnImage + "/" + imageOptionalName);
                File fileOptional = new File(DuAn.duAnImage);
                FileUtils.upload(fileOptional.getAbsolutePath(), imageOptionalName, multipartFile);
            }
            duAn.setHinhAnhDuAns(hinhAnhDuAns);
        }

        return ResponseEntity.ok(modelMapper.map(nguoiDungService.themVaCapNhatDuAn(id, duAn), NguoiDungDTO.class));
    }

    @PostMapping(value = "/{id}/du_an/{maDuAn}")
    public ResponseEntity<NguoiDungDTO> capNhatDuAnNguoiDung(@PathVariable long id,
                                                             @PathVariable long maDuAn,
                                                             @RequestPart(required = false) MultipartFile primaryImageFile,
                                                             @RequestPart(required = false) MultipartFile[] optionalImageFiles,
                                                             @RequestPart DuAn duAn) throws IOException {
        DuAn duAnDB = duAnService.get(maDuAn);

        List<HinhAnhDuAn> listTemp = new ArrayList<>(duAnDB.getHinhAnhDuAns());
        listTemp.removeAll(duAn.getHinhAnhDuAns());
        if(listTemp.size() > 0) {
            for(HinhAnhDuAn hinhAnhDuAn : listTemp) {
                FileUtils.delete(hinhAnhDuAn.getLienKet());
            }
        }

        // hình ảnh chính dự án
        if(primaryImageFile != null && !primaryImageFile.isEmpty()) {
            String imagePrimaryName = FileUtils.generateFileName(primaryImageFile);
            File file = new File(DuAn.duAnImage);
            if(!file.exists()) {
                file.mkdir();
            }
            FileUtils.delete(duAnDB.getHinhAnh());
            duAnDB.setHinhAnh(DuAn.duAnImage + "/" + imagePrimaryName);
            FileUtils.upload(file.getAbsolutePath(), imagePrimaryName, primaryImageFile);
        }

        // hình ảnh bổ sung
        if(optionalImageFiles != null && optionalImageFiles.length > 0) {
            List<HinhAnhDuAn> hinhAnhDuAns = new ArrayList<>();
            for(MultipartFile multipartFile : optionalImageFiles) {
                String imageOptionalName = FileUtils.generateFileName(multipartFile);
                HinhAnhDuAn hinhAnhDuAn = new HinhAnhDuAn();
                hinhAnhDuAns.add(hinhAnhDuAn);
                hinhAnhDuAn.setLienKet(DuAn.duAnImage + "/" + imageOptionalName);
                File fileOptional = new File(DuAn.duAnImage);
                FileUtils.upload(fileOptional.getAbsolutePath(), imageOptionalName, multipartFile);
            }
            duAn.getHinhAnhDuAns().addAll(hinhAnhDuAns);
        }

        duAnDB.setHinhAnhDuAns(duAn.getHinhAnhDuAns());

        return ResponseEntity.ok(modelMapper.map(nguoiDungService.themVaCapNhatDuAn(id, duAnDB), NguoiDungDTO.class));
    }

}
