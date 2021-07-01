package com.example.quanlyquanthuoc.controllers.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT_DTO;
import com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/hanghoahoadongtgt")
public class HangHoaTrongHoaDonGTGTController {

    @Autowired
    HangHoaTrongHoaDonGTGTService hangHoaTrongHoaDonGTGTService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto) {
        return hangHoaTrongHoaDonGTGTService.create(hangHoaTrongHoaDonGTGT_dto);
    }

    @GetMapping()
    public Map<String, Object> getAll() {
        return hangHoaTrongHoaDonGTGTService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return hangHoaTrongHoaDonGTGTService.delete(ids);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Object> deleteTungHoaDon(@PathVariable Long id) {
        return hangHoaTrongHoaDonGTGTService.deleteTungHoaDon(id);
    }


    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto) {
        return hangHoaTrongHoaDonGTGTService.update(id, hangHoaTrongHoaDonGTGT_dto);
    }

    @GetMapping(value="/getAllHangHoaByIdHoaDon/{id}")
    public List<HangHoaTrongHoaDonGTGT_DTO> getAllHangHoaByIdHoaDon(@PathVariable Long id){
        return hangHoaTrongHoaDonGTGTService.getAllHangHoaByIdHoaDon(id);
    }


}
