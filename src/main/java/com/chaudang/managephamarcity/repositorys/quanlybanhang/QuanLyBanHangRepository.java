package com.chaudang.managephamarcity.repositorys.quanlybanhang;

import com.chaudang.managephamarcity.models.quanlybanhang.QuanLyBanHang;
import com.chaudang.managephamarcity.models.quanlybanhang.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuanLyBanHangRepository extends JpaRepository<QuanLyBanHang, Long> {
}
