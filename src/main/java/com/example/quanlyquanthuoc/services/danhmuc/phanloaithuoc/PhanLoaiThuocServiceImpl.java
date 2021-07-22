package com.example.quanlyquanthuoc.services.danhmuc.phanloaithuoc;


import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuoc;
import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuocDTO;
import com.example.quanlyquanthuoc.repositorys.danhmuc.phanloaithuoc.PhanLoaiThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhanLoaiThuocServiceImpl implements PhanLoaiThuocService {

    @Autowired
    PhanLoaiThuocRepository phanLoaiThuocRepository;

    @Override
    public Map<String, Object> create(PhanLoaiThuocDTO phanLoaiThuocDTO) {
        Map<String, Object> result = new HashMap<>();
        PhanLoaiThuocDTO resultCreate = new PhanLoaiThuocDTO();
        try {
            PhanLoaiThuoc phanLoaiThuoc = new PhanLoaiThuoc();
            phanLoaiThuoc.setMa(phanLoaiThuocDTO.getMa());
            phanLoaiThuoc.setTen(phanLoaiThuocDTO.getTen());
            phanLoaiThuoc.setNgayTaoBanGhi(phanLoaiThuocDTO.getNgayTaoBanGhi());
            phanLoaiThuoc.setFlag(true);
            phanLoaiThuocRepository.save(phanLoaiThuoc);

            resultCreate.setId(phanLoaiThuoc.getId());
            resultCreate.setMa(phanLoaiThuocDTO.getMa());
            resultCreate.setTen(phanLoaiThuocDTO.getTen());
            result.put("result", resultCreate);
            result.put("msg", "Thêm mới thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, PhanLoaiThuocDTO phanLoaiThuocDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            PhanLoaiThuoc object = phanLoaiThuocRepository.findById(id).get();
            object.setId(phanLoaiThuocDTO.getId() != null ? phanLoaiThuocDTO.getId() : object.getId());
            object.setMa(phanLoaiThuocDTO.getMa() != null ? phanLoaiThuocDTO.getMa() : object.getMa());
            object.setTen(phanLoaiThuocDTO.getTen() != null ? phanLoaiThuocDTO.getTen() : object.getTen());
            object.setNgayChinhSua(phanLoaiThuocDTO.getNgayChinhSua());

            phanLoaiThuocRepository.save(object);
            result.put("result", object);
            result.put("msg", "Sửa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Sửa thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        PhanLoaiThuoc phanLoaiThuoc = phanLoaiThuocRepository.findById(id).orElse(null);
        PhanLoaiThuocDTO phanLoaiThuocDTO = new PhanLoaiThuocDTO();
        try {
            if (phanLoaiThuoc != null) {
                phanLoaiThuocDTO.setId(phanLoaiThuoc.getId());
                phanLoaiThuocDTO.setMa(phanLoaiThuoc.getMa());
                phanLoaiThuocDTO.setTen(phanLoaiThuoc.getTen());
                result.put("result", phanLoaiThuocDTO);
                result.put("msg", "Lấy thành công !");
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("msg", "Lấy thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<PhanLoaiThuoc> phanLoaiThuocList = phanLoaiThuocRepository.findAll();
            List<PhanLoaiThuocDTO> phanLoaiThuocDTOList = new ArrayList<>();
            for (PhanLoaiThuoc phanLoaiThuoc : phanLoaiThuocList) {
                PhanLoaiThuocDTO phanLoaiThuocDTO = new PhanLoaiThuocDTO();
                phanLoaiThuocDTO.setId(phanLoaiThuoc.getId());
                phanLoaiThuocDTO.setMa(phanLoaiThuoc.getMa());
                phanLoaiThuocDTO.setTen(phanLoaiThuoc.getTen());
                if (phanLoaiThuoc.getFlag()) {
                    phanLoaiThuocDTOList.add(phanLoaiThuocDTO);
                }
            }
            result.put("result", phanLoaiThuocDTOList);
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
            PhanLoaiThuoc phanLoaiThuoc = phanLoaiThuocRepository.findById(listIds[i]).orElse(null);
            phanLoaiThuoc.setFlag(false);

            phanLoaiThuocRepository.save(phanLoaiThuoc);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PhanLoaiThuoc findById(Long id) {
        return phanLoaiThuocRepository.findById(id).orElse(null);
    }
}
