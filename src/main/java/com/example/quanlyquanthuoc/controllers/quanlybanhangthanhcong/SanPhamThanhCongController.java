package com.example.quanlyquanthuoc.controllers.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import com.example.quanlyquanthuoc.services.quanlybanhangthanhcong.SanPhamThanhCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sanphamthanhcong")
public class SanPhamThanhCongController {

    @Autowired
    private SanPhamThanhCongService sanPhamThanhCongService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody SanPhamDTO sanPhamDTO){
        return sanPhamThanhCongService.create(sanPhamDTO);
    }

    @GetMapping()
    public Map<String,Object> getAll () {
        return sanPhamThanhCongService.getAll();
    }


    @GetMapping(value="/{id}")
    public Map<String,Object> getById (@PathVariable Long id) {
        return sanPhamThanhCongService.fetchById(id);
    }


    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
        return sanPhamThanhCongService.delete(ids);
    }

    @DeleteMapping(value="/{id}")
    public void deleteById (@PathVariable Long id) {
        sanPhamThanhCongService.deleteById(id);
    }


    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody SanPhamDTO sanPhamDTO) {
        return sanPhamThanhCongService.update(id,sanPhamDTO);
    }

    @GetMapping(value="/getAllSanPhamByIdHoaDon/{id}")
    public  Map<String,Object> getAllHoaDonByKhachHang(@PathVariable Long id){
        return sanPhamThanhCongService.getAllSanPhamByIdHoaDon(id);
    }

    @PutMapping(value="/updatesanphamtronghoadon/{id}")
    public Map<String,Object> updateSanPhamTrongHoaDon (@PathVariable Long id, @RequestBody SanPhamDTO sanPhamDTO) {
        return sanPhamThanhCongService.updateSanPhamTrongHoaDon(id,sanPhamDTO);
    }


}
