package com.example.quanlyquanthuoc.controllers.danhmuc.quanlynhacungcap;

import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCapDTO;
import com.example.quanlyquanthuoc.services.danhmuc.quanlynhacungcap.QuanLyNhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/nhacungcap")
public class QuanLyNhaCungCapController {

    @Autowired
    private QuanLyNhaCungCapService quanLyNhaCungCapService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        return quanLyNhaCungCapService.create(quanLyNhaCungCapDTO);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return quanLyNhaCungCapService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyNhaCungCapService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        return quanLyNhaCungCapService.update(id, quanLyNhaCungCapDTO);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getQuanLyTaiKhoanById(@PathVariable Long id) {
        return quanLyNhaCungCapService.fetchById(id);
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return quanLyNhaCungCapService.findAll(searchString,pageSize,page,sortData);
    }


    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return quanLyNhaCungCapService.getAllSelect();
    }
}
