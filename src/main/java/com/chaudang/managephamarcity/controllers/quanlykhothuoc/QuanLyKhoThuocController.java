package com.chaudang.managephamarcity.controllers.quanlykhothuoc;


import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuocDTO;
import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCapDTO;
import com.chaudang.managephamarcity.services.quanlykhothuoc.QuanLyKhoThuocService;
import com.chaudang.managephamarcity.services.quanlynhacungcap.QuanLyNhaCungCapService;
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
