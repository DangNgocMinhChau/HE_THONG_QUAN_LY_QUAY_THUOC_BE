package com.example.quanlyquanthuoc.controllers.danhmuc.phanloaithuoc;

import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuocDTO;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuyenDto;
import com.example.quanlyquanthuoc.services.danhmuc.phanloaithuoc.PhanLoaiThuocService;
import com.example.quanlyquanthuoc.services.quanlytaikhoan.QuyenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlyphanloaithuoc")
public class PhanLoaiThuocController {

    @Autowired
    private PhanLoaiThuocService phanLoaiThuocService;
    @GetMapping("/find")
    public Map<String,Object> getAll () {
        return phanLoaiThuocService.getAll();
    }
    @PostMapping()
    public Map<String,Object> create (@RequestBody PhanLoaiThuocDTO phanLoaiThuocDTO){
        return phanLoaiThuocService.create(phanLoaiThuocDTO);
    }

    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody PhanLoaiThuocDTO phanLoaiThuocDTO) {
        return phanLoaiThuocService.update(id,phanLoaiThuocDTO);
    }
    @DeleteMapping()
    public Map<String,Object> delete (@RequestBody Long[] ids) {
        return phanLoaiThuocService.delete(ids);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getByID(@PathVariable Long id){
        return phanLoaiThuocService.fetchById(id);
    }

}
