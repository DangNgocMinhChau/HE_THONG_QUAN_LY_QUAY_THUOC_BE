package com.example.quanlyquanthuoc.repositorys.danhmuc.phanloaithuoc;

import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuoc;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhanLoaiThuocRepository extends JpaRepository<PhanLoaiThuoc, Long> {

}
