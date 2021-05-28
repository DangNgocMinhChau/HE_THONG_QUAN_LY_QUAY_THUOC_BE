package com.chaudang.managephamarcity.services.quanlythongtinkhachhang;

import com.chaudang.managephamarcity.models.quanlycmnd.QuanLyCMND;
import com.chaudang.managephamarcity.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.chaudang.managephamarcity.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.chaudang.managephamarcity.repositorys.quanlythongtinkhachhang.QuanLyThongTinKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyThongTinKhachHangServiceImpl implements QuanLyThongTinKhachHangService {

    @Autowired
    QuanLyThongTinKhachHangRepository quanLyThongTinKhachHangRepository;

    @Override
    public Map<String, Object> create(QuanLyThongTinKhachHang quanLyThongTinKhachHang) {
        Map<String,Object> result = new HashMap<>();
        QuanLyThongTinKhachHang quanLyThongTinKhachHangItem = new QuanLyThongTinKhachHang();
        try {
            quanLyThongTinKhachHangItem.setTenKhachHang(quanLyThongTinKhachHang.getTenKhachHang());
            quanLyThongTinKhachHangItem.setNgayChinhSua(quanLyThongTinKhachHang.getNgayChinhSua() != null ? quanLyThongTinKhachHang.getNgayChinhSua() : "");
            quanLyThongTinKhachHangItem.setNgayTaoBanGhi(quanLyThongTinKhachHang.getNgayTaoBanGhi());
            quanLyThongTinKhachHangItem.setSoDienThoai(quanLyThongTinKhachHang.getSoDienThoai());
            quanLyThongTinKhachHangItem.setFlag(true);

            quanLyThongTinKhachHangRepository.save(quanLyThongTinKhachHangItem);
            result.put("result",quanLyThongTinKhachHangItem);
            result.put("msg","Thêm mói thành công");
            result.put("status",true);
        }catch (Exception e){
            result.put("msg","Thêm mới thất bại");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyThongTinKhachHang quanLyThongTinKhachHang) {
        Map<String,Object> result = new HashMap<>();

        try {
            QuanLyThongTinKhachHang object = quanLyThongTinKhachHangRepository.findById(id).get();
            if(quanLyThongTinKhachHang.getFlag() != null &&  quanLyThongTinKhachHang.getFlag() == false ){
                object.setId(quanLyThongTinKhachHang.getId());
                object.setTenKhachHang(quanLyThongTinKhachHang.getTenKhachHang());
                object.setSoDienThoai(quanLyThongTinKhachHang.getSoDienThoai());
                object.setFlag(quanLyThongTinKhachHang.getFlag());
                object.setNgayTaoBanGhi(quanLyThongTinKhachHang.getNgayTaoBanGhi());
                object.setNgayChinhSua(quanLyThongTinKhachHang.getNgayChinhSua());
            }else{
                object.setId(quanLyThongTinKhachHang.getId());
                object.setTenKhachHang(quanLyThongTinKhachHang.getTenKhachHang());
                object.setSoDienThoai(quanLyThongTinKhachHang.getSoDienThoai());
                object.setFlag(true);
                object.setNgayTaoBanGhi(quanLyThongTinKhachHang.getNgayTaoBanGhi());
                object.setNgayChinhSua(quanLyThongTinKhachHang.getNgayChinhSua());
            }
                    quanLyThongTinKhachHangRepository.save(object);
            result.put("result",object);
            result.put("msg","sửa thành công");
            result.put("status",true);
        }catch (Exception e) {
            result.put("msg","Sửa thất bại");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String,Object> result = new HashMap<>();
        QuanLyThongTinKhachHang quanLyThongTinKhachHang = quanLyThongTinKhachHangRepository.findById(id).orElse(null);
        try{
            result.put("result",quanLyThongTinKhachHang);
            result.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("result",null);
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        List<QuanLyThongTinKhachHang> quanLyThongTinKhachHangList = quanLyThongTinKhachHangRepository.findAll();
        List<QuanLyThongTinKhachHang> listThongTinKhachHangDuocQuyenHienThi = new ArrayList<>();
        Map<String,Object> result = new HashMap<>();

        try {
            for(QuanLyThongTinKhachHang quanLyThongTinKhachHang : quanLyThongTinKhachHangList){

                if(quanLyThongTinKhachHang.getFlag()){
                    listThongTinKhachHangDuocQuyenHienThi.add(quanLyThongTinKhachHang);
                }
            }
            result.put("result", listThongTinKhachHangDuocQuyenHienThi);
            result.put("status",true);
        }catch (Exception e){
            result.put("msg", "Lấy danh sách thất bại!");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {
        return null;
    }
}
