package com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT_DTO;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGT;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGTDTO;
import com.example.quanlyquanthuoc.repositorys.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGTRepository;
import com.example.quanlyquanthuoc.repositorys.quanlyhoadon.hoadonGTGT.HoaDonGTGTRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HoaDonGTGTServiceImpl implements HoaDonGTGTService {

    @Autowired
    HoaDonGTGTRepository hoaDonGTGTRepository;

    @Autowired
    HangHoaTrongHoaDonGTGTService hangHoaTrongHoaDonGTGTService;

    @Autowired
    HangHoaTrongHoaDonGTGTRepository hangHoaTrongHoaDonGTGTRepository;

    @Override
    public Map<String, Object> create(HoaDonGTGTDTO hoaDonGTGTDTO) {
        Map<String, Object> result = new HashMap<>();
        try {
            HoaDonGTGT hoaDonGTGT = new HoaDonGTGT();
            hoaDonGTGT.setHoTenNguoiMua(hoaDonGTGTDTO.getHoTenNguoiMua());
            hoaDonGTGT.setTenDonVi(hoaDonGTGTDTO.getTenDonVi());
            hoaDonGTGT.setMaSoThue(hoaDonGTGTDTO.getMaSoThue());
            hoaDonGTGT.setDiaChi(hoaDonGTGTDTO.getDiaChi());
            hoaDonGTGT.setThanhToan(hoaDonGTGTDTO.getThanhToan());
            hoaDonGTGT.setSoTK(hoaDonGTGTDTO.getSoTK());
            hoaDonGTGT.setMauSo(hoaDonGTGTDTO.getMauSo());
            hoaDonGTGT.setKyHieu(hoaDonGTGTDTO.getKyHieu());
            hoaDonGTGT.setSo(hoaDonGTGTDTO.getSo());
            hoaDonGTGT.setPhanTramThue(hoaDonGTGTDTO.getPhanTramThue());
            hoaDonGTGT.setCongTienHang(hoaDonGTGTDTO.getCongTienHang());
            hoaDonGTGT.setTienThueGTGT(hoaDonGTGTDTO.getTienThueGTGT());
            hoaDonGTGT.setTongTienThanhToan(hoaDonGTGTDTO.getTongTienThanhToan());
            hoaDonGTGT.setSoTienVietBangChu(hoaDonGTGTDTO.getSoTienVietBangChu());
            hoaDonGTGT.setKyBoi(hoaDonGTGTDTO.getKyBoi());
            hoaDonGTGT.setNgayKy(hoaDonGTGTDTO.getNgayKy());
            hoaDonGTGT.setNgayHoaDon(hoaDonGTGTDTO.getNgayHoaDon());
            hoaDonGTGT.setNguoiTaoId(hoaDonGTGTDTO.getNguoiTaoId());
            hoaDonGTGT.setNgayTaoBanGhi(hoaDonGTGTDTO.getNgayTaoBanGhi());
            hoaDonGTGT.setFlag(true);

            hoaDonGTGTRepository.save(hoaDonGTGT);

            ObjectMapper mapper = new ObjectMapper();
            HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
            for (int i = 0; i < hoaDonGTGTDTO.getHangHoa().size(); i++) {
                String jsonString = mapper.writeValueAsString(hoaDonGTGTDTO.getHangHoa().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String tenHangHoa = jsonObject.get("tenHangHoa").toString();
                String soLo = jsonObject.get("soLo").toString();
                String hanDung = jsonObject.get("hanDung").toString();
                String donviTinh = jsonObject.get("donviTinh").toString();
                String thanhTien = jsonObject.get("thanhTien").toString();
                String soLuong = jsonObject.get("soLuong").toString();
                String donGia = jsonObject.get("donGia").toString();


                hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(tenHangHoa);
                hangHoaTrongHoaDonGTGT_dto.setDonViTinh(donviTinh);
                hangHoaTrongHoaDonGTGT_dto.setHanDung(hanDung);
                hangHoaTrongHoaDonGTGT_dto.setDonGia(Double.parseDouble(donGia));
                hangHoaTrongHoaDonGTGT_dto.setThanhTien(Double.parseDouble(thanhTien));
                hangHoaTrongHoaDonGTGT_dto.setSoLo(soLo);
                hangHoaTrongHoaDonGTGT_dto.setSoLuong(Long.parseLong(soLuong));
                hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hoaDonGTGTDTO.getNgayTaoBanGhi());
                hangHoaTrongHoaDonGTGT_dto.setHoaDonGTGTId(hoaDonGTGT.getId());
                hangHoaTrongHoaDonGTGT_dto.setFlag(true);


                hangHoaTrongHoaDonGTGTService.create(hangHoaTrongHoaDonGTGT_dto);
            }

            result.put("result", hoaDonGTGT);
            result.put("msg", "Thêm mói thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }


    @Override
    public Map<String, Object> update(Long id, HoaDonGTGTDTO hoaDonGTGTDTO) {
        Map<String, Object> result = new HashMap<>();
        HoaDonGTGTDTO resultUpdate = new HoaDonGTGTDTO();
        try {
            HoaDonGTGT object = hoaDonGTGTRepository.findById(id).get();
            object.setTenDonVi(hoaDonGTGTDTO.getTenDonVi());
            object.setMaSoThue(hoaDonGTGTDTO.getMaSoThue());
            object.setHoTenNguoiMua(hoaDonGTGTDTO.getHoTenNguoiMua());
            object.setDiaChi(hoaDonGTGTDTO.getDiaChi());
            object.setThanhToan(hoaDonGTGTDTO.getThanhToan());
            object.setSoTK(hoaDonGTGTDTO.getSoTK());
            object.setMauSo(hoaDonGTGTDTO.getMauSo());
            object.setKyHieu(hoaDonGTGTDTO.getKyHieu());
            object.setSo(hoaDonGTGTDTO.getSo());
            object.setPhanTramThue(hoaDonGTGTDTO.getPhanTramThue());
            object.setCongTienHang(hoaDonGTGTDTO.getCongTienHang());
            object.setTienThueGTGT(hoaDonGTGTDTO.getTienThueGTGT());
            object.setTongTienThanhToan(hoaDonGTGTDTO.getTongTienThanhToan());
            object.setSoTienVietBangChu(hoaDonGTGTDTO.getSoTienVietBangChu());
            object.setKyBoi(hoaDonGTGTDTO.getKyBoi());
            object.setNgayKy(hoaDonGTGTDTO.getNgayKy());
            object.setNgayHoaDon(hoaDonGTGTDTO.getNgayHoaDon());
            object.setNgayChinhSua(hoaDonGTGTDTO.getNgayChinhSua());

            ObjectMapper mapper = new ObjectMapper();
            HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
            List idHangHoaDangCo = new ArrayList();
            for (int i = 0; i < hoaDonGTGTDTO.getHangHoa().size(); i++) {
                String jsonString = mapper.writeValueAsString(hoaDonGTGTDTO.getHangHoa().get(i));
                JSONObject jsonObject = new JSONObject(jsonString);
                String tenHangHoa = jsonObject.get("tenHangHoa").toString();
                String soLo = jsonObject.get("soLo").toString();
                String hanDung = jsonObject.get("hanDung").toString();
                String donViTinh = jsonObject.get("donViTinh").toString();
                String thanhTien = jsonObject.get("thanhTien").toString();
                String soLuong = jsonObject.get("soLuong").toString();
                String donGia = jsonObject.get("donGia").toString();
                String idHangHoa = jsonObject.get("id").toString();


                if (!idHangHoa.equals("null")) {
                    idHangHoaDangCo.add(Long.parseLong(idHangHoa));
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(tenHangHoa);
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(donViTinh);
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hanDung);
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(Double.parseDouble(donGia));
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(Double.parseDouble(thanhTien));
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(soLo);
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(Long.parseLong(soLuong));
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hoaDonGTGTDTO.getNgayTaoBanGhi());
                    hangHoaTrongHoaDonGTGT_dto.setHoaDonGTGTId(hoaDonGTGTDTO.getId());
                    hangHoaTrongHoaDonGTGT_dto.setFlag(true);
                    hangHoaTrongHoaDonGTGTService.update(Long.parseLong(idHangHoa), hangHoaTrongHoaDonGTGT_dto);

                } else {
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(tenHangHoa);
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(donViTinh);
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hanDung);
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(Double.parseDouble(donGia));
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(Double.parseDouble(thanhTien));
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(soLo);
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(Long.parseLong(soLuong));
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hoaDonGTGTDTO.getNgayTaoBanGhi());
                    hangHoaTrongHoaDonGTGT_dto.setFlag(true);
                    hangHoaTrongHoaDonGTGT_dto.setHoaDonGTGTId(hoaDonGTGTDTO.getId());
                    hangHoaTrongHoaDonGTGTService.create(hangHoaTrongHoaDonGTGT_dto);
                }
            }

            List arrHangHoa = new ArrayList();
            for (int i = 0; i < hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGTDTO.getId()).size(); i++) {
                HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDon = new HangHoaTrongHoaDonGTGT_DTO();
                HangHoaTrongHoaDonGTGT hangHoaItem = hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGTDTO.getId()).get(i);
                hangHoaTrongHoaDon.setId(hangHoaItem.getId());
                hangHoaTrongHoaDon.setTenHangHoa(hangHoaItem.getTenHangHoa());
                hangHoaTrongHoaDon.setDonViTinh(hangHoaItem.getDonViTinh());
                hangHoaTrongHoaDon.setHanDung(hangHoaItem.getHanDung());
                hangHoaTrongHoaDon.setSoLuong(hangHoaItem.getSoLuong());
                hangHoaTrongHoaDon.setSoLo(hangHoaItem.getSoLo());
                hangHoaTrongHoaDon.setDonGia(hangHoaItem.getDonGia());
                hangHoaTrongHoaDon.setThanhTien(hangHoaItem.getThanhTien());
                hangHoaTrongHoaDon.setNguoiTaoId(hangHoaItem.getNguoiTaoId());
                hangHoaTrongHoaDon.setNgayTaoBanGhi(hangHoaItem.getNgayTaoBanGhi());

                arrHangHoa.add(hangHoaTrongHoaDon);
            }
            resultUpdate.setHangHoa(arrHangHoa);
            resultUpdate.setHoTenNguoiMua(hoaDonGTGTDTO.getHoTenNguoiMua());
            resultUpdate.setTenDonVi(hoaDonGTGTDTO.getTenDonVi());
            resultUpdate.setMaSoThue(hoaDonGTGTDTO.getMaSoThue());
            resultUpdate.setDiaChi(hoaDonGTGTDTO.getDiaChi());
            resultUpdate.setThanhToan(hoaDonGTGTDTO.getThanhToan());
            resultUpdate.setSoTK(hoaDonGTGTDTO.getSoTK());
            resultUpdate.setMauSo(hoaDonGTGTDTO.getMauSo());
            resultUpdate.setKyHieu(hoaDonGTGTDTO.getKyHieu());
            resultUpdate.setSo(hoaDonGTGTDTO.getSo());
            resultUpdate.setPhanTramThue(hoaDonGTGTDTO.getPhanTramThue());
            resultUpdate.setCongTienHang(hoaDonGTGTDTO.getCongTienHang());
            resultUpdate.setTienThueGTGT(hoaDonGTGTDTO.getTienThueGTGT());
            resultUpdate.setTongTienThanhToan(hoaDonGTGTDTO.getTongTienThanhToan());
            resultUpdate.setSoTienVietBangChu(hoaDonGTGTDTO.getSoTienVietBangChu());
            resultUpdate.setKyBoi(hoaDonGTGTDTO.getKyBoi());
            resultUpdate.setNgayKy(hoaDonGTGTDTO.getNgayKy());
            resultUpdate.setNgayHoaDon(hoaDonGTGTDTO.getNgayHoaDon());
            resultUpdate.setNguoiTaoId(hoaDonGTGTRepository.findById(id).get().getNguoiTaoId());
            resultUpdate.setId(id);
            resultUpdate.setFlag(true);
            result.put("result", resultUpdate);
            result.put("msg", "sửa thành công");
            result.put("status", true);

            }catch (Exception e) {
            result.put("msg", "Sửa thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        HoaDonGTGT hoaDonGTGT = hoaDonGTGTRepository.findById(id).orElse(null);
        HoaDonGTGTDTO hoaDonGTGTDTO = new HoaDonGTGTDTO();
        try{
            if(hoaDonGTGT != null){
                hoaDonGTGTDTO.setId(hoaDonGTGT.getId());
                hoaDonGTGTDTO.setHoTenNguoiMua(hoaDonGTGT.getHoTenNguoiMua());
                hoaDonGTGTDTO.setTenDonVi(hoaDonGTGT.getTenDonVi());
                hoaDonGTGTDTO.setMaSoThue(hoaDonGTGT.getMaSoThue());
                hoaDonGTGTDTO.setDiaChi(hoaDonGTGT.getDiaChi());
                hoaDonGTGTDTO.setThanhToan(hoaDonGTGT.getThanhToan());
                hoaDonGTGTDTO.setSoTK(hoaDonGTGT.getSoTK());
                hoaDonGTGTDTO.setMauSo(hoaDonGTGT.getMauSo());
                hoaDonGTGTDTO.setKyHieu(hoaDonGTGT.getKyHieu());
                hoaDonGTGTDTO.setSo(hoaDonGTGT.getSo());
                hoaDonGTGTDTO.setPhanTramThue(hoaDonGTGT.getPhanTramThue());
                hoaDonGTGTDTO.setCongTienHang(hoaDonGTGT.getCongTienHang());
                hoaDonGTGTDTO.setTienThueGTGT(hoaDonGTGT.getTienThueGTGT());
                hoaDonGTGTDTO.setTongTienThanhToan(hoaDonGTGT.getTongTienThanhToan());
                hoaDonGTGTDTO.setSoTienVietBangChu(hoaDonGTGT.getSoTienVietBangChu());
                hoaDonGTGTDTO.setKyBoi(hoaDonGTGT.getKyBoi());
                hoaDonGTGTDTO.setNgayKy(hoaDonGTGT.getNgayKy());
                hoaDonGTGTDTO.setNgayHoaDon(hoaDonGTGT.getNgayHoaDon());
                hoaDonGTGTDTO.setNguoiTaoId(hoaDonGTGT.getNguoiTaoId());
                hoaDonGTGTDTO.setNgayTaoBanGhi(hoaDonGTGT.getNgayTaoBanGhi());

                List arrHangHoa = new ArrayList();
                for (int i = 0; i < hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).size(); i++) {
                    HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
                    HangHoaTrongHoaDonGTGT hangHoaItem = hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).get(i);
                    hangHoaTrongHoaDonGTGT_dto.setId(hangHoaItem.getId());
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(hangHoaItem.getTenHangHoa());
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(hangHoaItem.getDonViTinh());
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hangHoaItem.getHanDung());
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(hangHoaItem.getSoLuong());
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(hangHoaItem.getSoLo());
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(hangHoaItem.getDonGia());
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(hangHoaItem.getThanhTien());
                    hangHoaTrongHoaDonGTGT_dto.setNguoiTaoId(hangHoaItem.getNguoiTaoId());
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hangHoaItem.getNgayTaoBanGhi());

                    arrHangHoa.add(hangHoaTrongHoaDonGTGT_dto);
                }
                hoaDonGTGTDTO.setHangHoa(arrHangHoa);
            }
            result.put("result", hoaDonGTGTDTO);
            result.put("status", true);
        }catch (Exception e){
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<HoaDonGTGT> hoaDonGTGTList = hoaDonGTGTRepository.findAll();
            List<HoaDonGTGTDTO> hoaDonGTGTDTOS = new ArrayList<>();

            for (HoaDonGTGT hoaDonGTGT : hoaDonGTGTList) {
                HoaDonGTGTDTO hoaDonGTGTDTO = new HoaDonGTGTDTO();
                hoaDonGTGTDTO.setId(hoaDonGTGT.getId());
                hoaDonGTGTDTO.setHoTenNguoiMua(hoaDonGTGT.getHoTenNguoiMua());
                hoaDonGTGTDTO.setTenDonVi(hoaDonGTGT.getTenDonVi());
                hoaDonGTGTDTO.setMaSoThue(hoaDonGTGT.getMaSoThue());
                hoaDonGTGTDTO.setDiaChi(hoaDonGTGT.getDiaChi());
                hoaDonGTGTDTO.setThanhToan(hoaDonGTGT.getThanhToan());
                hoaDonGTGTDTO.setSoTK(hoaDonGTGT.getSoTK());
                hoaDonGTGTDTO.setMauSo(hoaDonGTGT.getMauSo());
                hoaDonGTGTDTO.setKyHieu(hoaDonGTGT.getKyHieu());
                hoaDonGTGTDTO.setSo(hoaDonGTGT.getSo());
                hoaDonGTGTDTO.setPhanTramThue(hoaDonGTGT.getPhanTramThue());
                hoaDonGTGTDTO.setCongTienHang(hoaDonGTGT.getCongTienHang());
                hoaDonGTGTDTO.setTienThueGTGT(hoaDonGTGT.getTienThueGTGT());
                hoaDonGTGTDTO.setTongTienThanhToan(hoaDonGTGT.getTongTienThanhToan());
                hoaDonGTGTDTO.setSoTienVietBangChu(hoaDonGTGT.getSoTienVietBangChu());
                hoaDonGTGTDTO.setKyBoi(hoaDonGTGT.getKyBoi());
                hoaDonGTGTDTO.setNgayKy(hoaDonGTGT.getNgayKy());
                hoaDonGTGTDTO.setNgayHoaDon(hoaDonGTGT.getNgayHoaDon());
                hoaDonGTGTDTO.setNguoiTaoId(hoaDonGTGT.getNguoiTaoId());
                hoaDonGTGTDTO.setNgayTaoBanGhi(hoaDonGTGT.getNgayTaoBanGhi());

                // Hàng hóa

                List arrHangHoa = new ArrayList();
                for (int i = 0; i < hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).size(); i++) {
                    HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
                    HangHoaTrongHoaDonGTGT hangHoaItem = hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).get(i);
                    hangHoaTrongHoaDonGTGT_dto.setId(hangHoaItem.getId());
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(hangHoaItem.getTenHangHoa());
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(hangHoaItem.getDonViTinh());
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hangHoaItem.getHanDung());
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(hangHoaItem.getSoLuong());
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(hangHoaItem.getSoLo());
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(hangHoaItem.getDonGia());
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(hangHoaItem.getThanhTien());
                    hangHoaTrongHoaDonGTGT_dto.setNguoiTaoId(hangHoaItem.getNguoiTaoId());
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hangHoaItem.getNgayTaoBanGhi());

                    arrHangHoa.add(hangHoaTrongHoaDonGTGT_dto);
                }
                hoaDonGTGTDTO.setHangHoa(arrHangHoa);
                hoaDonGTGTDTOS.add(hoaDonGTGTDTO);

            }
            result.put("result", hoaDonGTGTDTOS);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAllHoaDonGTGTDaXoa() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<HoaDonGTGT> hoaDonGTGTList = hoaDonGTGTRepository.findAllHoaDonGTGTByFlagFalse();
            List<HoaDonGTGTDTO> hoaDonGTGTDTOS = new ArrayList<>();

            for (HoaDonGTGT hoaDonGTGT : hoaDonGTGTList) {
                HoaDonGTGTDTO hoaDonGTGTDTO = new HoaDonGTGTDTO();
                hoaDonGTGTDTO.setId(hoaDonGTGT.getId());
                hoaDonGTGTDTO.setHoTenNguoiMua(hoaDonGTGT.getHoTenNguoiMua());
                hoaDonGTGTDTO.setTenDonVi(hoaDonGTGT.getTenDonVi());
                hoaDonGTGTDTO.setMaSoThue(hoaDonGTGT.getMaSoThue());
                hoaDonGTGTDTO.setDiaChi(hoaDonGTGT.getDiaChi());
                hoaDonGTGTDTO.setThanhToan(hoaDonGTGT.getThanhToan());
                hoaDonGTGTDTO.setSoTK(hoaDonGTGT.getSoTK());
                hoaDonGTGTDTO.setMauSo(hoaDonGTGT.getMauSo());
                hoaDonGTGTDTO.setKyHieu(hoaDonGTGT.getKyHieu());
                hoaDonGTGTDTO.setSo(hoaDonGTGT.getSo());
                hoaDonGTGTDTO.setPhanTramThue(hoaDonGTGT.getPhanTramThue());
                hoaDonGTGTDTO.setCongTienHang(hoaDonGTGT.getCongTienHang());
                hoaDonGTGTDTO.setTienThueGTGT(hoaDonGTGT.getTienThueGTGT());
                hoaDonGTGTDTO.setTongTienThanhToan(hoaDonGTGT.getTongTienThanhToan());
                hoaDonGTGTDTO.setSoTienVietBangChu(hoaDonGTGT.getSoTienVietBangChu());
                hoaDonGTGTDTO.setKyBoi(hoaDonGTGT.getKyBoi());
                hoaDonGTGTDTO.setNgayKy(hoaDonGTGT.getNgayKy());
                hoaDonGTGTDTO.setNgayHoaDon(hoaDonGTGT.getNgayHoaDon());
                hoaDonGTGTDTO.setNguoiTaoId(hoaDonGTGT.getNguoiTaoId());
                hoaDonGTGTDTO.setNgayTaoBanGhi(hoaDonGTGT.getNgayTaoBanGhi());

                // Hàng hóa

                List arrHangHoa = new ArrayList();
                for (int i = 0; i < hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).size(); i++) {
                    HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
                    HangHoaTrongHoaDonGTGT hangHoaItem = hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).get(i);
                    hangHoaTrongHoaDonGTGT_dto.setId(hangHoaItem.getId());
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(hangHoaItem.getTenHangHoa());
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(hangHoaItem.getDonViTinh());
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hangHoaItem.getHanDung());
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(hangHoaItem.getSoLuong());
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(hangHoaItem.getSoLo());
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(hangHoaItem.getDonGia());
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(hangHoaItem.getThanhTien());
                    hangHoaTrongHoaDonGTGT_dto.setNguoiTaoId(hangHoaItem.getNguoiTaoId());
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hangHoaItem.getNgayTaoBanGhi());

                    arrHangHoa.add(hangHoaTrongHoaDonGTGT_dto);
                }
                hoaDonGTGTDTO.setHangHoa(arrHangHoa);
                hoaDonGTGTDTOS.add(hoaDonGTGTDTO);

            }
            result.put("result", hoaDonGTGTDTOS);
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
    public Map<String, Object> deleteHoaDonGTGT(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            HoaDonGTGT hoaDonGTGT = hoaDonGTGTRepository.findById(id).orElse(null);
                hoaDonGTGT.setFlag(false);
                hoaDonGTGTRepository.save(hoaDonGTGT);
            result.put("result", "Xoá thành công hoá đơn");
            result.put("status", true);
        }catch (Exception e) {
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> phucHoiHoaDonGTGTDaXoa(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            HoaDonGTGT hoaDonGTGT = hoaDonGTGTRepository.findById(id).orElse(null);
            hoaDonGTGT.setFlag(true);
            hoaDonGTGTRepository.save(hoaDonGTGT);
            result.put("result", "Phục hồi hóa đơn thành công");
            result.put("status", true);
        }catch (Exception e) {
            result.put("msg", "Phục hồi hóa đơn thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public HoaDonGTGT findById(Long id) {
        return hoaDonGTGTRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> getAllHoaDonGTGTByDate(String date) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<HoaDonGTGT> hoaDonGTGTList = hoaDonGTGTRepository.findAllHoaDonGTGTByTheoDate(date);
            List<HoaDonGTGTDTO> hoaDonGTGTDTOS = new ArrayList<>();
            for (HoaDonGTGT hoaDonGTGT : hoaDonGTGTList) {
                HoaDonGTGTDTO hoaDonGTGTDTO = new HoaDonGTGTDTO();
                hoaDonGTGTDTO.setId(hoaDonGTGT.getId());
                hoaDonGTGTDTO.setHoTenNguoiMua(hoaDonGTGT.getHoTenNguoiMua());
                hoaDonGTGTDTO.setTenDonVi(hoaDonGTGT.getTenDonVi());
                hoaDonGTGTDTO.setMaSoThue(hoaDonGTGT.getMaSoThue());
                hoaDonGTGTDTO.setDiaChi(hoaDonGTGT.getDiaChi());
                hoaDonGTGTDTO.setThanhToan(hoaDonGTGT.getThanhToan());
                hoaDonGTGTDTO.setSoTK(hoaDonGTGT.getSoTK());
                hoaDonGTGTDTO.setMauSo(hoaDonGTGT.getMauSo());
                hoaDonGTGTDTO.setKyHieu(hoaDonGTGT.getKyHieu());
                hoaDonGTGTDTO.setSo(hoaDonGTGT.getSo());
                hoaDonGTGTDTO.setPhanTramThue(hoaDonGTGT.getPhanTramThue());
                hoaDonGTGTDTO.setCongTienHang(hoaDonGTGT.getCongTienHang());
                hoaDonGTGTDTO.setTienThueGTGT(hoaDonGTGT.getTienThueGTGT());
                hoaDonGTGTDTO.setTongTienThanhToan(hoaDonGTGT.getTongTienThanhToan());
                hoaDonGTGTDTO.setSoTienVietBangChu(hoaDonGTGT.getSoTienVietBangChu());
                hoaDonGTGTDTO.setKyBoi(hoaDonGTGT.getKyBoi());
                hoaDonGTGTDTO.setNgayKy(hoaDonGTGT.getNgayKy());
                hoaDonGTGTDTO.setNgayHoaDon(hoaDonGTGT.getNgayHoaDon());
                hoaDonGTGTDTO.setNguoiTaoId(hoaDonGTGT.getNguoiTaoId());
                hoaDonGTGTDTO.setNgayTaoBanGhi(hoaDonGTGT.getNgayTaoBanGhi());

                List arrHangHoa = new ArrayList();
                for (int i = 0; i < hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).size(); i++) {
                    HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
                    HangHoaTrongHoaDonGTGT hangHoaItem = hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(hoaDonGTGT.getId()).get(i);
                    hangHoaTrongHoaDonGTGT_dto.setId(hangHoaItem.getId());
                    hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(hangHoaItem.getTenHangHoa());
                    hangHoaTrongHoaDonGTGT_dto.setDonViTinh(hangHoaItem.getDonViTinh());
                    hangHoaTrongHoaDonGTGT_dto.setHanDung(hangHoaItem.getHanDung());
                    hangHoaTrongHoaDonGTGT_dto.setSoLuong(hangHoaItem.getSoLuong());
                    hangHoaTrongHoaDonGTGT_dto.setSoLo(hangHoaItem.getSoLo());
                    hangHoaTrongHoaDonGTGT_dto.setDonGia(hangHoaItem.getDonGia());
                    hangHoaTrongHoaDonGTGT_dto.setThanhTien(hangHoaItem.getThanhTien());
                    hangHoaTrongHoaDonGTGT_dto.setNguoiTaoId(hangHoaItem.getNguoiTaoId());
                    hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hangHoaItem.getNgayTaoBanGhi());

                    arrHangHoa.add(hangHoaTrongHoaDonGTGT_dto);
                }
                hoaDonGTGTDTOS.add(hoaDonGTGTDTO);
                hoaDonGTGTDTO.setHangHoa(arrHangHoa);
            }
            result.put("result", hoaDonGTGTDTOS);
            result.put("status", true);

        }catch (Exception e){
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }

        return result;
    }
}
