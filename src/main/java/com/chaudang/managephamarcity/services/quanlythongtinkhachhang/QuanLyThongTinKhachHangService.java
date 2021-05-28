package com.chaudang.managephamarcity.services.quanlythongtinkhachhang;

import com.chaudang.managephamarcity.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;

import java.util.Map;

public interface QuanLyThongTinKhachHangService {
    public Map<String,Object> create(QuanLyThongTinKhachHang quanLyThongTinKhachHang);
    public Map<String,Object> update(Long id,QuanLyThongTinKhachHang quanLyThongTinKhachHang);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
}
