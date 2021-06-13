package com.example.quanlyquanthuoc.services.quanlykhothuoc;


import com.example.quanlyquanthuoc.models.quanlyfiles.ResponseFile;
import com.example.quanlyquanthuoc.models.quanlyfiles.FileDB;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuocDTO;
import com.example.quanlyquanthuoc.models.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.repositorys.quanlyfiles.FileDBRepository;
import com.example.quanlyquanthuoc.repositorys.quanlykhothuoc.QuanLyKhoThuocRepository;
import com.example.quanlyquanthuoc.services.quanlynhacungcap.QuanLyNhaCungCapService;
import com.example.quanlyquanthuoc.services.quanlytaikhoan.QuanLyTaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;

@Service
public class QuanLyKhoThuocServiceImpl implements QuanLyKhoThuocService {

    @Autowired
    QuanLyKhoThuocRepository quanLyKhoThuocRepository;
    @Autowired
    QuanLyNhaCungCapService quanLyNhaCungCapService;
    @Autowired
    QuanLyTaiKhoanService quanLyTaiKhoanService;

    @Autowired
    FileDBRepository fileDBRepository;

    @Override
    public Map<String, Object> create(KhoThuocDTO khoThuocDTO) {
        Map<String,Object> result = new HashMap<>();
        KhoThuocDTO resultCreate = new KhoThuocDTO();
        try{
            KhoThuoc khoThuoc = new KhoThuoc();
            khoThuoc.setTenThuoc(khoThuocDTO.getTenThuoc());
            khoThuoc.setMa(khoThuocDTO.getMa());
            khoThuoc.setDonViTinh(khoThuocDTO.getDonViTinh());
            khoThuoc.setTongTienTruocThue(khoThuocDTO.getTongTienTruocThue());
            khoThuoc.setPhanTramThue(khoThuocDTO.getPhanTramThue());
            khoThuoc.setChietKhau(khoThuocDTO.getChietKhau());
            khoThuoc.setGiaTien(khoThuocDTO.getGiaTien());
            khoThuoc.setThanhToan(khoThuocDTO.getThanhToan());
            khoThuoc.setSoLuongNhap(khoThuocDTO.getSoLuongNhap());
            khoThuoc.setSoLuongDaBan(khoThuocDTO.getSoLuongDaBan());
            khoThuoc.setSoLuongMua(khoThuocDTO.getSoLuongMua());
            khoThuoc.setKhuVuc(khoThuocDTO.getKhuVuc());
            khoThuoc.setPhanLoaiThuoc(khoThuocDTO.getPhanLoaiThuoc());
            khoThuoc.setNgayChinhSua(khoThuocDTO.getNgayChinhSua());
            khoThuoc.setNgayTaoBanGhi(khoThuocDTO.getNgayTaoBanGhi());
            khoThuoc.setFlag(khoThuocDTO.getFlag());
            khoThuoc.setNguoiTaoId(khoThuocDTO.getNguoiTaoId());
            khoThuoc.setHanSuDungThuoc(khoThuocDTO.getHanSuDungThuoc());
            khoThuoc.setFileDinhKem(khoThuocDTO.getFileDinhKem());
            khoThuoc.setQuanLyNhaCungCap( quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()));

            quanLyKhoThuocRepository.save(khoThuoc);

            QuanLyNhaCungCap quanLyNhaCungCapItem  = new QuanLyNhaCungCap();
            quanLyNhaCungCapItem.setId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getId());
            quanLyNhaCungCapItem.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getTenNhaCungCap());
            quanLyNhaCungCapItem.setDiaChiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getDiaChiNhaCungCap());
            quanLyNhaCungCapItem.setMstNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMstNhaCungCap());
            quanLyNhaCungCapItem.setSoDienThoaiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getSoDienThoaiNhaCungCap());
            quanLyNhaCungCapItem.setMa(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMa());
            quanLyNhaCungCapItem.setZalo(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getZalo());
            quanLyNhaCungCapItem.setEmail(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getEmail());
            quanLyNhaCungCapItem.setNguoiTaoId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNguoiTaoId());
            quanLyNhaCungCapItem.setNgayTaoBanGhi(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayTaoBanGhi());
            quanLyNhaCungCapItem.setNgayChinhSua(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayChinhSua());

            QuanLyTaiKhoan quanLyTaiKhoanItem = new QuanLyTaiKhoan();

            quanLyTaiKhoanItem.setId(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getId());
            quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
            quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
            quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhau());
            quanLyTaiKhoanItem.setXacNhanMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getXacNhanMatKhau());
            quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhauGoc());
            quanLyTaiKhoanItem.setNgaySinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgaySinh());
            quanLyTaiKhoanItem.setGioiTinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getGioiTinh());
            quanLyTaiKhoanItem.setFacebook(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getFacebook());
            quanLyTaiKhoanItem.setSoDienThoai(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getSoDienThoai());
            quanLyTaiKhoanItem.setCmnd(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getCmnd());
            quanLyTaiKhoanItem.setImg(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getImg());
            quanLyTaiKhoanItem.setNgayTaoBanGhi(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayTaoBanGhi());
            quanLyTaiKhoanItem.setNgayChinhSua(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayChinhSua());


            // file đính kèm
            List arrListFileDinhKem = new ArrayList();
            if(khoThuocDTO.getFileDinhKem() != null){
                String listIdFileDinhKem = khoThuocDTO.getFileDinhKem();
                String[] listId = listIdFileDinhKem.split("/");
                for (int i = 0; i <listId.length ; i++) {
                    Optional<FileDB> fileItem =  fileDBRepository.findById(listId[i]);
                    ResponseFile responseFile = new ResponseFile();
                    responseFile.setId(fileItem.get().getId());
                    responseFile.setName(fileItem.get().getName());
                    responseFile.setSize(fileItem.get().getData().length);
                    responseFile.setType(fileItem.get().getType());
                    responseFile.setUrl( ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/files/")
                            .path(fileItem.get().getId())
                            .toUriString());
                    arrListFileDinhKem.add(responseFile);
                }
            }
            resultCreate.setFileDBArrayList(arrListFileDinhKem);

            resultCreate.setId(khoThuoc.getId());
            resultCreate.setTenThuoc(khoThuoc.getTenThuoc());
            resultCreate.setMa(khoThuoc.getMa());
            resultCreate.setDonViTinh(khoThuoc.getDonViTinh());
            resultCreate.setTongTienTruocThue(khoThuoc.getTongTienTruocThue());
            resultCreate.setPhanTramThue(khoThuoc.getPhanTramThue());
            resultCreate.setChietKhau(khoThuoc.getChietKhau());
            resultCreate.setGiaTien(khoThuoc.getGiaTien());
            resultCreate.setThanhToan(khoThuoc.getThanhToan());
            resultCreate.setSoLuongNhap(khoThuoc.getSoLuongNhap());
            resultCreate.setSoLuongDaBan(khoThuoc.getSoLuongDaBan());
            resultCreate.setSoLuongMua(khoThuoc.getSoLuongMua());
            resultCreate.setKhuVuc(khoThuoc.getKhuVuc());
            resultCreate.setPhanLoaiThuoc(khoThuoc.getPhanLoaiThuoc());
            resultCreate.setNgayChinhSua(khoThuoc.getNgayChinhSua());
            resultCreate.setNgayTaoBanGhi(khoThuoc.getNgayTaoBanGhi());
            resultCreate.setFlag(khoThuoc.getFlag());
            resultCreate.setNguoiTaoId(khoThuoc.getNguoiTaoId());
            resultCreate.setHanSuDungThuoc(khoThuoc.getHanSuDungThuoc());
            resultCreate.setNhaCungCapId( quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getId());
            resultCreate.setQuanLyNhaCungCap(quanLyNhaCungCapItem);
            resultCreate.setThongTinNguoiTao(quanLyTaiKhoanItem);

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
    public Map<String, Object> update(Long id, KhoThuocDTO khoThuocDTO) {
        Map<String,Object> result = new HashMap<>();
        KhoThuocDTO resultUpdate = new KhoThuocDTO();
        try {
            KhoThuoc object = quanLyKhoThuocRepository.findById(id).get();
            if(khoThuocDTO.getFlag() != null && khoThuocDTO.getFlag() == false){
                object.setFlag(khoThuocDTO.getFlag());
                quanLyKhoThuocRepository.save(object);
                result.put("msg","Xóa thành công");
                result.put("status",true);
            }else {
                object.setId(id);
                object.setTenThuoc(khoThuocDTO.getTenThuoc());
                object.setMa(khoThuocDTO.getMa());
                object.setDonViTinh(khoThuocDTO.getDonViTinh());
                object.setTongTienTruocThue(khoThuocDTO.getTongTienTruocThue());
                object.setPhanTramThue(khoThuocDTO.getPhanTramThue());
                object.setChietKhau(khoThuocDTO.getChietKhau());
                object.setGiaTien(khoThuocDTO.getGiaTien());
                object.setThanhToan(khoThuocDTO.getThanhToan());
                object.setSoLuongNhap(khoThuocDTO.getSoLuongNhap());
                object.setSoLuongDaBan(khoThuocDTO.getSoLuongDaBan());
                object.setSoLuongMua(khoThuocDTO.getSoLuongMua());
                object.setKhuVuc(khoThuocDTO.getKhuVuc());
                object.setHanSuDungThuoc(khoThuocDTO.getHanSuDungThuoc());
                object.setPhanLoaiThuoc(khoThuocDTO.getPhanLoaiThuoc());
                object.setNgayChinhSua(khoThuocDTO.getNgayChinhSua());
                object.setQuanLyNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()));
                object.setFileDinhKem(khoThuocDTO.getFileDinhKem());

                QuanLyNhaCungCap quanLyNhaCungCapItem  = new QuanLyNhaCungCap();

                quanLyNhaCungCapItem.setId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getId());
                quanLyNhaCungCapItem.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getTenNhaCungCap());
                quanLyNhaCungCapItem.setDiaChiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getDiaChiNhaCungCap());
                quanLyNhaCungCapItem.setMstNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMstNhaCungCap());
                quanLyNhaCungCapItem.setSoDienThoaiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapItem.setMa(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMa());
                quanLyNhaCungCapItem.setZalo(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getZalo());
                quanLyNhaCungCapItem.setEmail(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getEmail());
                quanLyNhaCungCapItem.setNguoiTaoId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNguoiTaoId());
                quanLyNhaCungCapItem.setNgayTaoBanGhi(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayTaoBanGhi());
                quanLyNhaCungCapItem.setNgayChinhSua(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayChinhSua());



                QuanLyTaiKhoan quanLyTaiKhoanItem = new QuanLyTaiKhoan();

                quanLyTaiKhoanItem.setId(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getId());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhau());
                quanLyTaiKhoanItem.setXacNhanMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getXacNhanMatKhau());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhauGoc());
                quanLyTaiKhoanItem.setNgaySinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgaySinh());
                quanLyTaiKhoanItem.setGioiTinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getGioiTinh());
                quanLyTaiKhoanItem.setFacebook(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getFacebook());
                quanLyTaiKhoanItem.setSoDienThoai(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getSoDienThoai());
                quanLyTaiKhoanItem.setCmnd(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getCmnd());
                quanLyTaiKhoanItem.setImg(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getImg());
                quanLyTaiKhoanItem.setNgayTaoBanGhi(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayTaoBanGhi());
                quanLyTaiKhoanItem.setNgayChinhSua(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayChinhSua());


                // file đính kèm
                List arrListFileDinhKem = new ArrayList();
                if(khoThuocDTO.getFileDinhKem() != null){
                    String listIdFileDinhKem = khoThuocDTO.getFileDinhKem();
                    String[] listId = listIdFileDinhKem.split("/");
                    for (int i = 0; i <listId.length ; i++) {
                        Optional<FileDB> fileItem =  fileDBRepository.findById(listId[i]);
                        ResponseFile responseFile = new ResponseFile();
                        responseFile.setId(fileItem.get().getId());
                        responseFile.setName(fileItem.get().getName());
                        responseFile.setSize(fileItem.get().getData().length);
                        responseFile.setType(fileItem.get().getType());
                        responseFile.setUrl( ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/files/")
                                .path(fileItem.get().getId())
                                .toUriString());
                        arrListFileDinhKem.add(responseFile);
                    }
                }


                resultUpdate.setFileDBArrayList(arrListFileDinhKem);

                resultUpdate.setId(id);
                resultUpdate.setTenThuoc(khoThuocDTO.getTenThuoc());
                resultUpdate.setMa(khoThuocDTO.getMa());
                resultUpdate.setDonViTinh(khoThuocDTO.getDonViTinh());
                resultUpdate.setTongTienTruocThue(khoThuocDTO.getTongTienTruocThue());
                resultUpdate.setPhanTramThue(khoThuocDTO.getPhanTramThue());
                resultUpdate.setChietKhau(khoThuocDTO.getChietKhau());
                resultUpdate.setGiaTien(khoThuocDTO.getGiaTien());
                resultUpdate.setThanhToan(khoThuocDTO.getThanhToan());
                resultUpdate.setSoLuongNhap(khoThuocDTO.getSoLuongNhap());
                resultUpdate.setSoLuongDaBan(khoThuocDTO.getSoLuongDaBan());
                resultUpdate.setSoLuongMua(khoThuocDTO.getSoLuongMua());
                resultUpdate.setKhuVuc(khoThuocDTO.getKhuVuc());
                resultUpdate.setNhaCungCapId(khoThuocDTO.getNhaCungCapId());
                resultUpdate.setHanSuDungThuoc(khoThuocDTO.getHanSuDungThuoc());
                resultUpdate.setPhanLoaiThuoc(khoThuocDTO.getPhanLoaiThuoc());
                resultUpdate.setNgayChinhSua(khoThuocDTO.getNgayChinhSua());
                resultUpdate.setQuanLyNhaCungCap(quanLyNhaCungCapItem);
                resultUpdate.setThongTinNguoiTao(quanLyTaiKhoanItem);
                resultUpdate.setTenNhaCungCap(quanLyNhaCungCapService.findById(object.getQuanLyNhaCungCap().getId()).getTenNhaCungCap());


                quanLyKhoThuocRepository.save(object);


                result.put("result",resultUpdate);
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
        KhoThuoc khoThuoc = quanLyKhoThuocRepository.findById(id).orElse(null);
        KhoThuocDTO khoThuocDTO = new KhoThuocDTO();
        try {
            if(khoThuoc != null){
                khoThuocDTO.setId(khoThuoc.getId());
                khoThuocDTO.setTenThuoc(khoThuoc.getTenThuoc());
                khoThuocDTO.setMa(khoThuoc.getMa());
                khoThuocDTO.setDonViTinh(khoThuoc.getDonViTinh());
                khoThuocDTO.setTongTienTruocThue(khoThuoc.getTongTienTruocThue());
                khoThuocDTO.setPhanTramThue(khoThuoc.getPhanTramThue());
                khoThuocDTO.setChietKhau(khoThuoc.getChietKhau());
                khoThuocDTO.setGiaTien(khoThuoc.getGiaTien());
                khoThuocDTO.setThanhToan(khoThuoc.getThanhToan());
                khoThuocDTO.setSoLuongNhap(khoThuoc.getSoLuongNhap());
                khoThuocDTO.setSoLuongDaBan(khoThuoc.getSoLuongDaBan());
                khoThuocDTO.setSoLuongMua(khoThuoc.getSoLuongMua());
                khoThuocDTO.setKhuVuc(khoThuoc.getKhuVuc());
                khoThuocDTO.setPhanLoaiThuoc(khoThuoc.getPhanLoaiThuoc());
                khoThuocDTO.setNgayChinhSua(khoThuoc.getNgayChinhSua());
                khoThuocDTO.setNgayTaoBanGhi(khoThuoc.getNgayTaoBanGhi());
                khoThuocDTO.setFlag(khoThuoc.getFlag());
                khoThuocDTO.setHanSuDungThuoc(khoThuoc.getHanSuDungThuoc());
                khoThuocDTO.setNguoiTaoId(khoThuoc.getNguoiTaoId());
                khoThuocDTO.setNhaCungCapId(khoThuoc.getQuanLyNhaCungCap().getId());
                khoThuocDTO.setFileDinhKem(khoThuoc.getFileDinhKem());
                khoThuocDTO.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getTenNhaCungCap());

                QuanLyNhaCungCap quanLyNhaCungCapItem  = new QuanLyNhaCungCap();
                quanLyNhaCungCapItem.setId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getId());
                quanLyNhaCungCapItem.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getTenNhaCungCap());
                quanLyNhaCungCapItem.setDiaChiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getDiaChiNhaCungCap());
                quanLyNhaCungCapItem.setMstNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMstNhaCungCap());
                quanLyNhaCungCapItem.setSoDienThoaiNhaCungCap(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapItem.setMa(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getMa());
                quanLyNhaCungCapItem.setZalo(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getZalo());
                quanLyNhaCungCapItem.setEmail(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getEmail());
                quanLyNhaCungCapItem.setNguoiTaoId(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNguoiTaoId());
                quanLyNhaCungCapItem.setNgayTaoBanGhi(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayTaoBanGhi());
                quanLyNhaCungCapItem.setNgayChinhSua(quanLyNhaCungCapService.findById(khoThuocDTO.getNhaCungCapId()).getNgayChinhSua());

                QuanLyTaiKhoan quanLyTaiKhoanItem = new QuanLyTaiKhoan();

                quanLyTaiKhoanItem.setId(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getId());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setTenNguoiDung(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getTenNguoiDung());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhau());
                quanLyTaiKhoanItem.setXacNhanMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getXacNhanMatKhau());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getMatKhauGoc());
                quanLyTaiKhoanItem.setNgaySinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgaySinh());
                quanLyTaiKhoanItem.setGioiTinh(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getGioiTinh());
                quanLyTaiKhoanItem.setFacebook(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getFacebook());
                quanLyTaiKhoanItem.setSoDienThoai(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getSoDienThoai());
                quanLyTaiKhoanItem.setCmnd(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getCmnd());
                quanLyTaiKhoanItem.setImg(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getImg());
                quanLyTaiKhoanItem.setNgayTaoBanGhi(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayTaoBanGhi());
                quanLyTaiKhoanItem.setNgayChinhSua(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayChinhSua());

                // file đính kèm
                List arrListFileDinhKem = new ArrayList();
                if(khoThuoc.getFileDinhKem() != null){
                    String listIdFileDinhKem = khoThuoc.getFileDinhKem();
                    String[] listId = listIdFileDinhKem.split("/");
                    for (int i = 0; i <listId.length ; i++) {
                        Optional<FileDB> fileItem =  fileDBRepository.findById(listId[i]);
                        if(fileItem.isPresent()){
                            ResponseFile responseFile = new ResponseFile();
                            responseFile.setId(fileItem.get().getId());
                            responseFile.setName(fileItem.get().getName());
                            responseFile.setSize(fileItem.get().getData().length);
                            responseFile.setType(fileItem.get().getType());
                            responseFile.setUrl( ServletUriComponentsBuilder
                                    .fromCurrentContextPath()
                                    .path("/files/")
                                    .path(fileItem.get().getId())
                                    .toUriString());
                            arrListFileDinhKem.add(responseFile);
                        }
                    }
                }

                khoThuocDTO.setFileDBArrayList(arrListFileDinhKem);
                khoThuocDTO.setQuanLyNhaCungCap(quanLyNhaCungCapItem);
                khoThuocDTO.setThongTinNguoiTao(quanLyTaiKhoanItem);

                result.put("result",khoThuocDTO);
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
            List<KhoThuoc> khoThuocList = quanLyKhoThuocRepository.findAll();
            List<KhoThuocDTO> khoThuocDTOS = new ArrayList<>();

            for(KhoThuoc khoThuoc : khoThuocList){
                KhoThuocDTO khoThuocDTO = new KhoThuocDTO();
                khoThuocDTO.setId(khoThuoc.getId());
                khoThuocDTO.setTenThuoc(khoThuoc.getTenThuoc());
                khoThuocDTO.setMa(khoThuoc.getMa());
                khoThuocDTO.setDonViTinh(khoThuoc.getDonViTinh());
                khoThuocDTO.setTongTienTruocThue(khoThuoc.getTongTienTruocThue());
                khoThuocDTO.setPhanTramThue(khoThuoc.getPhanTramThue());
                khoThuocDTO.setChietKhau(khoThuoc.getChietKhau());
                khoThuocDTO.setGiaTien(khoThuoc.getGiaTien());
                khoThuocDTO.setNhaCungCapId(khoThuoc.getQuanLyNhaCungCap().getId());
                khoThuocDTO.setThanhToan(khoThuoc.getThanhToan());
                khoThuocDTO.setSoLuongNhap(khoThuoc.getSoLuongNhap());
                khoThuocDTO.setSoLuongDaBan(khoThuoc.getSoLuongDaBan());
                khoThuocDTO.setSoLuongMua(khoThuoc.getSoLuongMua());
                khoThuocDTO.setKhuVuc(khoThuoc.getKhuVuc());
                khoThuocDTO.setPhanLoaiThuoc(khoThuoc.getPhanLoaiThuoc());
                khoThuocDTO.setNgayChinhSua(khoThuoc.getNgayChinhSua());
                khoThuocDTO.setNgayTaoBanGhi(khoThuoc.getNgayTaoBanGhi());
                khoThuocDTO.setHanSuDungThuoc(khoThuoc.getHanSuDungThuoc());
                khoThuocDTO.setFlag(khoThuoc.getFlag());
                khoThuocDTO.setNguoiTaoId(khoThuoc.getNguoiTaoId());
                khoThuocDTO.setFileDinhKem(khoThuoc.getFileDinhKem());

                khoThuocDTO.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getTenNhaCungCap());
                QuanLyNhaCungCap quanLyNhaCungCapItem  = new QuanLyNhaCungCap();
                quanLyNhaCungCapItem.setId(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getId());
                quanLyNhaCungCapItem.setTenNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getTenNhaCungCap());
                quanLyNhaCungCapItem.setDiaChiNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getDiaChiNhaCungCap());
                quanLyNhaCungCapItem.setMstNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getMstNhaCungCap());
                quanLyNhaCungCapItem.setSoDienThoaiNhaCungCap(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getSoDienThoaiNhaCungCap());
                quanLyNhaCungCapItem.setMa(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getMa());
                quanLyNhaCungCapItem.setZalo(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getZalo());
                quanLyNhaCungCapItem.setEmail(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getEmail());
                quanLyNhaCungCapItem.setNguoiTaoId(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getNguoiTaoId());
                quanLyNhaCungCapItem.setNgayTaoBanGhi(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getNgayTaoBanGhi());
                quanLyNhaCungCapItem.setNgayChinhSua(quanLyNhaCungCapService.findById(khoThuoc.getQuanLyNhaCungCap().getId()).getNgayChinhSua());

                QuanLyTaiKhoan quanLyTaiKhoanItem = new QuanLyTaiKhoan();

                quanLyTaiKhoanItem.setId(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getId());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setTenDangNhap(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getTenDangNhap());
                quanLyTaiKhoanItem.setTenNguoiDung(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getTenNguoiDung());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getMatKhau());
                quanLyTaiKhoanItem.setXacNhanMatKhau(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getXacNhanMatKhau());
                quanLyTaiKhoanItem.setMatKhau(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getMatKhauGoc());
                quanLyTaiKhoanItem.setNgaySinh(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getNgaySinh());
                quanLyTaiKhoanItem.setGioiTinh(quanLyTaiKhoanService.findById(khoThuoc.getNguoiTaoId()).getGioiTinh());
                quanLyTaiKhoanItem.setFacebook(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getFacebook());
                quanLyTaiKhoanItem.setSoDienThoai(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getSoDienThoai());
                quanLyTaiKhoanItem.setCmnd(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getCmnd());
                quanLyTaiKhoanItem.setImg(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getImg());
                quanLyTaiKhoanItem.setNgayTaoBanGhi(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayTaoBanGhi());
                quanLyTaiKhoanItem.setNgayChinhSua(quanLyTaiKhoanService.findById(khoThuocDTO.getNguoiTaoId()).getNgayChinhSua());

                // file đính kèm
                List arrListFileDinhKem = new ArrayList();
                if(khoThuoc.getFileDinhKem() != null){
                    String listIdFileDinhKem = khoThuoc.getFileDinhKem();
                    String[] listId = listIdFileDinhKem.split("/");
                    for (int i = 0; i <listId.length ; i++) {
                        Optional<FileDB> fileItem =  fileDBRepository.findById(listId[i]);
                        if(fileItem.isPresent()){
                            ResponseFile responseFile = new ResponseFile();
                            responseFile.setId(fileItem.get().getId());
                            responseFile.setName(fileItem.get().getName());
                            responseFile.setSize(fileItem.get().getData().length);
                            responseFile.setType(fileItem.get().getType());
                            responseFile.setUrl( ServletUriComponentsBuilder
                                    .fromCurrentContextPath()
                                    .path("/files/")
                                    .path(fileItem.get().getId())
                                    .toUriString());
                            arrListFileDinhKem.add(responseFile);
                        }
                    }
                }

                khoThuocDTO.setFileDBArrayList(arrListFileDinhKem);
                khoThuocDTO.setQuanLyNhaCungCap(quanLyNhaCungCapItem);
                khoThuocDTO.setThongTinNguoiTao(quanLyTaiKhoanItem);

                khoThuocDTOS.add(khoThuocDTO);
            }
            result.put("result", khoThuocDTOS);
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
    public KhoThuoc findById(Long id) {
        return quanLyKhoThuocRepository.findById(id).orElse(null);
    }
}
