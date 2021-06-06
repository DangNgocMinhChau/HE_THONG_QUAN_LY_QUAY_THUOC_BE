package com.example.quanlyquanthuoc.services.quanlybanhang;



import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPham;

import java.util.List;
import java.util.Map;

public interface QuanLyBanHangService {
    public Map<String,Object> create(QuanLyBanHangDTO quanLyBanHangDTO);
    public Map<String,Object> update(Long id, QuanLyBanHangDTO quanLyBanHangDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
    QuanLyBanHang findById(Long id);
    public List<SanPham> getAllSanPhamById(Long id);

}
