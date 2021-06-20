package com.example.quanlyquanthuoc.controllers.quanlykhothuoc;

import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuocDTO;
import com.example.quanlyquanthuoc.services.quanlykhothuoc.QuanLyKhoThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlykho")
public class QuanLyKhoThuocController {

    @Autowired
    private QuanLyKhoThuocService quanLyKhoThuocService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody KhoThuocDTO khoThuocDTO){
        return quanLyKhoThuocService.create(khoThuocDTO);
    }

    @GetMapping()
    public Map<String,Object> getAll () {
        return quanLyKhoThuocService.getAll();
    }

    @GetMapping("/thungrackhothuoc")
    public Map<String,Object> getAllThungRacKhoThuoc () {
        return quanLyKhoThuocService.getAllThungRacKhoThuoc();
    }


    @DeleteMapping("/xoavinhvien")
    public Map<String,Object> deleteVinhvienKhoThuoc (@RequestBody Long[] ids) {
        return quanLyKhoThuocService.deleteVinhVien(ids);
    }

    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
        return quanLyKhoThuocService.delete(ids);
    }


    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody KhoThuocDTO khoThuocDTO) {
        return quanLyKhoThuocService.update(id,khoThuocDTO);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getQuanLyTaiKhoanById(@PathVariable Long id){
        return quanLyKhoThuocService.fetchById(id);
    }
}
