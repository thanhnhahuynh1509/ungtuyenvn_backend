package com.doanchuyennganh.ungtuyenvn.repository;

import com.doanchuyennganh.ungtuyenvn.entity.QuanLy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuanLyRepository extends JpaRepository<QuanLy, Long> {

    @Query("SELECT q FROM QuanLy q WHERE q.email = ?1")
    Optional<QuanLy> findByEmail(String email);
}
