package com.chaudang.managephamarcity.controllers.quanlybanhang;


import com.chaudang.managephamarcity.models.quanlybanhang.SanPhamDTO;
import com.chaudang.managephamarcity.services.quanlybanhang.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody SanPhamDTO sanPhamDTO){
        return sanPhamService.create(sanPhamDTO);
    }

    @GetMapping()
    public Map<String,Object> getAll () {
        return sanPhamService.getAll();
    }

    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
        return sanPhamService.delete(ids);
    }

    @DeleteMapping(value="/{id}")
    public void deleteById (@PathVariable Long id) {
         sanPhamService.deleteById(id);
    }


    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody SanPhamDTO sanPhamDTO) {
        return sanPhamService.update(id,sanPhamDTO);
    }
}
