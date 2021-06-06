package com.example.quanlyquanthuoc.controllers.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.repositorys.quanlybanhang.SanPhamRepository;
import com.example.quanlyquanthuoc.services.quanlybanhangthanhcong.QuanLyBanHangThanhCongService;
import com.example.quanlyquanthuoc.services.quanlybanhangthanhcong.SanPhamThanhCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybanhangthanhcong")
public class QuanLyBanHangThanhCongController {

    @Autowired
    private QuanLyBanHangThanhCongService quanLyBanHangThanhCongService;

    @Autowired
    private SanPhamThanhCongService sanPhamThanhCongService;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyBanHangDTO quanLyBanHangDTO) {
        sanPhamRepository.deleteAll();
        return quanLyBanHangThanhCongService.create(quanLyBanHangDTO);
    }

    @GetMapping()
    public Map<String, Object> getAll() {
        return quanLyBanHangThanhCongService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyBanHangThanhCongService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyBanHangDTO quanLyBanHangDTO) {
        return quanLyBanHangThanhCongService.update(id, quanLyBanHangDTO);
    }

    @GetMapping(value="/getAllSanPhamByIdBanHang/{id}")
    public List<SanPhamDTO> getQuanLyBanHangById(@PathVariable Long id){
        return sanPhamThanhCongService.getAllSanPhamById(id);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getQuanLyTaiKhoanById(@PathVariable Long id){
        return quanLyBanHangThanhCongService.fetchById(id);
    }
}
