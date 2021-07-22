package com.example.quanlyquanthuoc.controllers.quanlybaocao;


import com.example.quanlyquanthuoc.services.quanlybaocao.QuanLyBaoCaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybaocao")
public class QuanLyBaoCaoController {

    @Autowired
    QuanLyBaoCaoService quanLyBaoCaoService;

    @GetMapping("/baocaotheonam")
    public Map<String,Object> getBaoCaoThuocTheoNam(){
        return quanLyBaoCaoService.getBaoCaoThuocTheoNam();
    }
}
