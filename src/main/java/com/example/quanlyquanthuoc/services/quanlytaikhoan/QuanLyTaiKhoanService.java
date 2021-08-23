package com.example.quanlyquanthuoc.services.quanlytaikhoan;


import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoanDTO;

import java.util.Map;

public interface QuanLyTaiKhoanService {
    public Map<String, Object> create(QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);

    public Map<String, Object> update(Long id, QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAllTaiKhoan();

    public Map<String, Object> delete(Long[] listIds);

    QuanLyTaiKhoan findById(Long id);

    public Map<String, Object> loginUser(String account, String password);

    public Map<String, Object> getAccoutByTenDangNhap(String account);

    public Map<String, Object> findAll(String  searchString,Integer pageSize,Integer page,String sortData);

}
