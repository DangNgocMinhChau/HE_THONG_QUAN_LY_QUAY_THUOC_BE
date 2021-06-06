package com.example.quanlyquanthuoc.services.quanlynhacungcap;


import com.example.quanlyquanthuoc.models.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.quanlynhacungcap.QuanLyNhaCungCapDTO;
import com.example.quanlyquanthuoc.repositorys.quanlynhacungcap.QuanLyNhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyNhaCungCapServiceImpl implements QuanLyNhaCungCapService {

    @Autowired
    QuanLyNhaCungCapRepository quanLyNhaCungCapRepository;

    @Override
    public Map<String, Object> create(QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        Map<String,Object> result = new HashMap<>();
        QuanLyNhaCungCapDTO resultCreate = new QuanLyNhaCungCapDTO();
        try{
            QuanLyNhaCungCap quanLyNhaCungCap = new QuanLyNhaCungCap();
            quanLyNhaCungCap.setTenNhaCungCap(quanLyNhaCungCapDTO.getTenNhaCungCap());
            quanLyNhaCungCap.setDiaChiNhaCungCap(quanLyNhaCungCapDTO.getDiaChiNhaCungCap());
            quanLyNhaCungCap.setMa(quanLyNhaCungCapDTO.getMa());
            quanLyNhaCungCap.setMstNhaCungCap(quanLyNhaCungCapDTO.getMstNhaCungCap());
            quanLyNhaCungCap.setSoDienThoaiNhaCungCap(quanLyNhaCungCapDTO.getSoDienThoaiNhaCungCap());
            quanLyNhaCungCap.setZalo(quanLyNhaCungCapDTO.getZalo());
            quanLyNhaCungCap.setEmail(quanLyNhaCungCapDTO.getEmail());
            quanLyNhaCungCap.setFlag(true);
            quanLyNhaCungCap.setNguoiTaoId(quanLyNhaCungCapDTO.getNguoiTaoId());
            quanLyNhaCungCap.setNgayChinhSua(quanLyNhaCungCapDTO.getNgayChinhSua());
            quanLyNhaCungCap.setNgayTaoBanGhi(quanLyNhaCungCapDTO.getNgayTaoBanGhi());
            quanLyNhaCungCapRepository.save(quanLyNhaCungCap);


            resultCreate.setId(quanLyNhaCungCap.getId());
            resultCreate.setTenNhaCungCap(quanLyNhaCungCap.getTenNhaCungCap());
            resultCreate.setDiaChiNhaCungCap(quanLyNhaCungCap.getDiaChiNhaCungCap());
            resultCreate.setMa(quanLyNhaCungCap.getMa());
            resultCreate.setMstNhaCungCap(quanLyNhaCungCap.getMstNhaCungCap());
            resultCreate.setSoDienThoaiNhaCungCap(quanLyNhaCungCap.getSoDienThoaiNhaCungCap());
            resultCreate.setZalo(quanLyNhaCungCap.getZalo());
            resultCreate.setEmail(quanLyNhaCungCap.getEmail());
            resultCreate.setNguoiTaoId(quanLyNhaCungCap.getNguoiTaoId());
            resultCreate.setNgayChinhSua(quanLyNhaCungCap.getNgayChinhSua());
            resultCreate.setNgayTaoBanGhi(quanLyNhaCungCap.getNgayTaoBanGhi());

            result.put("result",resultCreate);
            result.put("msg","Thêm mói thành công");
            result.put("status",true);
        }catch (Exception e){
            result.put("msg","Thêm mới thất bại");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        Map<String,Object> result = new HashMap<>();
        QuanLyNhaCungCapDTO resultUpdate = new QuanLyNhaCungCapDTO();
        try {
            QuanLyNhaCungCap object = quanLyNhaCungCapRepository.findById(id).get();
            if(quanLyNhaCungCapDTO.getFlag() != null  && quanLyNhaCungCapDTO.getFlag() == false){
                object.setId(id);
                object.setTenNhaCungCap(quanLyNhaCungCapDTO.getTenNhaCungCap());
                object.setDiaChiNhaCungCap(quanLyNhaCungCapDTO.getDiaChiNhaCungCap());
                object.setMa(quanLyNhaCungCapDTO.getMa());
                object.setMstNhaCungCap(quanLyNhaCungCapDTO.getMstNhaCungCap());
                object.setSoDienThoaiNhaCungCap(quanLyNhaCungCapDTO.getSoDienThoaiNhaCungCap());
                object.setZalo(quanLyNhaCungCapDTO.getZalo());
                object.setEmail(quanLyNhaCungCapDTO.getEmail());
                object.setFlag(quanLyNhaCungCapDTO.getFlag());
                object.setNgayChinhSua(quanLyNhaCungCapDTO.getNgayChinhSua());
                quanLyNhaCungCapRepository.save(object);
                result.put("msg","Xóa thành công");
                result.put("status",true);
            }else {
                object.setId(id);
                object.setTenNhaCungCap(quanLyNhaCungCapDTO.getTenNhaCungCap());
                object.setDiaChiNhaCungCap(quanLyNhaCungCapDTO.getDiaChiNhaCungCap());
                object.setMa(quanLyNhaCungCapDTO.getMa());
                object.setMstNhaCungCap(quanLyNhaCungCapDTO.getMstNhaCungCap());
                object.setSoDienThoaiNhaCungCap(quanLyNhaCungCapDTO.getSoDienThoaiNhaCungCap());
                object.setZalo(quanLyNhaCungCapDTO.getZalo());
                object.setEmail(quanLyNhaCungCapDTO.getEmail());
                object.setNgayChinhSua(quanLyNhaCungCapDTO.getNgayChinhSua());
                quanLyNhaCungCapRepository.save(object);
                result.put("result",object);
                result.put("msg","sửa thành công");
                result.put("status",true);
            }

        }catch (Exception e){
            result.put("msg","Sửa thất bại");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String,Object> result = new HashMap<>();
        QuanLyNhaCungCap quanLyNhaCungCap = quanLyNhaCungCapRepository.findById(id).orElse(null);
        QuanLyNhaCungCapDTO quanLyNhaCungCapDTO = new QuanLyNhaCungCapDTO();
        try {
            if(quanLyNhaCungCap != null){
                quanLyNhaCungCapDTO.setId(quanLyNhaCungCap.getId());
                quanLyNhaCungCapDTO.setMa(quanLyNhaCungCap.getMa());
                quanLyNhaCungCapDTO.setTenNhaCungCap(quanLyNhaCungCap.getTenNhaCungCap());
                quanLyNhaCungCapDTO.setDiaChiNhaCungCap(quanLyNhaCungCap.getDiaChiNhaCungCap());
                quanLyNhaCungCapDTO.setMstNhaCungCap(quanLyNhaCungCap.getMstNhaCungCap());
                quanLyNhaCungCapDTO.setSoDienThoaiNhaCungCap(quanLyNhaCungCap.getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapDTO.setZalo(quanLyNhaCungCap.getZalo());
                quanLyNhaCungCapDTO.setEmail(quanLyNhaCungCap.getEmail());
                quanLyNhaCungCapDTO.setNguoiTaoId(quanLyNhaCungCap.getNguoiTaoId());
                quanLyNhaCungCapDTO.setFlag(quanLyNhaCungCap.getFlag());
                quanLyNhaCungCapDTO.setNgayChinhSua(quanLyNhaCungCap.getNgayChinhSua());
                quanLyNhaCungCapDTO.setNgayTaoBanGhi(quanLyNhaCungCap.getNgayTaoBanGhi());

                result.put("result",quanLyNhaCungCapDTO);
                result.put("status",true);
            }else {
                result.put("result",null);
                result.put("status",false);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("result",null);
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String,Object> result = new HashMap<>();
        try {
            List<QuanLyNhaCungCap> quanLyNhaCungCapList = quanLyNhaCungCapRepository.findAll();
            List<QuanLyNhaCungCapDTO> quanLyNhaCungCapDTOS = new ArrayList<>();
            for(QuanLyNhaCungCap quanLyNhaCungCap:quanLyNhaCungCapList){
                QuanLyNhaCungCapDTO quanLyNhaCungCapDTO = new QuanLyNhaCungCapDTO();
                quanLyNhaCungCapDTO.setId(quanLyNhaCungCap.getId());
                quanLyNhaCungCapDTO.setMa(quanLyNhaCungCap.getMa());
                quanLyNhaCungCapDTO.setTenNhaCungCap(quanLyNhaCungCap.getTenNhaCungCap());
                quanLyNhaCungCapDTO.setDiaChiNhaCungCap(quanLyNhaCungCap.getDiaChiNhaCungCap());
                quanLyNhaCungCapDTO.setMstNhaCungCap(quanLyNhaCungCap.getMstNhaCungCap());
                quanLyNhaCungCapDTO.setSoDienThoaiNhaCungCap(quanLyNhaCungCap.getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapDTO.setZalo(quanLyNhaCungCap.getZalo());
                quanLyNhaCungCapDTO.setEmail(quanLyNhaCungCap.getEmail());
                quanLyNhaCungCapDTO.setNguoiTaoId(quanLyNhaCungCap.getNguoiTaoId());
                quanLyNhaCungCapDTO.setNgayTaoBanGhi(quanLyNhaCungCap.getNgayTaoBanGhi());
                quanLyNhaCungCapDTO.setNgayChinhSua(quanLyNhaCungCap.getNgayChinhSua());
                quanLyNhaCungCapDTO.setFlag(quanLyNhaCungCap.getFlag());
                if(quanLyNhaCungCap.getFlag() != null && quanLyNhaCungCap.getFlag()){
                    quanLyNhaCungCapDTOS.add(quanLyNhaCungCapDTO);
                }
            }
            result.put("result", quanLyNhaCungCapDTOS);
            result.put("status",true);
        }catch (Exception e){
            result.put("msg", "Lay danh sach  that bai");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {
        return null;
    }

    @Override
    public QuanLyNhaCungCap findById(Long id) {
        return quanLyNhaCungCapRepository.findById(id).orElse(null);
    }
}
