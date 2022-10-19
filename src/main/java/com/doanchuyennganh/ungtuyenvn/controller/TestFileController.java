package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.Test;
import com.doanchuyennganh.ungtuyenvn.utils.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/test")
public class TestFileController {

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart MultipartFile imageFile, @RequestPart Test test) throws IOException {
        System.out.println(imageFile.getContentType());
        System.out.println(imageFile.getOriginalFilename());
        System.out.println(test);
//        FileUtils.upload("D:/Sách", imageFile.getOriginalFilename(), imageFile);
        return "";
    }
}
