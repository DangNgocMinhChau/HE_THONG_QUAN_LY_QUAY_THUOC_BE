package com.example.quanlyquanthuoc.services.danhmuc.khuvucdethuoc;


import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuoc;
import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuocDTO;
import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuoc;
import com.example.quanlyquanthuoc.models.danhmuc.phanloaithuoc.PhanLoaiThuocDTO;
import com.example.quanlyquanthuoc.repositorys.danhmuc.khuvucdethuoc.KhuVucDeThuocRepository;
import com.example.quanlyquanthuoc.repositorys.danhmuc.phanloaithuoc.PhanLoaiThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KhuVucDeThuocServiceImpl implements KhuVucDeThuocService {

    @Autowired
    KhuVucDeThuocRepository khuVucDeThuocRepository;

    @Override
    public Map<String, Object> create(KhuVucDeThuocDTO khuVucDeThuocDTO) {
        Map<String, Object> result = new HashMap<>();
        PhanLoaiThuocDTO resultCreate = new PhanLoaiThuocDTO();
        try {
            KhuVucDeThuoc khuVucDeThuoc = new KhuVucDeThuoc();
            khuVucDeThuoc.setMa(khuVucDeThuocDTO.getMa());
            khuVucDeThuoc.setTen(khuVucDeThuocDTO.getTen());
            khuVucDeThuoc.setNgayTaoBanGhi(khuVucDeThuocDTO.getNgayTaoBanGhi());
            khuVucDeThuoc.setFlag(true);
            khuVucDeThuocRepository.save(khuVucDeThuoc);

            resultCreate.setId(khuVucDeThuocDTO.getId());
            resultCreate.setMa(khuVucDeThuocDTO.getMa());
            resultCreate.setTen(khuVucDeThuocDTO.getTen());
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
    public Map<String, Object> update(Long id, KhuVucDeThuocDTO khuVucDeThuocDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            KhuVucDeThuoc object = khuVucDeThuocRepository.findById(id).get();
            object.setId(khuVucDeThuocDTO.getId() != null ? khuVucDeThuocDTO.getId() : object.getId());
            object.setMa(khuVucDeThuocDTO.getMa() != null ? khuVucDeThuocDTO.getMa() : object.getMa());
            object.setTen(khuVucDeThuocDTO.getTen() != null ? khuVucDeThuocDTO.getTen() : object.getTen());
            object.setNgayChinhSua(khuVucDeThuocDTO.getNgayChinhSua());

            khuVucDeThuocRepository.save(object);
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
        KhuVucDeThuoc khuVucDeThuoc = khuVucDeThuocRepository.findById(id).orElse(null);
        PhanLoaiThuocDTO phanLoaiThuocDTO = new PhanLoaiThuocDTO();
        try {
            if (khuVucDeThuoc != null) {
                phanLoaiThuocDTO.setId(khuVucDeThuoc.getId());
                phanLoaiThuocDTO.setMa(khuVucDeThuoc.getMa());
                phanLoaiThuocDTO.setTen(khuVucDeThuoc.getTen());
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
            List<KhuVucDeThuoc> khuVucDeThuocList = khuVucDeThuocRepository.findAll();
            List<PhanLoaiThuocDTO> phanLoaiThuocDTOList = new ArrayList<>();
            for (KhuVucDeThuoc khuVucDeThuoc : khuVucDeThuocList) {
                PhanLoaiThuocDTO phanLoaiThuocDTO = new PhanLoaiThuocDTO();
                phanLoaiThuocDTO.setId(khuVucDeThuoc.getId());
                phanLoaiThuocDTO.setMa(khuVucDeThuoc.getMa());
                phanLoaiThuocDTO.setTen(khuVucDeThuoc.getTen());
                if (khuVucDeThuoc.getFlag()) {
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
            KhuVucDeThuoc khuVucDeThuoc = khuVucDeThuocRepository.findById(listIds[i]).orElse(null);
            khuVucDeThuoc.setFlag(false);

            khuVucDeThuocRepository.save(khuVucDeThuoc);
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
    public KhuVucDeThuoc findById(Long id) {
        return khuVucDeThuocRepository.findById(id).orElse(null);
    }
}
