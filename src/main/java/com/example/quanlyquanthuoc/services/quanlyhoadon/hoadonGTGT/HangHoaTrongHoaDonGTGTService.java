package com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT_DTO;

import java.util.List;
import java.util.Map;

public interface HangHoaTrongHoaDonGTGTService {
    public Map<String, Object> create(HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto);

    public Map<String, Object> update(Long id, HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto);

    public Map<String, Object> updateHangHoaTrongHoaDonGTGT(Long id, HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteTungHoaDon(Long id);


    public void deleteById(Long id);

    QuanLyBanHang findById(Long id);

    public List<HangHoaTrongHoaDonGTGT_DTO> getAllHangHoaByIdHoaDon(Long id);


}
