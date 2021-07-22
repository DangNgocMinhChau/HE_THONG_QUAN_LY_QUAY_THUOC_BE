package com.example.quanlyquanthuoc.services.quanlytaikhoan;

import com.example.quanlyquanthuoc.models.quanlytaikhoan.Quyen;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuyenDto;

import java.util.Map;

public interface QuyenService {
    Quyen findById(Long quyenId);

    public Map<String, Object> create(QuyenDto quyenDto);

    public Map<String, Object> update(Long id, QuyenDto quyenDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

}
