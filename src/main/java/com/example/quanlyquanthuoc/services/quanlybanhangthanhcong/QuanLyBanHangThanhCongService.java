package com.example.quanlyquanthuoc.services.quanlybanhangthanhcong;


import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;

import java.util.List;
import java.util.Map;

public interface QuanLyBanHangThanhCongService {
    public Map<String,Object> create(QuanLyBanHangDTO quanLyBanHangDTO);
    public Map<String,Object> update(Long id, QuanLyBanHangDTO quanLyBanHangDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
    QuanLyBanHangThanhCong findById(Long id);
    public List<SanPhamThanhCong> getAllSanPhamById(Long id);
    public Map<String,Object> findAllHoaDonByIdKhachHang(Long idKhachHang);
}
