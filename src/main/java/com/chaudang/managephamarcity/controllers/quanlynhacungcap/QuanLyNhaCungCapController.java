package com.chaudang.managephamarcity.controllers.quanlynhacungcap;


import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCapDTO;
import com.chaudang.managephamarcity.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.chaudang.managephamarcity.repositorys.quanlynhacungcap.QuanLyNhaCungCapRepository;
import com.chaudang.managephamarcity.services.quanlynhacungcap.QuanLyNhaCungCapService;
import com.chaudang.managephamarcity.services.quanlythongtinkhachhang.QuanLyThongTinKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlynhacungcap")
public class QuanLyNhaCungCapController {

    @Autowired
    private QuanLyNhaCungCapService quanLyNhaCungCapService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody QuanLyNhaCungCapDTO quanLyNhaCungCapDTO){
        return quanLyNhaCungCapService.create(quanLyNhaCungCapDTO);
    }

    @GetMapping()
    public Map<String,Object> getAll () {
        return quanLyNhaCungCapService.getAll();
    }

    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
        return quanLyNhaCungCapService.delete(ids);
    }

    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        return quanLyNhaCungCapService.update(id,quanLyNhaCungCapDTO);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getQuanLyTaiKhoanById(@PathVariable Long id){
        return quanLyNhaCungCapService.fetchById(id);
    }
}
