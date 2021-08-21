package com.example.quanlyquanthuoc.repositorys.quanlykhothuoc;

import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuanLyKhoThuocRepository extends JpaRepository<KhoThuoc, Long> {
    @Query(value = "select * from kho_thuoc t where t.flag = true order by t.so_luong_da_ban desc limit  10", nativeQuery = true)
    List<KhoThuoc> listTop10ThuocBanChay();
}
