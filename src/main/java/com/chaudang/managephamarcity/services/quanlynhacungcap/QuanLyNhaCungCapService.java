package com.chaudang.managephamarcity.services.quanlynhacungcap;

import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCap;
import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCapDTO;

import java.util.Map;

public interface QuanLyNhaCungCapService {
    public Map<String,Object> create(QuanLyNhaCungCapDTO quanLyNhaCungCapDTO);
    public Map<String,Object> update(Long id,QuanLyNhaCungCapDTO quanLyNhaCungCapDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> delete(Long[] listIds);
    QuanLyNhaCungCap findById(Long id);

}
