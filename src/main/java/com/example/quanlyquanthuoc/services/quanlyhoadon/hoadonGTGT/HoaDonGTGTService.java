package com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT;


import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGT;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGTDTO;

import java.util.Map;

public interface HoaDonGTGTService {
    public Map<String,Object> create(HoaDonGTGTDTO hoaDonGTGTDTO);
    public Map<String,Object> update(Long id, HoaDonGTGTDTO hoaDonGTGTDTO);
    public Map<String,Object> fetchById(Long id);
    public Map<String,Object> getAll();
    public Map<String,Object> getAllHoaDonGTGTDaXoa();
    public Map<String,Object> delete(Long[] listIds);
    public Map<String,Object> deleteHoaDonGTGT(Long id);
    public Map<String,Object> phucHoiHoaDonGTGTDaXoa(Long id);
    HoaDonGTGT findById(Long id);
    public Map<String,Object> getAllHoaDonGTGTByDate(String date);



}
