package com.example.quanlyquanthuoc.controllers.quanlybanhang;


import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.repositorys.quanlybanhang.QuanLyBanHangRepository;
import com.example.quanlyquanthuoc.services.quanlybanhang.QuanLyBanHangService;
import com.example.quanlyquanthuoc.services.quanlybanhang.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybanhang")
public class QuanLyBanHangController {

    @Autowired
    private QuanLyBanHangService quanLyBanHangService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private QuanLyBanHangRepository quanLyBanHangRepository;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyBanHangDTO quanLyBanHangDTO) {
        return quanLyBanHangService.create(quanLyBanHangDTO);
    }

    @GetMapping()
    public Map<String, Object> getAll() {
        return quanLyBanHangService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyBanHangService.delete(ids);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        quanLyBanHangRepository.deleteById(id);
    }


    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyBanHangDTO quanLyBanHangDTO) {
        return quanLyBanHangService.update(id, quanLyBanHangDTO);
    }


    @GetMapping(value = "/getAllSanPhamByIdBanHang/{id}")
    public List<SanPhamDTO> getQuanLyBanHangById(@PathVariable Long id) {
        return sanPhamService.getAllSanPhamById(id);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getQuanLyTaiKhoanById(@PathVariable Long id) {
        return quanLyBanHangService.fetchById(id);
    }
}
