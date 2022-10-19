package com.doanchuyennganh.ungtuyenvn.security;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.services.NguoiDungService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final NguoiDungService nguoiDungService;

    public CustomUserDetailsService(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungService.getByEmail(username);
        return new CustomUserDetails(nguoiDung);
    }
}
