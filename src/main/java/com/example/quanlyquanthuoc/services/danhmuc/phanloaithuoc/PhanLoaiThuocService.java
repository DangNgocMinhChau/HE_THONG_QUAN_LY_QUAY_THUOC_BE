package com.example.quanlyquanthuoc.services.danhmuc.phanloaithuoc;


import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuoc;
import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuocDTO;

import java.util.Map;

public interface PhanLoaiThuocService {
    public Map<String, Object> create(PhanLoaiThuocDTO phanLoaiThuocDTO);

    public Map<String, Object> update(Long id, PhanLoaiThuocDTO phanLoaiThuocDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public void deleteById(Long id);

    PhanLoaiThuoc findById(Long id);

}
