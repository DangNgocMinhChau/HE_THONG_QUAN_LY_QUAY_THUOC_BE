package com.example.quanlyquanthuoc.services.danhmuc.quanlynhacungcap;


import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCapDTO;

import java.util.Map;

public interface QuanLyNhaCungCapService {
    public Map<String, Object> create(QuanLyNhaCungCapDTO quanLyNhaCungCapDTO);

    public Map<String, Object> update(Long id, QuanLyNhaCungCapDTO quanLyNhaCungCapDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    QuanLyNhaCungCap findById(Long id);

    public Map<String, Object> getAllSelect();

    public Map<String, Object> findAll(String  searchString,Integer pageSize,Integer page,String sortData);

}
