package com.example.quanlyquanthuoc.controllers.quanlybaiviet;

import com.example.quanlyquanthuoc.models.danhmuc.tag.TagDto;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiVietDto;
import com.example.quanlyquanthuoc.services.quanlybaiviet.QuanLyBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybaiviet")
public class QuanLyBaiVietController {

    @Autowired
    private QuanLyBaiVietService quanLyBaiVietService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return quanLyBaiVietService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyBaiVietDto quanLyBaiVietDto) {
        return quanLyBaiVietService.create(quanLyBaiVietDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyBaiVietDto quanLyBaiVietDto) {
        return quanLyBaiVietService.update(id, quanLyBaiVietDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyBaiVietService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return quanLyBaiVietService.fetchById(id);
    }

    @GetMapping(value = "/baiviettheotag")
    public Map<String, Object> getTinTucTheoTag(@RequestParam String tag) {
        return quanLyBaiVietService.getTinTucTheoTag(tag);
    }

}
