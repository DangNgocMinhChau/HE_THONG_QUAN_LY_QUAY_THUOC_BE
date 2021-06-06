package com.example.quanlyquanthuoc.services.quanlytaikhoan;


import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoanDTO;

import java.util.Map;

public interface QuanLyTaiKhoanService {
    public Map<String,Object> create(QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);
    public Map<String,Object> update(Long id, QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAllTaiKhoan();
    public Map<String,Object> delete(Long[] listIds);
    QuanLyTaiKhoan findById(Long id);

}
