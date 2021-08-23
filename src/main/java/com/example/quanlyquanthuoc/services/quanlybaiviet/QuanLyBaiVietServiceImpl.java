package com.example.quanlyquanthuoc.services.quanlybaiviet;

import com.example.quanlyquanthuoc.common.PaginationDto;
import com.example.quanlyquanthuoc.models.danhmuc.quyen.Quyen;
import com.example.quanlyquanthuoc.models.danhmuc.quyen.QuyenDto;
import com.example.quanlyquanthuoc.models.danhmuc.quyen.QuyenSelect;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiViet;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiVietDto;
import com.example.quanlyquanthuoc.repositorys.danhmuc.quyen.QuyenRepository;
import com.example.quanlyquanthuoc.repositorys.quanlybaiviet.QuanLyBaiVietRepository;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuanLyBaiVietServiceImpl implements QuanLyBaiVietService {

    @Autowired
    QuanLyBaiVietRepository quanLyBaiVietRepository;

    @Override
    public QuanLyBaiViet findById(Long baiVietId) {
        return quanLyBaiVietRepository.findById(baiVietId).orElse(null);
    }

    @Autowired
    private QuanLyBaiVietDao quanLyBaiVietDao;
    @Override
    public Map<String, Object> create(QuanLyBaiVietDto quanLyBaiVietDto) {
        Map<String, Object> result = new HashMap<>();
        QuanLyBaiVietDto resultCreate = new QuanLyBaiVietDto();
        try {
            QuanLyBaiViet quanLyBaiViet = new QuanLyBaiViet();
            quanLyBaiViet.setNoiDung(quanLyBaiVietDto.getNoiDung());
            quanLyBaiViet.setTieuDe(quanLyBaiVietDto.getTieuDe());
            quanLyBaiViet.setTag(quanLyBaiVietDto.getTag());
            quanLyBaiViet.setImgAvatar(quanLyBaiVietDto.getImgAvatar());
            quanLyBaiViet.setGioiThieu(quanLyBaiVietDto.getGioiThieu());
            quanLyBaiViet.setFile(quanLyBaiVietDto.getFile());
            quanLyBaiViet.setNgayTaoBanGhi(quanLyBaiVietDto.getNgayTaoBanGhi());
            quanLyBaiViet.setFlag(true);
            quanLyBaiVietRepository.save(quanLyBaiViet);

            resultCreate.setId(quanLyBaiViet.getId());
            resultCreate.setNoiDung(quanLyBaiViet.getNoiDung());
            resultCreate.setTieuDe(quanLyBaiViet.getTieuDe());
            resultCreate.setFile(quanLyBaiViet.getFile());
            resultCreate.setImgAvatar(quanLyBaiViet.getImgAvatar());
            resultCreate.setGioiThieu(quanLyBaiViet.getGioiThieu());
            resultCreate.setTag(quanLyBaiViet.getTag());
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
    public Map<String, Object> update(Long id, QuanLyBaiVietDto quanLyBaiVietDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            QuanLyBaiViet object = quanLyBaiVietRepository.findById(id).get();
            object.setId(quanLyBaiVietDto.getId() != null ? quanLyBaiVietDto.getId() : object.getId());
            object.setTag(quanLyBaiVietDto.getTag() != null ? quanLyBaiVietDto.getTag() : object.getNgayChinhSua());
            object.setTieuDe(quanLyBaiVietDto.getTieuDe() != null ? quanLyBaiVietDto.getTieuDe() : object.getTieuDe());
            object.setFile(quanLyBaiVietDto.getFile() != null ? quanLyBaiVietDto.getFile() : object.getFile());
            object.setNoiDung(quanLyBaiVietDto.getNoiDung() != null ? quanLyBaiVietDto.getNoiDung() : object.getNoiDung());
            object.setGioiThieu(quanLyBaiVietDto.getGioiThieu() != null ? quanLyBaiVietDto.getGioiThieu() : object.getGioiThieu());
            object.setImgAvatar(quanLyBaiVietDto.getImgAvatar() != null ? quanLyBaiVietDto.getImgAvatar() : object.getImgAvatar());

            object.setNgayChinhSua(quanLyBaiVietDto.getNgayChinhSua());

            quanLyBaiVietRepository.save(object);
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
        QuanLyBaiViet quanLyBaiViet = quanLyBaiVietRepository.findById(id).orElse(null);
        QuanLyBaiVietDto quanLyBaiVietDto = new QuanLyBaiVietDto();
        try {
            if (quanLyBaiViet != null) {
                quanLyBaiVietDto.setId(quanLyBaiViet.getId());
                quanLyBaiVietDto.setTieuDe(quanLyBaiViet.getTieuDe());
                quanLyBaiVietDto.setFile(quanLyBaiViet.getFile());
                quanLyBaiVietDto.setTag(quanLyBaiViet.getTag());
                quanLyBaiVietDto.setNoiDung(quanLyBaiViet.getNoiDung());
                quanLyBaiVietDto.setNgayTaoBanGhi(quanLyBaiViet.getNgayTaoBanGhi());
                quanLyBaiVietDto.setGioiThieu(quanLyBaiViet.getGioiThieu());
                quanLyBaiVietDto.setImgAvatar(quanLyBaiViet.getImgAvatar());

                result.put("result", quanLyBaiVietDto);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<QuanLyBaiViet> quyenList = quanLyBaiVietRepository.findAll();
            List<QuanLyBaiVietDto> quanLyBaiVietDtoList = new ArrayList<>();
            for (QuanLyBaiViet quanLyBaiViet : quyenList) {
                QuanLyBaiVietDto quanLyBaiVietDto = new QuanLyBaiVietDto();
                quanLyBaiVietDto.setId(quanLyBaiViet.getId());
                quanLyBaiVietDto.setNoiDung(quanLyBaiViet.getNoiDung());
                quanLyBaiVietDto.setFile(quanLyBaiViet.getFile());
                quanLyBaiVietDto.setTag(quanLyBaiViet.getTag());
                quanLyBaiVietDto.setTieuDe(quanLyBaiViet.getTieuDe());
                quanLyBaiVietDto.setImgAvatar(quanLyBaiViet.getImgAvatar());
                quanLyBaiVietDto.setGioiThieu(quanLyBaiViet.getGioiThieu());
                quanLyBaiVietDto.setNgayTaoBanGhi(quanLyBaiViet.getNgayTaoBanGhi());
                if (quanLyBaiViet.getFlag()) {
                    quanLyBaiVietDtoList.add(quanLyBaiVietDto);
                }
            }
            result.put("result", quanLyBaiVietDtoList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getTinTucTheoTag(String tag) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<QuanLyBaiViet> quanLyBaiVietList = quanLyBaiVietRepository.baiVietTheoTag(tag);
            List<QuanLyBaiVietDto> quanLyBaiVietDtoList = new ArrayList<>();
            for (QuanLyBaiViet quanLyBaiViet : quanLyBaiVietList) {
                QuanLyBaiVietDto quanLyBaiVietDto = new QuanLyBaiVietDto();
                quanLyBaiVietDto.setId(quanLyBaiViet.getId());
                quanLyBaiVietDto.setNoiDung(quanLyBaiViet.getNoiDung());
                quanLyBaiVietDto.setFile(quanLyBaiViet.getFile());
                quanLyBaiVietDto.setTag(quanLyBaiViet.getTag());
                quanLyBaiVietDto.setGioiThieu(quanLyBaiViet.getGioiThieu());
                quanLyBaiVietDto.setImgAvatar(quanLyBaiViet.getImgAvatar());
                quanLyBaiVietDto.setTieuDe(quanLyBaiViet.getTieuDe());
                quanLyBaiVietDto.setNgayTaoBanGhi(quanLyBaiViet.getNgayTaoBanGhi());
                if (quanLyBaiViet.getFlag()) {
                    quanLyBaiVietDtoList.add(quanLyBaiVietDto);
                }
            }
            result.put("result", quanLyBaiVietDtoList);
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
            QuanLyBaiViet quanLyBaiViet = quanLyBaiVietRepository.findById(listIds[i]).orElse(null);
            quanLyBaiViet.setFlag(false);

            quanLyBaiVietRepository.save(quanLyBaiViet);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<QuanLyBaiViet> listIdQuyen = new ArrayList<>();
            for (Long id : listIds) {
                Optional<QuanLyBaiViet> quanlybaivietOptional = quanLyBaiVietRepository.findById(id);
                if (quanlybaivietOptional.isPresent()) {
                    listIdQuyen.add(quanlybaivietOptional.get());
                }
            }
            result.put("msg", "Xóa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Xóa thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData) {
        Map<String,Object> mapResult = new HashMap<>();
        try {
            if(sortData == null){
                sortData ="id DESC";
            }

            Pageable pageable = null;

            if (pageSize != null && page != null){
            pageable = PageRequest.of(page - 1, pageSize);
            mapResult.put("pagination", new PaginationDto(page,pageSize,quanLyBaiVietDao.countBaiViet(searchString)));
            }
            List<QuanLyBaiViet> bvList = quanLyBaiVietDao.getListBaiViet(searchString,pageable,sortData);
            List<QuanLyBaiVietDto> baiVietDtos = new ArrayList<QuanLyBaiVietDto>();
            for(QuanLyBaiViet quanLyBaiViet : bvList){
                QuanLyBaiVietDto quanLyBaiVietDto = new QuanLyBaiVietDto();
                quanLyBaiVietDto.setId(quanLyBaiViet.getId());
                quanLyBaiVietDto.setNoiDung(quanLyBaiViet.getNoiDung());
                quanLyBaiVietDto.setFile(quanLyBaiViet.getFile());
                quanLyBaiVietDto.setTag(quanLyBaiViet.getTag());
                quanLyBaiVietDto.setTieuDe(quanLyBaiViet.getTieuDe());
                quanLyBaiVietDto.setImgAvatar(quanLyBaiViet.getImgAvatar());
                quanLyBaiVietDto.setGioiThieu(quanLyBaiViet.getGioiThieu());
                quanLyBaiVietDto.setNgayTaoBanGhi(quanLyBaiViet.getNgayTaoBanGhi());
                baiVietDtos.add(quanLyBaiVietDto);
            }
            mapResult.put("result",baiVietDtos);
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
