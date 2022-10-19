package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.security.JWTProvider;
import com.doanchuyennganh.ungtuyenvn.services.NguoiDungService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tai_khoan")
public class TaiKhoanNguoiDungController {

    private final JWTProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    private final NguoiDungService nguoiDungService;

    public TaiKhoanNguoiDungController(JWTProvider jwtProvider, AuthenticationManager authenticationManager, NguoiDungService nguoiDungService) {
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
        this.nguoiDungService = nguoiDungService;
    }

    @PostMapping("/dang_nhap")
    public String dangNhap(@RequestBody NguoiDung nguoiDung) {
        Authentication upAuth = new UsernamePasswordAuthenticationToken(nguoiDung.getEmail(), nguoiDung.getMatKhau());
        Authentication authentication = authenticationManager.authenticate(upAuth);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }

    @PostMapping("/dang_ky")
    @ResponseStatus(HttpStatus.CREATED)
    public String dangKy(@RequestBody NguoiDung nguoiDung) {
        nguoiDungService.save(nguoiDung);
        return "Save user successfully!";
    }
}
