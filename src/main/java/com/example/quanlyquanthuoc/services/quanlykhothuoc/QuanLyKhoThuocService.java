package com.example.quanlyquanthuoc.services.quanlykhothuoc;


import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuocDTO;

import java.util.Map;

public interface QuanLyKhoThuocService {
    public Map<String, Object> create(KhoThuocDTO khoThuocDTO);

    public Map<String, Object> update(Long id, KhoThuocDTO khoThuocDTO);

    public Map<String, Object> updateLaiKhoThuocKhiEditHoadon(Long id, KhoThuocDTO khoThuocDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> updateKhoThuoc();

    public Map<String, Object> getAll();

    public Map<String, Object> getAllThungRacKhoThuoc();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> getTop10thuocBanChay();

    KhoThuoc findById(Long id);
}
