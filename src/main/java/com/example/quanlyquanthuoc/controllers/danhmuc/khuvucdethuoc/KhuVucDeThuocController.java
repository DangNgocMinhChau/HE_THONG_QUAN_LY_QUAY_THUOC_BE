package com.example.quanlyquanthuoc.controllers.danhmuc.khuvucdethuoc;

import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuocDTO;
import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuocDTO;
import com.example.quanlyquanthuoc.services.danhmuc.khuvucdethuoc.KhuVucDeThuocService;
import com.example.quanlyquanthuoc.services.danhmuc.phanloaithuoc.PhanLoaiThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlykhuvucdethuoc")
public class KhuVucDeThuocController {

    @Autowired
    private KhuVucDeThuocService khuVucDeThuocService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return khuVucDeThuocService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody KhuVucDeThuocDTO khuVucDeThuocDTO) {
        return khuVucDeThuocService.create(khuVucDeThuocDTO);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody KhuVucDeThuocDTO khuVucDeThuocDTO) {
        return khuVucDeThuocService.update(id, khuVucDeThuocDTO);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return khuVucDeThuocService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return khuVucDeThuocService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return khuVucDeThuocService.findAll(searchString,pageSize,page,sortData);
    }
}
