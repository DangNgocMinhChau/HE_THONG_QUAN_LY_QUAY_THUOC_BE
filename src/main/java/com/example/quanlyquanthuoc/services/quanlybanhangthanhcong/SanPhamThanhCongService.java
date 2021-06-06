package com.example.quanlyquanthuoc.services.quanlybanhangthanhcong;



import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;

import java.util.List;
import java.util.Map;

public interface SanPhamThanhCongService {
    public Map<String,Object> create(SanPhamDTO sanPhamDTO);
    public Map<String,Object> update(Long id, SanPhamDTO sanPhamDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);

    public void deleteById(Long id);
    QuanLyBanHang findById(Long id);
    public List<SanPhamDTO> getAllSanPhamById(Long id);
    public List<SanPhamDTO> deleteById(List ids);

}
