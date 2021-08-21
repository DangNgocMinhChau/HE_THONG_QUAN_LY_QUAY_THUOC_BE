package com.example.quanlyquanthuoc.services.quanlybaocao;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import com.example.quanlyquanthuoc.models.quanlybaocao.BaoCaoTongQuatKhoThuocDto;
import com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong.QuanLyBanHangThanhCongRepository;
import com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong.SanPhamThanhCongRepository;
import com.example.quanlyquanthuoc.services.quanlybanhangthanhcong.SanPhamThanhCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyBaoCaoServiceImpl implements QuanLyBaoCaoService {
    @Autowired
    QuanLyBanHangThanhCongRepository quanLyBanHangThanhCongRepository;

    @Autowired
    SanPhamThanhCongRepository sanPhamThanhCongRepository;

    @Override
    public Map<String, Object> getBaoCaoThuocTheoNam() {
        Map<String, Object> result = new HashMap<>();
        List arrBaoCao = new ArrayList();
        String arrDate[] = {"2021", "2022", "2023"};

        try {
            SanPhamThanhCong sanPhamThanhCong = new SanPhamThanhCong();
            System.out.println(sanPhamThanhCong);
            for (int i = 0; i < arrDate.length; i++) {
                arrBaoCao.add(sanPhamThanhCongRepository.getBaoCaoThuocTheoNam("16", arrDate[i]));
            }
            result.put("result", arrBaoCao);
            result.put("msg", "Lấy thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy thất bại");
            result.put("status", false);
        }
        return result;
    }
}
