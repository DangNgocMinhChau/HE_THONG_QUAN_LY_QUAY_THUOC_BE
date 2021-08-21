package com.example.quanlyquanthuoc.controllers.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGTDTO;
import com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT.HoaDonGTGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/hoadongtgt")
public class HoaDonGTGTController {

    @Autowired
    HoaDonGTGTService hoaDonGTGTService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody HoaDonGTGTDTO hoaDonGTGTDTO) {
        return hoaDonGTGTService.create(hoaDonGTGTDTO);
    }

    @GetMapping()
    public Map<String, Object> getAll() {
        return hoaDonGTGTService.getAll();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return hoaDonGTGTService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody HoaDonGTGTDTO hoaDonGTGTDTO) {
        return hoaDonGTGTService.update(id, hoaDonGTGTDTO);
    }

    @DeleteMapping(value = "phuchoihoadongtgtdaxoa/{id}")
    public Map<String, Object> update(@PathVariable Long id) {
        return hoaDonGTGTService.phucHoiHoaDonGTGTDaXoa(id);
    }

    @GetMapping(value = "/getAllHoaDonGTGTByDate")
    public Map<String, Object> getAllHoaDonGTGTByDate(@RequestParam String date) {
        return hoaDonGTGTService.getAllHoaDonGTGTByDate(date);
    }

    @GetMapping(value = "/getAllHoaDonGTGTDaXoa")
    public Map<String, Object> getAllHoaDonGTGTDaXoa() {
        return hoaDonGTGTService.getAllHoaDonGTGTDaXoa();
    }


    @GetMapping(value = "/{id}")
    public Map<String, Object> fetchById(@PathVariable Long id) {
        return hoaDonGTGTService.fetchById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Object> deleteHoaDonGTGT(@PathVariable Long id) {
        return hoaDonGTGTService.deleteHoaDonGTGT(id);
    }


}
