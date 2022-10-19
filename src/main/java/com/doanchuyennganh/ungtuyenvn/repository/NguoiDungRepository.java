package com.doanchuyennganh.ungtuyenvn.repository;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {

    @Query("SELECT n FROM NguoiDung n WHERE n.email = ?1")
    Optional<NguoiDung> findByEmail(String email);
}
