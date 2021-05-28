package com.chaudang.managephamarcity.controllers.quanlybanhangthanhcong;


import com.chaudang.managephamarcity.models.quanlybanhang.SanPhamDTO;
import com.chaudang.managephamarcity.services.quanlybanhangthanhcong.SanPhamThanhCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
