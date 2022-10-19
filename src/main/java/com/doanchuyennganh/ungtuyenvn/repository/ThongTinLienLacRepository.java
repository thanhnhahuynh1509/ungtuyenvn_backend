package com.doanchuyennganh.ungtuyenvn.repository;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.entity.ThongTinLienLac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThongTinLienLacRepository extends JpaRepository<ThongTinLienLac, Long> {

}
