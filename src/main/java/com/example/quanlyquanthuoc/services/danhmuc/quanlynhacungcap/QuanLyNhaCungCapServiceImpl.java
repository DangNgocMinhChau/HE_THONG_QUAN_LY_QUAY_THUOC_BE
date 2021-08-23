package com.example.quanlyquanthuoc.services.danhmuc.quanlynhacungcap;


import com.example.quanlyquanthuoc.common.PaginationDto;
import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.NhaCungCapSelect;
import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCapDTO;
import com.example.quanlyquanthuoc.models.danhmuc.quyen.Quyen;
import com.example.quanlyquanthuoc.models.danhmuc.tag.Tag;
import com.example.quanlyquanthuoc.models.danhmuc.tag.TagDto;
import com.example.quanlyquanthuoc.models.danhmuc.tag.TagSelect;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiVietDto;
import com.example.quanlyquanthuoc.repositorys.danhmuc.quanlynhacungcap.QuanLyNhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyNhaCungCapServiceImpl implements QuanLyNhaCungCapService {

    @Autowired
    QuanLyNhaCungCapRepository quanLyNhaCungCapRepository;

    @Autowired
    QuanLyNhaCungCapDao quanLyNhaCungCapDao;

    @Override
    public Map<String, Object> create(QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        Map<String, Object> result = new HashMap<>();
        QuanLyNhaCungCapDTO resultCreate = new QuanLyNhaCungCapDTO();
        try {
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

            result.put("result", resultCreate);
            result.put("msg", "Thêm mới thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyNhaCungCapDTO quanLyNhaCungCapDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            QuanLyNhaCungCap object = quanLyNhaCungCapRepository.findById(id).get();

            object.setTenNhaCungCap(quanLyNhaCungCapDTO.getTenNhaCungCap());
            object.setDiaChiNhaCungCap(quanLyNhaCungCapDTO.getDiaChiNhaCungCap());
            object.setMa(quanLyNhaCungCapDTO.getMa());
            object.setMstNhaCungCap(quanLyNhaCungCapDTO.getMstNhaCungCap());
            object.setSoDienThoaiNhaCungCap(quanLyNhaCungCapDTO.getSoDienThoaiNhaCungCap());
            object.setZalo(quanLyNhaCungCapDTO.getZalo());
            object.setEmail(quanLyNhaCungCapDTO.getEmail());
            object.setNgayChinhSua(quanLyNhaCungCapDTO.getNgayChinhSua());
            quanLyNhaCungCapRepository.save(object);
            result.put("result", object);
            result.put("msg", "sửa thành công");
            result.put("status", true);

        } catch (Exception e) {
            result.put("msg", "Sửa thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        QuanLyNhaCungCap quanLyNhaCungCap = quanLyNhaCungCapRepository.findById(id).orElse(null);
        QuanLyNhaCungCapDTO quanLyNhaCungCapDTO = new QuanLyNhaCungCapDTO();
        try {
            if (quanLyNhaCungCap != null) {
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

                result.put("result", quanLyNhaCungCapDTO);
                result.put("status", true);
            } else {
                result.put("result", null);
                result.put("status", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<QuanLyNhaCungCap> quanLyNhaCungCapList = quanLyNhaCungCapRepository.findAll();
            List<QuanLyNhaCungCapDTO> quanLyNhaCungCapDTOS = new ArrayList<>();
            for (QuanLyNhaCungCap quanLyNhaCungCap : quanLyNhaCungCapList) {
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
                if (quanLyNhaCungCap.getFlag() != null && quanLyNhaCungCap.getFlag()) {
                    quanLyNhaCungCapDTOS.add(quanLyNhaCungCapDTO);
                }
            }
            result.put("result", quanLyNhaCungCapDTOS);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {

        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            QuanLyNhaCungCap quanLyNhaCungCap = quanLyNhaCungCapRepository.findById(listIds[i]).orElse(null);
            quanLyNhaCungCap.setFlag(false);
            quanLyNhaCungCapRepository.save(quanLyNhaCungCap);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }

    @Override
    public QuanLyNhaCungCap findById(Long id) {
        return quanLyNhaCungCapRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> getAllSelect() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<QuanLyNhaCungCap> nhaCungCapList = quanLyNhaCungCapRepository.findAll();
            List<NhaCungCapSelect> nhaCungCapSelects = new ArrayList<>();
            for (QuanLyNhaCungCap quanLyNhaCungCap : nhaCungCapList) {
                NhaCungCapSelect nhaCungCapSelect = new NhaCungCapSelect();
                nhaCungCapSelect.setId(quanLyNhaCungCap.getId());
                nhaCungCapSelect.setValue(quanLyNhaCungCap.getMa());
                nhaCungCapSelect.setTen(quanLyNhaCungCap.getTenNhaCungCap());
                if (quanLyNhaCungCap.getFlag()) {
                    nhaCungCapSelects.add(nhaCungCapSelect);
                }
            }
            result.put("result", nhaCungCapSelects);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData) {
        Map<String,Object> mapResult = new HashMap<>();
        try{
            if(sortData == null){
                sortData ="id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null){
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page,pageSize,quanLyNhaCungCapDao.countNhaCungCap(searchString)));
            }

            List<QuanLyNhaCungCap> quanLyNhaCungCapList = quanLyNhaCungCapDao.getListNhaCungCap(searchString,pageable,sortData);
            List<QuanLyNhaCungCapDTO> quanLyNhaCungCapDTOS = new ArrayList<QuanLyNhaCungCapDTO>();
            for(QuanLyNhaCungCap quanLyNhaCungCap : quanLyNhaCungCapList){
                QuanLyNhaCungCapDTO quanLyNhaCungCapDTO = new QuanLyNhaCungCapDTO();
                quanLyNhaCungCapDTO.setId(quanLyNhaCungCap.getId());
                quanLyNhaCungCapDTO.setMa(quanLyNhaCungCap.getMa());
                quanLyNhaCungCapDTO.setTenNhaCungCap(quanLyNhaCungCap.getTenNhaCungCap());
                quanLyNhaCungCapDTO.setDiaChiNhaCungCap(quanLyNhaCungCap.getDiaChiNhaCungCap());
                quanLyNhaCungCapDTO.setEmail(quanLyNhaCungCap.getEmail());
                quanLyNhaCungCapDTO.setSoDienThoaiNhaCungCap(quanLyNhaCungCap.getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapDTO.setMstNhaCungCap(quanLyNhaCungCap.getMstNhaCungCap());
                quanLyNhaCungCapDTO.setZalo(quanLyNhaCungCap.getZalo());
                quanLyNhaCungCapDTOS.add(quanLyNhaCungCapDTO);
            }
            mapResult.put("result",quanLyNhaCungCapDTOS);
            mapResult.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            mapResult.put("result",null);
            mapResult.put("status",false);
            mapResult.put("msg","Lấy danh sách thất bại");
        }
        return mapResult;
    }
}
