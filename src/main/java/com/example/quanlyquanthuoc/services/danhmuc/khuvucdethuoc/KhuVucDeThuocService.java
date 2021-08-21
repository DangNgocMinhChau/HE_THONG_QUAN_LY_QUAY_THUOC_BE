package com.example.quanlyquanthuoc.services.danhmuc.khuvucdethuoc;

import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuoc;
import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuocDTO;

import java.util.Map;

public interface KhuVucDeThuocService {
    public Map<String, Object> create(KhuVucDeThuocDTO khuVucDeThuocDTO);

    public Map<String, Object> update(Long id, KhuVucDeThuocDTO khuVucDeThuocDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public void deleteById(Long id);

    KhuVucDeThuoc findById(Long id);
}
