package com.example.quanlyquanthuoc.controllers.quanlythongtinkhachhang;

import com.example.quanlyquanthuoc.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.example.quanlyquanthuoc.services.quanlythongtinkhachhang.QuanLyThongTinKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlythongtinkhachhang")
public class QuanLyThongTinKhachHangControllers {

    @Autowired
    private QuanLyThongTinKhachHangService quanLyThongTinKhachHangService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyThongTinKhachHang quanLyThongTinKhachHang) {
        return quanLyThongTinKhachHangService.create(quanLyThongTinKhachHang);
    }

    @GetMapping()
    public Map<String, Object> getDanhSachThuoc() {
        return quanLyThongTinKhachHangService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyThongTinKhachHangService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyThongTinKhachHang quanLyThongTinKhachHang) {
        return quanLyThongTinKhachHangService.update(id, quanLyThongTinKhachHang);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getQuanLyTaiKhoanById(@PathVariable Long id) {
        return quanLyThongTinKhachHangService.fetchById(id);
    }
}
