package com.example.quanlyquanthuoc.services.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.ThuocDaMuaDTO;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.example.quanlyquanthuoc.repositorys.quanlybanhang.SanPhamRepository;
import com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong.QuanLyBanHangThanhCongRepository;
import com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong.SanPhamThanhCongRepository;
import com.example.quanlyquanthuoc.repositorys.quanlykhothuoc.QuanLyKhoThuocRepository;
import com.example.quanlyquanthuoc.services.quanlykhothuoc.QuanLyKhoThuocService;
import com.example.quanlyquanthuoc.services.quanlytaikhoan.QuanLyTaiKhoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyBanHangThanhCongServiceImpl implements QuanLyBanHangThanhCongService {
    @Autowired
    QuanLyBanHangThanhCongRepository quanLyBanHangThanhCongRepository;

    @Autowired
    SanPhamThanhCongService sanPhamThanhCongService;

    @Autowired
    QuanLyKhoThuocService quanLyKhoThuocService;

    @Autowired
    SanPhamThanhCongRepository sanPhamThanhCongRepository;

    @Autowired
    QuanLyTaiKhoanService quanLyTaiKhoanService;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    QuanLyKhoThuocRepository quanLyKhoThuocRepository;

    @Override
    public Map<String, Object> create(QuanLyBanHangDTO quanLyBanHangDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            QuanLyBanHangThanhCong quanLyBanHangThanhCong = new QuanLyBanHangThanhCong();
            quanLyBanHangThanhCong.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            quanLyBanHangThanhCong.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            quanLyBanHangThanhCong.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());
            quanLyBanHangThanhCong.setFlag(true);
            quanLyBanHangThanhCong.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            quanLyBanHangThanhCong.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            quanLyBanHangThanhCong.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());

            quanLyBanHangThanhCongRepository.save(quanLyBanHangThanhCong);


            ObjectMapper mapper = new ObjectMapper();
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            for (int i = 0; i < quanLyBanHangDTO.getSanPham().size(); i++) {
                String jsonString = mapper.writeValueAsString(quanLyBanHangDTO.getSanPham().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String idThuoc = jsonObject.get("idThuoc").toString();
                String soLuongMua = jsonObject.get("soLuongMua").toString();
                System.out.println(quanLyBanHangThanhCong.getId());
                sanPhamDTO.setKhoThuocId(Long.parseLong(idThuoc));
                sanPhamDTO.setSoLuongMua(Long.parseLong(soLuongMua));
                sanPhamDTO.setQuanLyBanHangId(quanLyBanHangThanhCong.getId());
                sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                sanPhamDTO.setFlag(quanLyBanHangThanhCong.getFlag());
                sanPhamThanhCongService.create(sanPhamDTO);

                KhoThuoc khoThuoc = quanLyKhoThuocService.findById(Long.parseLong(idThuoc));
                khoThuoc.setId(Long.parseLong(idThuoc));
                khoThuoc.setSoLuongMua(Long.parseLong(soLuongMua));
                khoThuoc.setSoLuongDaBan(Long.parseLong(soLuongMua) + khoThuoc.getSoLuongDaBan());

                quanLyKhoThuocRepository.save(khoThuoc);

            }

            result.put("result", quanLyBanHangThanhCong);
            result.put("msg", "Thêm mói thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyBanHangDTO quanLyBanHangDTO) {
        Map<String, Object> result = new HashMap<>();
        QuanLyBanHangDTO resultUpdate = new QuanLyBanHangDTO();
        try {
            QuanLyBanHangThanhCong object = quanLyBanHangThanhCongRepository.findById(id).get();
            object.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            object.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            object.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());
            object.setFlag(true);
            object.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            object.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            object.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());

            quanLyBanHangThanhCongRepository.save(object);


            resultUpdate.setId(quanLyBanHangDTO.getId());
            resultUpdate.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            resultUpdate.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            resultUpdate.setFlag(quanLyBanHangDTO.getFlag());
            resultUpdate.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            resultUpdate.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            resultUpdate.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());
            resultUpdate.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());

            ObjectMapper mapper = new ObjectMapper();
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            List idSanPhamDangCo = new ArrayList();


            for (int i = 0; i < quanLyBanHangDTO.getSanPham().size(); i++) {
                String jsonString = mapper.writeValueAsString(quanLyBanHangDTO.getSanPham().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String idThuoc = jsonObject.get("idThuoc").toString();
                String soLuongMua = jsonObject.get("soLuongMua").toString();
                String idSanPham = jsonObject.get("id").toString();
                String soLuongDaBan = jsonObject.get("soLuongDaBan").toString();

                if (!idSanPham.equals("null")) {
                    idSanPhamDangCo.add(Long.parseLong(idSanPham));
                    sanPhamDTO.setKhoThuocId(Long.parseLong(idThuoc));
                    sanPhamDTO.setSoLuongMua(Long.parseLong(soLuongMua));
                    sanPhamDTO.setQuanLyBanHangId(object.getId());
                    sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                    sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                    sanPhamDTO.setFlag(object.getFlag());
                    sanPhamThanhCongService.update(Long.parseLong(idSanPham), sanPhamDTO);

                } else {
                    sanPhamDTO.setKhoThuocId(Long.parseLong(idThuoc));
                    sanPhamDTO.setSoLuongMua(Long.parseLong(soLuongMua));
                    sanPhamDTO.setQuanLyBanHangId(object.getId());
                    sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                    sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                    sanPhamDTO.setFlag(object.getFlag());
                    sanPhamThanhCongService.create(sanPhamDTO);
                }
            }

            // Thông tin tài khoản
            QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHangDTO.getNguoiTaoId());
            QuanLyTaiKhoan thongTinNguoiBan = new QuanLyTaiKhoan();
            thongTinNguoiBan.setId(thongTinTaiKhoanItem.getId());
            thongTinNguoiBan.setTenNguoiDung(thongTinTaiKhoanItem.getTenNguoiDung());
            thongTinNguoiBan.setTenDangNhap(thongTinTaiKhoanItem.getTenDangNhap());
            thongTinNguoiBan.setMatKhau(thongTinTaiKhoanItem.getMatKhau());
            thongTinNguoiBan.setXacNhanMatKhau(thongTinTaiKhoanItem.getXacNhanMatKhau());
            thongTinNguoiBan.setMatKhauGoc(thongTinTaiKhoanItem.getMatKhauGoc());
            thongTinNguoiBan.setNgaySinh(thongTinTaiKhoanItem.getNgaySinh());
            thongTinNguoiBan.setGioiTinh(thongTinTaiKhoanItem.getGioiTinh());
            thongTinNguoiBan.setFacebook(thongTinTaiKhoanItem.getFacebook());
            thongTinNguoiBan.setSoDienThoai(thongTinTaiKhoanItem.getSoDienThoai());
            thongTinNguoiBan.setCmnd(thongTinTaiKhoanItem.getCmnd());
            thongTinNguoiBan.setImg(thongTinTaiKhoanItem.getImg());


            // Thông tin khách hàng
            QuanLyThongTinKhachHang thongTinNguoiMua = new QuanLyThongTinKhachHang();
            thongTinNguoiMua.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            thongTinNguoiMua.setId(quanLyBanHangDTO.getIdKhachHang());
            thongTinNguoiMua.setSoDienThoai(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            thongTinNguoiMua.setFlag(quanLyBanHangDTO.getFlag());
            thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            thongTinNguoiMua.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());


//             Sản phẩm
            List arr = new ArrayList();
            for (int i = 0; i < sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).size(); i++) {
                ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                thuocDaMuaDTO.setSoLuongMua(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).get(i).getSoLuongMua());
                KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).get(i).getKhoThuoc().getId());
                thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                thuocDaMuaDTO.setId(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).get(i).getId());
                thuocDaMuaDTO.setDonViTinh(khoThuocItem.getDonViTinh());
                thuocDaMuaDTO.setTongTienTruocThue(khoThuocItem.getTongTienTruocThue());
                thuocDaMuaDTO.setPhanTramThue(khoThuocItem.getPhanTramThue());
                thuocDaMuaDTO.setChietKhau(khoThuocItem.getChietKhau());
                thuocDaMuaDTO.setGiaTien(khoThuocItem.getGiaTien());
                thuocDaMuaDTO.setThanhToan(khoThuocItem.getThanhToan());
                thuocDaMuaDTO.setSoLuongNhap(khoThuocItem.getSoLuongNhap());
                thuocDaMuaDTO.setSoLuongDaBan(khoThuocItem.getSoLuongDaBan());
                thuocDaMuaDTO.setFlag(khoThuocItem.getFlag());
                thuocDaMuaDTO.setNgayChinhSua(khoThuocItem.getNgayChinhSua());
                thuocDaMuaDTO.setNgayTaoBanGhi(khoThuocItem.getNgayTaoBanGhi());
                thuocDaMuaDTO.setNguoiTaoId(khoThuocItem.getNguoiTaoId());
                thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
                thuocDaMuaDTO.setPhanLoaiThuoc(khoThuocItem.getPhanLoaiThuoc());
                thuocDaMuaDTO.setKhuVuc(khoThuocItem.getKhuVuc());
                thuocDaMuaDTO.setMa(khoThuocItem.getMa());
                thuocDaMuaDTO.setIdThuoc(khoThuocItem.getId());


                arr.add(thuocDaMuaDTO);
            }
            System.out.println("Thuócad" + idSanPhamDangCo);

            resultUpdate.setThongTinNguoiBan(thongTinNguoiBan);
            resultUpdate.setSanPham(arr);
            resultUpdate.setThongTinNguoiMua(thongTinNguoiMua);

            result.put("result", resultUpdate);
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
        QuanLyBanHangThanhCong quanLyBanHangThanhCong = quanLyBanHangThanhCongRepository.findById(id).orElse(null);
        QuanLyBanHangDTO quanLyBanHangDTO = new QuanLyBanHangDTO();
        try {
            if (quanLyBanHangThanhCong != null) {
                quanLyBanHangDTO.setId(quanLyBanHangThanhCong.getId());
                quanLyBanHangDTO.setNgayChinhSua(quanLyBanHangThanhCong.getNgayChinhSua());
                quanLyBanHangDTO.setNgayTaoBanGhi(quanLyBanHangThanhCong.getNgayTaoBanGhi());
                quanLyBanHangDTO.setFlag(quanLyBanHangThanhCong.getFlag());
                quanLyBanHangDTO.setTenKhachHang(quanLyBanHangThanhCong.getTenKhachHang());
                quanLyBanHangDTO.setSoDienThoaiKhachHang(quanLyBanHangThanhCong.getSoDienThoaiKhachHang());
                quanLyBanHangDTO.setNguoiTaoId(quanLyBanHangThanhCong.getNguoiTaoId());
                quanLyBanHangDTO.setIdKhachHang(quanLyBanHangThanhCong.getIdKhachHang());


                // Thông tin tài khoản
                QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHangThanhCong.getNguoiTaoId());
                QuanLyTaiKhoan thongTinNguoiBan = new QuanLyTaiKhoan();
                thongTinNguoiBan.setId(thongTinTaiKhoanItem.getId());
                thongTinNguoiBan.setTenNguoiDung(thongTinTaiKhoanItem.getTenNguoiDung());
                thongTinNguoiBan.setTenDangNhap(thongTinTaiKhoanItem.getTenDangNhap());
                thongTinNguoiBan.setMatKhau(thongTinTaiKhoanItem.getMatKhau());
                thongTinNguoiBan.setXacNhanMatKhau(thongTinTaiKhoanItem.getXacNhanMatKhau());
                thongTinNguoiBan.setMatKhauGoc(thongTinTaiKhoanItem.getMatKhauGoc());
                thongTinNguoiBan.setNgaySinh(thongTinTaiKhoanItem.getNgaySinh());
                thongTinNguoiBan.setGioiTinh(thongTinTaiKhoanItem.getGioiTinh());
                thongTinNguoiBan.setFacebook(thongTinTaiKhoanItem.getFacebook());
                thongTinNguoiBan.setSoDienThoai(thongTinTaiKhoanItem.getSoDienThoai());
                thongTinNguoiBan.setCmnd(thongTinTaiKhoanItem.getCmnd());
                thongTinNguoiBan.setImg(thongTinTaiKhoanItem.getImg());


                // Thông tin khách hàng
                QuanLyThongTinKhachHang thongTinNguoiMua = new QuanLyThongTinKhachHang();
                thongTinNguoiMua.setTenKhachHang(quanLyBanHangThanhCong.getTenKhachHang());
                thongTinNguoiMua.setId(quanLyBanHangThanhCong.getIdKhachHang());
                thongTinNguoiMua.setSoDienThoai(quanLyBanHangThanhCong.getSoDienThoaiKhachHang());
                thongTinNguoiMua.setFlag(quanLyBanHangThanhCong.getFlag());
                thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHangThanhCong.getNgayTaoBanGhi());
                thongTinNguoiMua.setNgayChinhSua(quanLyBanHangThanhCong.getNgayChinhSua());

                // Sản phẩm
                List arr = new ArrayList();
                for (int i = 0; i < sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).size(); i++) {
                    ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                    thuocDaMuaDTO.setSoLuongMua(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getSoLuongMua());
                    KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getKhoThuoc().getId());
                    thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                    thuocDaMuaDTO.setId(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getId());
                    thuocDaMuaDTO.setDonViTinh(khoThuocItem.getDonViTinh());
                    thuocDaMuaDTO.setTongTienTruocThue(khoThuocItem.getTongTienTruocThue());
                    thuocDaMuaDTO.setPhanTramThue(khoThuocItem.getPhanTramThue());
                    thuocDaMuaDTO.setChietKhau(khoThuocItem.getChietKhau());
                    thuocDaMuaDTO.setGiaTien(khoThuocItem.getGiaTien());
                    thuocDaMuaDTO.setThanhToan(khoThuocItem.getThanhToan());
                    thuocDaMuaDTO.setSoLuongNhap(khoThuocItem.getSoLuongNhap());
                    thuocDaMuaDTO.setSoLuongDaBan(khoThuocItem.getSoLuongDaBan());
                    thuocDaMuaDTO.setFlag(khoThuocItem.getFlag());
                    thuocDaMuaDTO.setNgayChinhSua(khoThuocItem.getNgayChinhSua());
                    thuocDaMuaDTO.setNgayTaoBanGhi(khoThuocItem.getNgayTaoBanGhi());
                    thuocDaMuaDTO.setNguoiTaoId(khoThuocItem.getNguoiTaoId());
                    thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
                    thuocDaMuaDTO.setPhanLoaiThuoc(khoThuocItem.getPhanLoaiThuoc());
                    thuocDaMuaDTO.setKhuVuc(khoThuocItem.getKhuVuc());
                    thuocDaMuaDTO.setMa(khoThuocItem.getMa());
                    thuocDaMuaDTO.setIdThuoc(khoThuocItem.getId());
                    thuocDaMuaDTO.setSoLuongMuaBanDau(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangDTO.getId()).get(i).getSoLuongMua());
                    thuocDaMuaDTO.setNhaCungCapId(khoThuocItem.getQuanLyNhaCungCap().getId());
                    thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
                    arr.add(thuocDaMuaDTO);
                }

                quanLyBanHangDTO.setThongTinNguoiBan(thongTinNguoiBan);
                quanLyBanHangDTO.setSanPham(arr);
                quanLyBanHangDTO.setThongTinNguoiMua(thongTinNguoiMua);


                result.put("result", quanLyBanHangDTO);
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
            List<QuanLyBanHangThanhCong> quanLyBanHangThanhCongList = quanLyBanHangThanhCongRepository.findAll();
            List<QuanLyBanHangDTO> quanLyBanHangDTOS = new ArrayList<>();

            for (QuanLyBanHangThanhCong quanLyBanHangThanhCong : quanLyBanHangThanhCongList) {
                QuanLyBanHangDTO quanLyBanHangDTO = new QuanLyBanHangDTO();
                quanLyBanHangDTO.setId(quanLyBanHangThanhCong.getId());
                quanLyBanHangDTO.setFlag(quanLyBanHangThanhCong.getFlag());
                quanLyBanHangDTO.setSoDienThoaiKhachHang(quanLyBanHangThanhCong.getSoDienThoaiKhachHang());
                quanLyBanHangDTO.setTenKhachHang(quanLyBanHangThanhCong.getTenKhachHang());
                quanLyBanHangDTO.setNguoiTaoId(quanLyBanHangThanhCong.getNguoiTaoId());

                quanLyBanHangDTO.setNgayChinhSua(quanLyBanHangThanhCong.getNgayChinhSua());
                quanLyBanHangDTO.setNgayTaoBanGhi(quanLyBanHangThanhCong.getNgayTaoBanGhi());

                // Thông tin tài khoản
                QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHangThanhCong.getNguoiTaoId());
                QuanLyTaiKhoan thongTinNguoiBan = new QuanLyTaiKhoan();
                thongTinNguoiBan.setId(thongTinTaiKhoanItem.getId());
                thongTinNguoiBan.setTenNguoiDung(thongTinTaiKhoanItem.getTenNguoiDung());
                thongTinNguoiBan.setTenDangNhap(thongTinTaiKhoanItem.getTenDangNhap());
                thongTinNguoiBan.setMatKhau(thongTinTaiKhoanItem.getMatKhau());
                thongTinNguoiBan.setXacNhanMatKhau(thongTinTaiKhoanItem.getXacNhanMatKhau());
                thongTinNguoiBan.setMatKhauGoc(thongTinTaiKhoanItem.getMatKhauGoc());
                thongTinNguoiBan.setNgaySinh(thongTinTaiKhoanItem.getNgaySinh());
                thongTinNguoiBan.setGioiTinh(thongTinTaiKhoanItem.getGioiTinh());
                thongTinNguoiBan.setFacebook(thongTinTaiKhoanItem.getFacebook());
                thongTinNguoiBan.setSoDienThoai(thongTinTaiKhoanItem.getSoDienThoai());
                thongTinNguoiBan.setCmnd(thongTinTaiKhoanItem.getCmnd());
                thongTinNguoiBan.setImg(thongTinTaiKhoanItem.getImg());


                // Thông tin khách hàng
                QuanLyThongTinKhachHang thongTinNguoiMua = new QuanLyThongTinKhachHang();
                thongTinNguoiMua.setTenKhachHang(quanLyBanHangThanhCong.getTenKhachHang());
                thongTinNguoiMua.setId(quanLyBanHangThanhCong.getIdKhachHang());
                thongTinNguoiMua.setSoDienThoai(quanLyBanHangThanhCong.getSoDienThoaiKhachHang());
                thongTinNguoiMua.setFlag(quanLyBanHangThanhCong.getFlag());
                thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHangThanhCong.getNgayTaoBanGhi());
                thongTinNguoiMua.setNgayChinhSua(quanLyBanHangThanhCong.getNgayChinhSua());

                // Sản phẩm
                List arr = new ArrayList();
                Double totalTien = 0.0;
                for (int i = 0; i < sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).size(); i++) {
                    ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                    thuocDaMuaDTO.setSoLuongMua(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getSoLuongMua());
                    KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getKhoThuoc().getId());
                    thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                    thuocDaMuaDTO.setId(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getId());
                    thuocDaMuaDTO.setDonViTinh(khoThuocItem.getDonViTinh());
                    thuocDaMuaDTO.setTongTienTruocThue(khoThuocItem.getTongTienTruocThue());
                    thuocDaMuaDTO.setPhanTramThue(khoThuocItem.getPhanTramThue());
                    thuocDaMuaDTO.setChietKhau(khoThuocItem.getChietKhau());
                    thuocDaMuaDTO.setGiaTien(khoThuocItem.getGiaTien());
                    thuocDaMuaDTO.setThanhToan(khoThuocItem.getThanhToan());
                    thuocDaMuaDTO.setSoLuongNhap(khoThuocItem.getSoLuongNhap());
                    thuocDaMuaDTO.setSoLuongDaBan(khoThuocItem.getSoLuongDaBan());
                    thuocDaMuaDTO.setFlag(khoThuocItem.getFlag());
                    thuocDaMuaDTO.setNgayChinhSua(khoThuocItem.getNgayChinhSua());
                    thuocDaMuaDTO.setNgayTaoBanGhi(khoThuocItem.getNgayTaoBanGhi());
                    thuocDaMuaDTO.setNguoiTaoId(khoThuocItem.getNguoiTaoId());
                    thuocDaMuaDTO.setHanSuDungThuoc(khoThuocItem.getHanSuDungThuoc());
                    thuocDaMuaDTO.setPhanLoaiThuoc(khoThuocItem.getPhanLoaiThuoc());
                    thuocDaMuaDTO.setKhuVuc(khoThuocItem.getKhuVuc());
                    thuocDaMuaDTO.setMa(khoThuocItem.getMa());
                    thuocDaMuaDTO.setIdThuoc(khoThuocItem.getId());
//                    System.out.println(sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getSoLuongMua());
//                    System.out.println(khoThuocItem.getGiaTien());
                    totalTien += (sanPhamThanhCongRepository.findBySanPhamThanhCong(quanLyBanHangThanhCong.getId()).get(i).getSoLuongMua() * khoThuocItem.getGiaTien());
                    arr.add(thuocDaMuaDTO);
                }
                System.out.println(totalTien);
                quanLyBanHangDTO.setTotalTien(totalTien);
                quanLyBanHangDTO.setThongTinNguoiBan(thongTinNguoiBan);
                quanLyBanHangDTO.setSanPham(arr);
                quanLyBanHangDTO.setThongTinNguoiMua(thongTinNguoiMua);
                quanLyBanHangDTOS.add(quanLyBanHangDTO);

            }
            result.put("result", quanLyBanHangDTOS);
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
    public QuanLyBanHangThanhCong findById(Long id) {
        return quanLyBanHangThanhCongRepository.findById(id).orElse(null);
    }

    @Override
    public List<SanPhamThanhCong> getAllSanPhamById(Long id) {
        List<SanPhamThanhCong> sanPhamThanhCong = sanPhamThanhCongRepository.findBySanPhamThanhCong(id);
        return sanPhamThanhCong;
    }

    @Override
    public Map<String,Object> findAllHoaDonByIdKhachHang(Long idKhachHang) {
        Map<String, Object> result = new HashMap<>();
            List listHoaDonThanhCongByKhachHang = quanLyBanHangThanhCongRepository.findAllHoaDonByIdKhachHang(idKhachHang);
        System.out.println(listHoaDonThanhCongByKhachHang);
        List arrHoaDon = new ArrayList();

        for (int i = 0; i < listHoaDonThanhCongByKhachHang.size(); i++) {
            arrHoaDon.add(fetchById((Long) listHoaDonThanhCongByKhachHang.get(i)));
        }
        result.put("result",arrHoaDon);

        return result;
    }

}
