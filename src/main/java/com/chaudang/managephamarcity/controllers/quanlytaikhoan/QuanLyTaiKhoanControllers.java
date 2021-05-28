package com.chaudang.managephamarcity.controllers.quanlytaikhoan;

import com.chaudang.managephamarcity.models.quanlytaikhoan.QuanLyTaiKhoanDTO;
import com.chaudang.managephamarcity.services.quanlytaikhoan.QuanLyTaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlytaikhoan")
public class QuanLyTaiKhoanControllers {

    @Autowired
    private QuanLyTaiKhoanServiceImpl quanLyTaiKhoanService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO){
        return quanLyTaiKhoanService.create(quanLyTaiKhoanDTO);
    }

    @GetMapping()
    public Map<String,Object> getDanhSachThuoc () {
        return quanLyTaiKhoanService.getAllTaiKhoan();
    }

    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
           return quanLyTaiKhoanService.delete(ids);
    }

    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        return quanLyTaiKhoanService.update(id,quanLyTaiKhoanDTO);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getQuanLyTaiKhoanById(@PathVariable Long id){
        System.out.println("qua ko");
        return quanLyTaiKhoanService.fetchById(id);
    }
}
