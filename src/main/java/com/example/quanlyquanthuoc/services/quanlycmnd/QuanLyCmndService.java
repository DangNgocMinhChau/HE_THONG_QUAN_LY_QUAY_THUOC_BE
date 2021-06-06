package com.example.quanlyquanthuoc.services.quanlycmnd;


import com.example.quanlyquanthuoc.models.quanlycmnd.QuanLyCMND;

import java.util.Map;

public interface QuanLyCmndService {
    public Map<String,Object> create(QuanLyCMND quanLyCMND);
    public Map<String,Object> update(Long id, QuanLyCMND quanLyCMND);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAllCMND();
    public Map<String,Object> delete(Long[] listIds);
    public Map<String,Object> deleteById(Long id);
}
