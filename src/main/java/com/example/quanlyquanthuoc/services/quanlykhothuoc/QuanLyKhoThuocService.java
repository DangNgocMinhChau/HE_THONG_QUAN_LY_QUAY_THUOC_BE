package com.example.quanlyquanthuoc.services.quanlykhothuoc;



import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuocDTO;

import java.util.Map;

public interface QuanLyKhoThuocService {
    public Map<String,Object> create(KhoThuocDTO khoThuocDTO);
    public Map<String,Object> update(Long id, KhoThuocDTO khoThuocDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
    KhoThuoc findById(Long id);
}
