package com.chaudang.managephamarcity.services.quanlybanhangthanhcong;

import com.chaudang.managephamarcity.models.quanlybanhang.QuanLyBanHang;
import com.chaudang.managephamarcity.models.quanlybanhang.SanPhamDTO;
import com.chaudang.managephamarcity.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.chaudang.managephamarcity.models.quanlybanhangthanhcong.SanPhamThanhCong;
import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuoc;
import com.chaudang.managephamarcity.repositorys.quanlybanhangthanhcong.SanPhamThanhCongRepository;
import com.chaudang.managephamarcity.services.quanlykhothuoc.QuanLyKhoThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SanPhamThanhCongServiceImpl implements SanPhamThanhCongService {

    @Autowired
    SanPhamThanhCongRepository sanPhamThanhCongRepository;

    @Autowired
    QuanLyKhoThuocService quanLyKhoThuocService;

    @Autowired
    QuanLyBanHangThanhCongService quanLyBanHangThanhCongService;

    @Override
    public Map<String, Object> create(SanPhamDTO sanPhamDTO) {
        System.out.println(sanPhamDTO);
        Map<String,Object> result = new HashMap<>();
        SanPhamDTO resultCreate = new SanPhamDTO();
        try {
            SanPhamThanhCong sanPhamThanhCong = new SanPhamThanhCong();
            sanPhamThanhCong.setKhoThuoc(quanLyKhoThuocService.findById( sanPhamDTO.getKhoThuocId()));
            sanPhamThanhCong.setQuanLyBanHangThanhCong(quanLyBanHangThanhCongService.findById(sanPhamDTO.getQuanLyBanHangId()));
            sanPhamThanhCong.setFlag(sanPhamDTO.getFlag());
            sanPhamThanhCong.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            sanPhamThanhCong.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            sanPhamThanhCong.setSoLuongMua(sanPhamDTO.getSoLuongMua());

            sanPhamThanhCongRepository.save(sanPhamThanhCong);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, SanPhamDTO sanPhamDTO) {
        Map<String,Object> result = new HashMap<>();
        SanPhamDTO resultCreate = new SanPhamDTO();
        try {
            SanPhamThanhCong object = sanPhamThanhCongRepository.findById(id).get();
            object.setKhoThuoc(quanLyKhoThuocService.findById( sanPhamDTO.getKhoThuocId()));
            object.setQuanLyBanHangThanhCong(quanLyBanHangThanhCongService.findById(sanPhamDTO.getQuanLyBanHangId()));
            object.setFlag(sanPhamDTO.getFlag());
            object.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            object.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            object.setSoLuongMua(sanPhamDTO.getSoLuongMua());
            sanPhamThanhCongRepository.save(object);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String,Object> result = new HashMap<>();
        try {
            List<SanPhamThanhCong> sanPhamThanhCongList = sanPhamThanhCongRepository.findAll();
            List<SanPhamDTO> sanPhamDTOS = new ArrayList<>();
            for (SanPhamThanhCong sanPhamThanhCong: sanPhamThanhCongList) {

                SanPhamDTO sanPhamDTO = new SanPhamDTO();
                sanPhamDTO.setId(sanPhamThanhCong.getId());
                sanPhamDTO.setSoLuongMua(sanPhamThanhCong.getSoLuongMua());
                sanPhamDTO.setNgayChinhSua(sanPhamThanhCong.getNgayChinhSua());
                sanPhamDTO.setNgayTaoBanGhi(sanPhamThanhCong.getNgayTaoBanGhi());
                sanPhamDTO.setKhoThuocId(sanPhamThanhCong.getKhoThuoc().getId());
                sanPhamDTO.setQuanLyBanHangId(sanPhamThanhCong.getQuanLyBanHangThanhCong().getId());
                sanPhamDTO.setFlag(sanPhamThanhCong.getFlag());
                sanPhamDTO.setQuanLyBanHangId(sanPhamThanhCong.getQuanLyBanHangThanhCong().getId());


                KhoThuoc khoThuocItems = new KhoThuoc();

                KhoThuoc khoThuocById = quanLyKhoThuocService.findById(sanPhamThanhCong.getKhoThuoc().getId());
                khoThuocItems.setId(khoThuocById.getId());
                khoThuocItems.setPhanLoaiThuoc(khoThuocById.getPhanLoaiThuoc());
                khoThuocItems.setHanSuDungThuoc(khoThuocById.getHanSuDungThuoc());
                khoThuocItems.setTenThuoc(khoThuocById.getTenThuoc());
                khoThuocItems.setMa(khoThuocById.getMa());
                khoThuocItems.setDonViTinh(khoThuocById.getDonViTinh());
                khoThuocItems.setTongTienTruocThue(khoThuocById.getTongTienTruocThue());
                khoThuocItems.setPhanTramThue(khoThuocById.getPhanTramThue());
                khoThuocItems.setChietKhau(khoThuocById.getChietKhau());
                khoThuocItems.setGiaTien(khoThuocById.getGiaTien());
                khoThuocItems.setThanhToan(khoThuocById.getThanhToan());
                khoThuocItems.setSoLuongNhap(khoThuocById.getSoLuongNhap());
                khoThuocItems.setSoLuongDaBan(sanPhamThanhCong.getSoLuongMua());
                khoThuocItems.setSoLuongMua(sanPhamThanhCong.getSoLuongMua());
                khoThuocItems.setKhuVuc(khoThuocById.getKhuVuc());
                khoThuocItems.setNguoiTaoId(khoThuocById.getNguoiTaoId());
                khoThuocItems.setPhanTramThue(khoThuocById.getPhanTramThue());

                QuanLyBanHang quanLyBanHangItem = new QuanLyBanHang();
                QuanLyBanHangThanhCong quanLyBanHangThanhCongById = quanLyBanHangThanhCongService.findById(sanPhamThanhCong.getQuanLyBanHangThanhCong().getId());
                quanLyBanHangItem.setTenKhachHang(quanLyBanHangThanhCongById.getTenKhachHang());


                sanPhamDTO.setTenKhachHang(quanLyBanHangThanhCongById.getTenKhachHang());
                sanPhamDTO.setSoDienThoaiKhachHang(quanLyBanHangThanhCongById.getSoDienThoaiKhachHang());
                sanPhamDTO.setIdKhachHang(quanLyBanHangThanhCongById.getIdKhachHang());

                sanPhamDTO.setSanPham(khoThuocItems);
                sanPhamDTOS.add(sanPhamDTO);
            }
            result.put("result", sanPhamDTOS);
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
    public void deleteById(Long id) {
        sanPhamThanhCongRepository.deleteById(id);
    }

    @Override
    public QuanLyBanHang findById(Long id) {
        return null;
    }

    @Override
    public List<SanPhamDTO> getAllSanPhamById(Long id) {
        return sanPhamThanhCongRepository.findBySanPhamThanhCong(id).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamDTO> deleteById(List idSanPhamDangCo) {

        return null;
    }

    private SanPhamDTO toDto(SanPhamThanhCong sanPhamThanhCong){
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setId(sanPhamThanhCong.getId());
        sanPhamDTO.setSoLuongMua(sanPhamThanhCong.getSoLuongMua());
        sanPhamDTO.setNgayChinhSua(sanPhamThanhCong.getNgayChinhSua());
        sanPhamDTO.setNgayTaoBanGhi(sanPhamThanhCong.getNgayTaoBanGhi());
        sanPhamDTO.setKhoThuocId(sanPhamThanhCong.getKhoThuoc().getId());
        sanPhamDTO.setQuanLyBanHangId(sanPhamThanhCong.getQuanLyBanHangThanhCong().getId());
        sanPhamDTO.setFlag(sanPhamThanhCong.getFlag());
        sanPhamDTO.setQuanLyBanHangId(sanPhamThanhCong.getQuanLyBanHangThanhCong().getId());

        return sanPhamDTO;
    }
}
