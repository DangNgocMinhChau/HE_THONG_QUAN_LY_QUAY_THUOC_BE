package com.example.quanlyquanthuoc.services.quanlybaiviet;

import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiViet;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiVietDto;

import java.util.Map;

public interface QuanLyBaiVietService {
    QuanLyBaiViet findById(Long baiVietId);

    public Map<String, Object> create(QuanLyBaiVietDto quanLyBaiVietDto);

    public Map<String, Object> update(Long id, QuanLyBaiVietDto quanLyBaiVietDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getTinTucTheoTag(String tag);


    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

}
