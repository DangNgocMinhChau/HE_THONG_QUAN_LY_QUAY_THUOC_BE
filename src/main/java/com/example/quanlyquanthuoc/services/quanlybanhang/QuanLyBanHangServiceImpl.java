package com.example.quanlyquanthuoc.services.quanlybanhang;

import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHangDTO;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPham;
import com.example.quanlyquanthuoc.models.quanlybanhang.SanPhamDTO;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.ThuocDaMuaDTO;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;
import com.example.quanlyquanthuoc.repositorys.quanlybanhang.QuanLyBanHangRepository;
import com.example.quanlyquanthuoc.repositorys.quanlybanhang.SanPhamRepository;
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
public class QuanLyBanHangServiceImpl implements QuanLyBanHangService {
    @Autowired
    QuanLyBanHangRepository quanLyBanHangRepository;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    QuanLyKhoThuocService quanLyKhoThuocService;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    QuanLyTaiKhoanService quanLyTaiKhoanService;

    @Override
    public Map<String, Object> create(QuanLyBanHangDTO quanLyBanHangDTO) {
        Map<String,Object> result = new HashMap<>();
        QuanLyBanHangDTO resultCreate = new QuanLyBanHangDTO();
        try{
                QuanLyBanHang quanLyBanHang = new QuanLyBanHang();
            quanLyBanHang.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            quanLyBanHang.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            quanLyBanHang.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());
            quanLyBanHang.setFlag(true);
            quanLyBanHang.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            quanLyBanHang.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            quanLyBanHang.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());
            quanLyBanHang.setTienNhan(quanLyBanHangDTO.getTienNhan());

            quanLyBanHangRepository.save(quanLyBanHang);


            resultCreate.setId(quanLyBanHang.getId());
            resultCreate.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());
            resultCreate.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
            resultCreate.setFlag(quanLyBanHang.getFlag());
            resultCreate.setTenKhachHang(quanLyBanHang.getTenKhachHang());
            resultCreate.setSoDienThoaiKhachHang(quanLyBanHang.getSoDienThoaiKhachHang());
            resultCreate.setNguoiTaoId(quanLyBanHang.getNguoiTaoId());
            resultCreate.setIdKhachHang(quanLyBanHang.getIdKhachHang());
            resultCreate.setTienNhan(quanLyBanHang.getTienNhan());


            ObjectMapper mapper =new ObjectMapper();
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            for (int i = 0; i < quanLyBanHangDTO.getSanPham().size(); i++) {
                String jsonString = mapper.writeValueAsString( quanLyBanHangDTO.getSanPham().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String idThuoc = jsonObject.get("idThuoc").toString();
                String soLuongMua = jsonObject.get("soLuongMua").toString();
                sanPhamDTO.setKhoThuocId(Long.parseLong( idThuoc));
                sanPhamDTO.setSoLuongMua(Long.parseLong( soLuongMua));
                sanPhamDTO.setQuanLyBanHangId(quanLyBanHang.getId());
                sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                sanPhamDTO.setFlag(quanLyBanHang.getFlag());
                sanPhamService.create(sanPhamDTO);
            }


            // Thông tin tài khoản
            QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHang.getNguoiTaoId());
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
            thongTinNguoiMua.setTenKhachHang(quanLyBanHang.getTenKhachHang());
            thongTinNguoiMua.setId(quanLyBanHang.getIdKhachHang());
            thongTinNguoiMua.setSoDienThoai(quanLyBanHang.getSoDienThoaiKhachHang());
            thongTinNguoiMua.setFlag(quanLyBanHang.getFlag());
            thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
            thongTinNguoiMua.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());

            // Sản phẩm
            List arr = new ArrayList();
            for (int i = 0; i <sanPhamRepository.findBySanPham(quanLyBanHang.getId()).size() ; i++) {
                ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                thuocDaMuaDTO.setSoLuongMua(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getSoLuongMua());
                KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getKhoThuoc().getId());
                thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                thuocDaMuaDTO.setId(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getId());
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

            resultCreate.setThongTinNguoiBan(thongTinNguoiBan);
            resultCreate.setSanPham(arr);
            resultCreate.setThongTinNguoiMua(thongTinNguoiMua);


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
    public Map<String, Object> update(Long id, QuanLyBanHangDTO quanLyBanHangDTO) {
        Map<String,Object> result = new HashMap<>();
        QuanLyBanHangDTO resultUpdate = new QuanLyBanHangDTO();
        try {
            QuanLyBanHang object = quanLyBanHangRepository.findById(id).get();
            object.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            object.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            object.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());
            object.setFlag(true);
            object.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            object.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            object.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());
            object.setTienNhan(quanLyBanHangDTO.getTienNhan());

            quanLyBanHangRepository.save(object);



            resultUpdate.setId(quanLyBanHangDTO.getId());
            resultUpdate.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
            resultUpdate.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
            resultUpdate.setFlag(quanLyBanHangDTO.getFlag());
            resultUpdate.setTenKhachHang(quanLyBanHangDTO.getTenKhachHang());
            resultUpdate.setSoDienThoaiKhachHang(quanLyBanHangDTO.getSoDienThoaiKhachHang());
            resultUpdate.setNguoiTaoId(quanLyBanHangDTO.getNguoiTaoId());
            resultUpdate.setIdKhachHang(quanLyBanHangDTO.getIdKhachHang());
            resultUpdate.setTienNhan(quanLyBanHangDTO.getTienNhan());

            ObjectMapper mapper =new ObjectMapper();
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            List idSanPhamDangCo = new ArrayList();



            for (int i = 0; i < quanLyBanHangDTO.getSanPham().size(); i++) {
                String jsonString = mapper.writeValueAsString(quanLyBanHangDTO.getSanPham().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String idThuoc = jsonObject.get("idThuoc").toString();
                String soLuongMua = jsonObject.get("soLuongMua").toString();
                String idSanPham = jsonObject.get("id").toString();
                if(!idSanPham.equals("null")){
                    idSanPhamDangCo.add(Long.parseLong(idSanPham));
                    sanPhamDTO.setKhoThuocId(Long.parseLong( idThuoc));
                    sanPhamDTO.setSoLuongMua(Long.parseLong( soLuongMua));
                    sanPhamDTO.setQuanLyBanHangId(object.getId());
                    sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                    sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                    sanPhamDTO.setFlag(object.getFlag());
                    sanPhamService.update(Long.parseLong( idSanPham),sanPhamDTO);

                }else {
                    sanPhamDTO.setKhoThuocId(Long.parseLong( idThuoc));
                    sanPhamDTO.setSoLuongMua(Long.parseLong( soLuongMua));
                    sanPhamDTO.setQuanLyBanHangId(object.getId());
                    sanPhamDTO.setNgayTaoBanGhi(quanLyBanHangDTO.getNgayTaoBanGhi());
                    sanPhamDTO.setNgayChinhSua(quanLyBanHangDTO.getNgayChinhSua());
                    sanPhamDTO.setFlag(object.getFlag());
                    sanPhamService.create(sanPhamDTO);
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
            for (int i = 0; i <sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).size() ; i++) {
                ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                thuocDaMuaDTO.setSoLuongMua(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).get(i).getSoLuongMua());
                KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).get(i).getKhoThuoc().getId());
                thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                thuocDaMuaDTO.setId(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).get(i).getId());
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

//                System.out.println("idtaomoi" +  sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).get(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).size() - 1).getId());
//                idSanPhamDangCo.add(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).get(sanPhamRepository.findBySanPham(quanLyBanHangDTO.getId()).size() - 1).getId());
//                sanPhamService.deleteById(idSanPhamDangCo);


                arr.add(thuocDaMuaDTO);
            }

            resultUpdate.setThongTinNguoiBan(thongTinNguoiBan);
            resultUpdate.setSanPham(arr);
            resultUpdate.setThongTinNguoiMua(thongTinNguoiMua);

            result.put("result",resultUpdate);
            result.put("msg","sửa thành công");
            result.put("status",true);
        }catch (Exception e){
            result.put("msg","Sửa thất bại");
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String,Object> result = new HashMap<>();
        QuanLyBanHang quanLyBanHang = quanLyBanHangRepository.findById(id).orElse(null);
        QuanLyBanHangDTO quanLyBanHangDTO = new QuanLyBanHangDTO();
        try {
            if(quanLyBanHang != null){
                quanLyBanHangDTO.setId(quanLyBanHang.getId());
                quanLyBanHangDTO.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());
                quanLyBanHangDTO.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
                quanLyBanHangDTO.setFlag(quanLyBanHang.getFlag());
                quanLyBanHangDTO.setTenKhachHang(quanLyBanHang.getTenKhachHang());
                quanLyBanHangDTO.setSoDienThoaiKhachHang(quanLyBanHang.getSoDienThoaiKhachHang());
                quanLyBanHangDTO.setNguoiTaoId(quanLyBanHang.getNguoiTaoId());
                quanLyBanHangDTO.setIdKhachHang(quanLyBanHang.getIdKhachHang());
                quanLyBanHangDTO.setTienNhan(quanLyBanHang.getTienNhan());


                // Thông tin tài khoản
                QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHang.getNguoiTaoId());
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
                thongTinNguoiMua.setTenKhachHang(quanLyBanHang.getTenKhachHang());
                thongTinNguoiMua.setId(quanLyBanHang.getIdKhachHang());
                thongTinNguoiMua.setSoDienThoai(quanLyBanHang.getSoDienThoaiKhachHang());
                thongTinNguoiMua.setFlag(quanLyBanHang.getFlag());
                thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
                thongTinNguoiMua.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());

                // Sản phẩm
                List arr = new ArrayList();
                for (int i = 0; i <sanPhamRepository.findBySanPham(quanLyBanHang.getId()).size() ; i++) {
                    ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                    thuocDaMuaDTO.setSoLuongMua(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getSoLuongMua());
                    KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getKhoThuoc().getId());
                    thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                    thuocDaMuaDTO.setId(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getId());
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

                quanLyBanHangDTO.setThongTinNguoiBan(thongTinNguoiBan);
                quanLyBanHangDTO.setSanPham(arr);
                quanLyBanHangDTO.setThongTinNguoiMua(thongTinNguoiMua);


                result.put("result",quanLyBanHangDTO);
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
            List<QuanLyBanHang> quanLyBanHangList = quanLyBanHangRepository.findAll();
            List<QuanLyBanHangDTO> quanLyBanHangDTOS = new ArrayList<>();


            for(QuanLyBanHang quanLyBanHang : quanLyBanHangList){
                QuanLyBanHangDTO quanLyBanHangDTO = new QuanLyBanHangDTO();
                quanLyBanHangDTO.setId(quanLyBanHang.getId());
                quanLyBanHangDTO.setFlag(quanLyBanHang.getFlag());

                quanLyBanHangDTO.setNguoiTaoId(quanLyBanHang.getNguoiTaoId());
                quanLyBanHangDTO.setTienNhan(quanLyBanHang.getTienNhan());
                quanLyBanHangDTO.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());
                quanLyBanHangDTO.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
                quanLyBanHangDTO.setTenKhachHang(quanLyBanHang.getTenKhachHang());
                quanLyBanHangDTO.setSoDienThoaiKhachHang(quanLyBanHang.getSoDienThoaiKhachHang());
                // Thông tin tài khoản
                QuanLyTaiKhoan thongTinTaiKhoanItem = quanLyTaiKhoanService.findById(quanLyBanHang.getNguoiTaoId());
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
                thongTinNguoiMua.setTenKhachHang(quanLyBanHang.getTenKhachHang());
                thongTinNguoiMua.setId(quanLyBanHang.getIdKhachHang());
                thongTinNguoiMua.setSoDienThoai(quanLyBanHang.getSoDienThoaiKhachHang());
                thongTinNguoiMua.setFlag(quanLyBanHang.getFlag());
                thongTinNguoiMua.setNgayTaoBanGhi(quanLyBanHang.getNgayTaoBanGhi());
                thongTinNguoiMua.setNgayChinhSua(quanLyBanHang.getNgayChinhSua());

                // Sản phẩm
                List arr = new ArrayList();
                for (int i = 0; i <sanPhamRepository.findBySanPham(quanLyBanHang.getId()).size() ; i++) {
                    ThuocDaMuaDTO thuocDaMuaDTO = new ThuocDaMuaDTO();

                    thuocDaMuaDTO.setSoLuongMua(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getSoLuongMua());
                    KhoThuoc khoThuocItem = quanLyKhoThuocService.findById(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getKhoThuoc().getId());
                    thuocDaMuaDTO.setTenThuoc(khoThuocItem.getTenThuoc());
                    thuocDaMuaDTO.setId(sanPhamRepository.findBySanPham(quanLyBanHang.getId()).get(i).getId());
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

                quanLyBanHangDTO.setThongTinNguoiBan(thongTinNguoiBan);
                quanLyBanHangDTO.setSanPham(arr);
                quanLyBanHangDTO.setThongTinNguoiMua(thongTinNguoiMua);
                quanLyBanHangDTOS.add(quanLyBanHangDTO);

            }
            result.put("result", quanLyBanHangDTOS);
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
    public QuanLyBanHang findById(Long id) {
        return quanLyBanHangRepository.findById(id).orElse(null);
    }

    @Override
    public List<SanPham> getAllSanPhamById(Long id) {
        List<SanPham> sanPham = sanPhamRepository.findBySanPham(id);
        System.out.println(sanPham);
        return sanPham;
    }
}
