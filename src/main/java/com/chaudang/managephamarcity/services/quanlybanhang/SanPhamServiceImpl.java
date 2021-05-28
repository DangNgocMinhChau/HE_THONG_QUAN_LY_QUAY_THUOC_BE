package com.chaudang.managephamarcity.services.quanlybanhang;

import com.chaudang.managephamarcity.models.quanlybanhang.QuanLyBanHang;
import com.chaudang.managephamarcity.models.quanlybanhang.SanPham;
import com.chaudang.managephamarcity.models.quanlybanhang.SanPhamDTO;
import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuoc;
import com.chaudang.managephamarcity.repositorys.quanlybanhang.SanPhamRepository;
import com.chaudang.managephamarcity.services.quanlykhothuoc.QuanLyKhoThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    QuanLyKhoThuocService quanLyKhoThuocService;

    @Autowired
    QuanLyBanHangService quanLyBanHangService;

    @Override
    public Map<String, Object> create(SanPhamDTO sanPhamDTO) {
        System.out.println(sanPhamDTO);
        Map<String,Object> result = new HashMap<>();
        SanPhamDTO resultCreate = new SanPhamDTO();
        try {
            SanPham sanPham = new SanPham();
            sanPham.setKhoThuoc(quanLyKhoThuocService.findById( sanPhamDTO.getKhoThuocId()));
            sanPham.setQuanLyBanHang(quanLyBanHangService.findById(sanPhamDTO.getQuanLyBanHangId()));
            sanPham.setFlag(sanPhamDTO.getFlag());
            sanPham.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            sanPham.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            sanPham.setSoLuongMua(sanPhamDTO.getSoLuongMua());

            sanPhamRepository.save(sanPham);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, SanPhamDTO sanPhamDTO) {
        Map<String,Object> result = new HashMap<>();
        SanPhamDTO resultCreate = new SanPhamDTO();
        try {
            SanPham object = sanPhamRepository.findById(id).get();
            object.setKhoThuoc(quanLyKhoThuocService.findById( sanPhamDTO.getKhoThuocId()));
            object.setQuanLyBanHang(quanLyBanHangService.findById(sanPhamDTO.getQuanLyBanHangId()));
            object.setFlag(sanPhamDTO.getFlag());
            object.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            object.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            object.setSoLuongMua(sanPhamDTO.getSoLuongMua());
            sanPhamRepository.save(object);
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
            List<SanPham> sanPhamList = sanPhamRepository.findAll();
            List<SanPhamDTO> sanPhamDTOS = new ArrayList<>();
            for (SanPham sanPham: sanPhamList) {

                SanPhamDTO sanPhamDTO = new SanPhamDTO();
                sanPhamDTO.setId(sanPham.getId());
                sanPhamDTO.setSoLuongMua(sanPham.getSoLuongMua());
                sanPhamDTO.setNgayChinhSua(sanPham.getNgayChinhSua());
                sanPhamDTO.setNgayTaoBanGhi(sanPham.getNgayTaoBanGhi());
                sanPhamDTO.setKhoThuocId(sanPham.getKhoThuoc().getId());
                sanPhamDTO.setQuanLyBanHangId(sanPham.getQuanLyBanHang().getId());
                sanPhamDTO.setFlag(sanPham.getFlag());
                sanPhamDTO.setQuanLyBanHangId(sanPham.getQuanLyBanHang().getId());


                KhoThuoc khoThuocItems = new KhoThuoc();

                KhoThuoc khoThuocById = quanLyKhoThuocService.findById(sanPham.getKhoThuoc().getId());
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
                khoThuocItems.setSoLuongDaBan(sanPham.getSoLuongMua());
                khoThuocItems.setSoLuongMua(sanPham.getSoLuongMua());
                khoThuocItems.setKhuVuc(khoThuocById.getKhuVuc());
                khoThuocItems.setNguoiTaoId(khoThuocById.getNguoiTaoId());
                khoThuocItems.setPhanTramThue(khoThuocById.getPhanTramThue());

                QuanLyBanHang quanLyBanHangItem = new QuanLyBanHang();
                QuanLyBanHang quanLyBanHangById = quanLyBanHangService.findById(sanPham.getQuanLyBanHang().getId());
                quanLyBanHangItem.setTenKhachHang(quanLyBanHangById.getTenKhachHang());


                sanPhamDTO.setTenKhachHang(quanLyBanHangById.getTenKhachHang());
                sanPhamDTO.setSoDienThoaiKhachHang(quanLyBanHangById.getSoDienThoaiKhachHang());
                sanPhamDTO.setIdKhachHang(quanLyBanHangById.getIdKhachHang());

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
        sanPhamRepository.deleteById(id);
    }

    @Override
    public QuanLyBanHang findById(Long id) {
        return null;
    }

    @Override
    public List<SanPhamDTO> getAllSanPhamById(Long id) {
        return sanPhamRepository.findBySanPham(id).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamDTO> deleteById(List idSanPhamDangCo) {

        return null;
    }

    private SanPhamDTO toDto(SanPham sanPham){
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setId(sanPham.getId());
        sanPhamDTO.setSoLuongMua(sanPham.getSoLuongMua());
        sanPhamDTO.setNgayChinhSua(sanPham.getNgayChinhSua());
        sanPhamDTO.setNgayTaoBanGhi(sanPham.getNgayTaoBanGhi());
        sanPhamDTO.setKhoThuocId(sanPham.getKhoThuoc().getId());
        sanPhamDTO.setQuanLyBanHangId(sanPham.getQuanLyBanHang().getId());
        sanPhamDTO.setFlag(sanPham.getFlag());
        sanPhamDTO.setQuanLyBanHangId(sanPham.getQuanLyBanHang().getId());

        return sanPhamDTO;
    }
}
