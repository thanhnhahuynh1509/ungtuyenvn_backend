package com.doanchuyennganh.ungtuyenvn.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileUtils {

    public static void upload(String path, String fileName, MultipartFile file) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(path + "/" + fileName));
        fos.write(file.getBytes());
        fos.close();
    }

    public static boolean delete(String path) {
        File file = new File(path);
        if(file.isDirectory())
            return false;
        return file.delete();
    }

    public static String generateFileName(MultipartFile file) {
        LocalDateTime localDateTime = LocalDateTime.now();

        String[] fileContain = file.getOriginalFilename().split("[.]");
        String extension = fileContain[fileContain.length - 1];
        String fileName = localDateTime.getDayOfMonth() + ""
                + localDateTime.getMonthValue() + ""
                + localDateTime.getDayOfYear() + ""
                + localDateTime.getHour() + ""
                + localDateTime.getMinute() + ""
                + localDateTime.getSecond() + ""
                + localDateTime.getNano() + "." + extension;
        return fileName;
    }


}
