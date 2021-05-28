package com.chaudang.managephamarcity.controllers.quanlycmnd;

import com.chaudang.managephamarcity.models.quanlycmnd.QuanLyCMND;
import com.chaudang.managephamarcity.models.quanlytaikhoan.QuanLyTaiKhoanDTO;
import com.chaudang.managephamarcity.services.quanlycmnd.QuanLyCmndService;
import com.chaudang.managephamarcity.services.quanlycmnd.QuanLyCmndServiceImpl;
import com.chaudang.managephamarcity.services.quanlytaikhoan.QuanLyTaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlycmnd")
public class QuanLyCMNDControllers {

    @Autowired
    private QuanLyCmndService quanLyCmndService;

    @PostMapping()
    public Map<String,Object> create (@RequestBody QuanLyCMND quanLyCMND){
        return quanLyCmndService.create(quanLyCMND);
    }

    @GetMapping()
    public Map<String,Object> getDanhSachThuoc () {
        return quanLyCmndService.getAllCMND();
    }

//    @DeleteMapping()
//    public Map<String,Object> delete (@RequestBody Long[] ids) {
//           return quanLyCmndService.delete(ids);
//    }

    @DeleteMapping(value = "/{id}")
    public Map<String,Object> delete (@PathVariable Long id) {
        return quanLyCmndService.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public Map<String,Object> update (@PathVariable Long id, @RequestBody QuanLyCMND quanLyCMND) {
        return quanLyCmndService.update(id,quanLyCMND);
    }

    @GetMapping(value="/{id}")
    public Map<String,Object> getById(@PathVariable Long id){
        return quanLyCmndService.fetchById(id);
    }
}
