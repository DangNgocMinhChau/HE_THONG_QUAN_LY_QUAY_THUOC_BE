package com.example.quanlyquanthuoc.services.quanlybanhangthanhcong;


import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.ThuocDaMuaDTO;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong.SanPhamThanhCongRepository;
import com.example.quanlyquanthuoc.repositorys.quanlykhothuoc.QuanLyKhoThuocRepository;
import com.example.quanlyquanthuoc.services.quanlykhothuoc.QuanLyKhoThuocService;
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
    QuanLyKhoThuocRepository quanLyKhoThuocRepository;

    @Autowired
    QuanLyBanHangThanhCongService quanLyBanHangThanhCongService;

    @Override
    public Map<String, Object> create(SanPhamDTO sanPhamDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            SanPhamThanhCong sanPhamThanhCong = new SanPhamThanhCong();
            sanPhamThanhCong.setKhoThuoc(quanLyKhoThuocService.findById(sanPhamDTO.getKhoThuocId()));
            sanPhamThanhCong.setQuanLyBanHangThanhCong(quanLyBanHangThanhCongService.findById(sanPhamDTO.getQuanLyBanHangId()));
            sanPhamThanhCong.setFlag(sanPhamDTO.getFlag());
            sanPhamThanhCong.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            sanPhamThanhCong.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            sanPhamThanhCong.setSoLuongMua(sanPhamDTO.getSoLuongMua());

            sanPhamThanhCongRepository.save(sanPhamThanhCong);

            quanLyKhoThuocService.updateKhoThuoc();


        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, SanPhamDTO sanPhamDTO) {
        Map<String, Object> result = new HashMap<>();
        SanPhamDTO resultCreate = new SanPhamDTO();

        try {
            SanPhamThanhCong object = sanPhamThanhCongRepository.findById(id).get();
            object.setKhoThuoc(quanLyKhoThuocService.findById(sanPhamDTO.getKhoThuocId()));
            object.setQuanLyBanHangThanhCong(quanLyBanHangThanhCongService.findById(sanPhamDTO.getQuanLyBanHangId()));
            object.setFlag(sanPhamDTO.getFlag());
            object.setNgayChinhSua(sanPhamDTO.getNgayChinhSua());
            object.setNgayTaoBanGhi(sanPhamDTO.getNgayTaoBanGhi());
            object.setSoLuongMua(sanPhamDTO.getSoLuongMua());
            sanPhamThanhCongRepository.save(object);

            quanLyKhoThuocService.updateKhoThuoc();

        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public Map<String, Object> updateSanPhamTrongHoaDon(Long id, SanPhamDTO sanPhamDTO) {
        quanLyKhoThuocService.updateKhoThuoc();
        SanPhamThanhCong itemSanPhamThanhcong = sanPhamThanhCongRepository.findById(sanPhamDTO.getId()).orElse(null);
        itemSanPhamThanhcong.setSoLuongMua(sanPhamDTO.getSoLuongMua());
        sanPhamThanhCongRepository.save(itemSanPhamThanhcong);
        quanLyKhoThuocService.updateKhoThuoc();

        return null;
    }


    @Override
    public Map<String, Object> fetchById(Long id) {
        quanLyKhoThuocService.updateKhoThuoc();

        Map<String, Object> result = new HashMap<>();
        result.put("result", sanPhamThanhCongRepository.findById(id).orElse(null));
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        quanLyKhoThuocService.updateKhoThuoc();

        Map<String, Object> result = new HashMap<>();
        try {
            List<SanPhamThanhCong> sanPhamThanhCongList = sanPhamThanhCongRepository.findAll();
            List<SanPhamDTO> sanPhamDTOS = new ArrayList<>();
            for (SanPhamThanhCong sanPhamThanhCong : sanPhamThanhCongList) {

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
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        SanPhamThanhCong sanPhamThanhCong = sanPhamThanhCongRepository.findById(id).orElse(null);
        KhoThuoc khoThuoc = quanLyKhoThuocRepository.findById(sanPhamThanhCong.getKhoThuoc().getId()).orElse(null);
        khoThuoc.setSoLuongDaBan(khoThuoc.getSoLuongDaBan() - sanPhamThanhCong.getSoLuongMua());
        khoThuoc.setSoLuongMua(khoThuoc.getSoLuongMua() - sanPhamThanhCong.getSoLuongMua());
        quanLyKhoThuocRepository.save(khoThuoc);
        sanPhamThanhCongRepository.deleteById(id);
        quanLyKhoThuocService.updateKhoThuoc();

    }

    @Override
    public QuanLyBanHang findById(Long id) {
        return null;
    }

    @Override
    public List<SanPhamDTO> getAllSanPhamById(Long id) {
        quanLyKhoThuocService.updateKhoThuoc();

        return sanPhamThanhCongRepository.findBySanPhamThanhCong(id).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamDTO> deleteById(List idSanPhamDangCo) {

        return null;
    }

    @Override
    public Map<String, Object> getAllSanPhamByIdHoaDon(Long id) {
        System.out.println("test" + id);
        Map<String, Object> result = new HashMap<>();
//        SanPhamThanhCong sanPhamThanhCongList = sanPhamThanhCongRepository.getAllSanPhamByIdHoaDon(id);
        QuanLyBanHangDTO quanLyBanHangDTO = new QuanLyBanHangDTO();

//        try {
//            if (sanPhamThanhCongList != null) {
//                quanLyBanHangDTO.setId(sanPhamThanhCongList.getId());
//                quanLyBanHangDTO.setNgayChinhSua(sanPhamThanhCongList.getNgayChinhSua());
//                quanLyBanHangDTO.setNgayTaoBanGhi(sanPhamThanhCongList.getNgayTaoBanGhi());
//                quanLyBanHangDTO.setFlag(sanPhamThanhCongList.getFlag());
//                quanLyBanHangDTO.setTenKhachHang(sanPhamThanhCongList.getTenKhachHang());
//                quanLyBanHangDTO.setSoDienThoaiKhachHang(sanPhamThanhCongList.getSoDienThoaiKhachHang());
//                quanLyBanHangDTO.setNguoiTaoId(sanPhamThanhCongList.getNguoiTaoId());
//                quanLyBanHangDTO.setIdKhachHang(sanPhamThanhCongList.getIdKhachHang());
//
//
//                // Thông tin tài khoản
//                QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHangThanhCong.getNguoiTaoId());
//                QuanLyTaiKhoan thongTinNguoiBan = new QuanLyTaiKhoan();
//                thongTinNguoiBan.setId(thongTinTaiKhoanItem.getId());
//                thongTinNguoiBan.setTenNguoiDung(thongTinTaiKhoanItem.getTenNguoiDung());
//                thongTinNguoiBan.setTenDangNhap(thongTinTaiKhoanItem.getTenDangNhap());
//                thongTinNguoiBan.setMatKhau(thongTinTaiKhoanItem.getMatKhau());
//                thongTinNguoiBan.setXacNhanMatKhau(thongTinTaiKhoanItem.getXacNhanMatKhau());
//                thongTinNguoiBan.setMatKhauGoc(thongTinTaiKhoanItem.getMatKhauGoc());
//                thongTinNguoiBan.setNgaySinh(thongTinTaiKhoanItem.getNgaySinh());
//                thongTinNguoiBan.setGioiTinh(thongTinTaiKhoanItem.getGioiTinh());
//                thongTinNguoiBan.setFacebook(thongTinTaiKhoanItem.getFacebook());
//                thongTinNguoiBan.setSoDienThoai(thongTinTaiKhoanItem.getSoDienThoai());
//                thongTinNguoiBan.setCmnd(thongTinTaiKhoanItem.getCmnd());
//                thongTinNguoiBan.setImg(thongTinTaiKhoanItem.getImg());
//
//
//                // Thông tin khách hàng
//                QuanLyThongTinKhachHang thongTinNguoiMua = new QuanLyThongTinKhachHang();
//                thongTinNguoiMua.setTenKhachHang(quanLyBanHangThanhCong.getTenKhachHang());
//                thongTinNguoiMua.setId(quanLyBanHangThanhCong.getIdKhachHang());
//                thongTinNguoiMua.setSoDienThoai(quanLyBanHangThanhCong.getSoDienThoaiKhachHang());
//                thongTinNguoiMua.setFlag(quanLyBanHangThanhCong.getFlag());
//                thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHangThanhCong.getNgayTaoBanGhi());
//                thongTinNguoiMua.setNgayChinhSua(quanLyBanHangThanhCong.getNgayChinhSua());
//
//                // Sản phẩm
//                List arr = new ArrayList();
//                for (int i = 0; i < sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).size(); i++) {
//                    ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();
//
//                    thuocDaMuaDTO.setSoLuongMua(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getSoLuongMua());
//                    KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getKhoThuoc().getId());
//                    thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
//                    thuocDaMuaDTO.setId(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getId());
//                    thuocDaMuaDTO.setDonViTinh(khoThuocItem.getDonViTinh());
//                    thuocDaMuaDTO.setTongTienTruocThue(khoThuocItem.getTongTienTruocThue());
//                    thuocDaMuaDTO.setPhanTramThue(khoThuocItem.getPhanTramThue());
//                    thuocDaMuaDTO.setChietKhau(khoThuocItem.getChietKhau());
//                    thuocDaMuaDTO.setGiaTien(khoThuocItem.getGiaTien());
//                    thuocDaMuaDTO.setThanhToan(khoThuocItem.getThanhToan());
//                    thuocDaMuaDTO.setSoLuongNhap(khoThuocItem.getSoLuongNhap());
//                    thuocDaMuaDTO.setSoLuongDaBan(khoThuocItem.getSoLuongDaBan());
//                    thuocDaMuaDTO.setFlag(khoThuocItem.getFlag());
//                    thuocDaMuaDTO.setNgayChinhSua(khoThuocItem.getNgayChinhSua());
//                    thuocDaMuaDTO.setNgayTaoBanGhi(khoThuocItem.getNgayTaoBanGhi());
//                    thuocDaMuaDTO.setNguoiTaoId(khoThuocItem.getNguoiTaoId());
//                    thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
//                    thuocDaMuaDTO.setPhanLoaiThuoc(khoThuocItem.getPhanLoaiThuoc());
//                    thuocDaMuaDTO.setKhuVuc(khoThuocItem.getKhuVuc());
//                    thuocDaMuaDTO.setMa(khoThuocItem.getMa());
//                    thuocDaMuaDTO.setIdThuoc(khoThuocItem.getId());
//                    thuocDaMuaDTO.setSoLuongMuaBanDau(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).get(i).getSoLuongMua());
//                    thuocDaMuaDTO.setNhaCungCapId(khoThuocItem.getQuanLyNhaCungCap().getId());
//                    thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
//                    arr.add(thuocDaMuaDTO);
//                }
//
//                quanLyBanHangDTO.setThongTinNguoiBan(thongTinNguoiBan);
//                quanLyBanHangDTO.setSanPham(arr);
//                quanLyBanHangDTO.setThongTinNguoiMua(thongTinNguoiMua);
//
//
//                result.put("result", quanLyBanHangDTO);
//                result.put("status", true);
//            } else {
//                result.put("result", null);
//                result.put("status", false);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("result", null);
//            result.put("status", false);
//        }

        return result;
    }


    private SanPhamDTO toDto(SanPhamThanhCong sanPhamThanhCong) {
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
