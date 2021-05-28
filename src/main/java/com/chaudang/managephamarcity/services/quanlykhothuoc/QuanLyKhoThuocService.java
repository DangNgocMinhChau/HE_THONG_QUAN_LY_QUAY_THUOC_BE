package com.chaudang.managephamarcity.services.quanlykhothuoc;

import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuoc;
import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuocDTO;
import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCapDTO;

import java.util.Map;

public interface QuanLyKhoThuocService {
    public Map<String,Object> create(KhoThuocDTO khoThuocDTO);
    public Map<String,Object> update(Long id,KhoThuocDTO khoThuocDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
    KhoThuoc findById (Long id);
}
