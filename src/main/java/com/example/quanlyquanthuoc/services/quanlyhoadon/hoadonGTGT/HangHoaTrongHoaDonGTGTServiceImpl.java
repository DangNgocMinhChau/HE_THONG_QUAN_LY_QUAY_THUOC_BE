package com.example.quanlyquanthuoc.services.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlybanhang.QuanLyBanHang;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT;
import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT_DTO;
import com.example.quanlyquanthuoc.repositorys.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HangHoaTrongHoaDonGTGTServiceImpl implements HangHoaTrongHoaDonGTGTService {

    @Autowired
    HangHoaTrongHoaDonGTGTRepository hangHoaTrongHoaDonGTGTRepository;

    @Autowired
    HoaDonGTGTService hoaDonGTGTService;

    @Override
    public Map<String, Object> create(HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            HangHoaTrongHoaDonGTGT hangHoaTrongHoaDonGTGT = new HangHoaTrongHoaDonGTGT();
            hangHoaTrongHoaDonGTGT.setHoaDonGTGT(hoaDonGTGTService.findById(hangHoaTrongHoaDonGTGT_dto.getHoaDonGTGTId()));
            hangHoaTrongHoaDonGTGT.setFlag(hangHoaTrongHoaDonGTGT_dto.getFlag());
            hangHoaTrongHoaDonGTGT.setNgayChinhSua(hangHoaTrongHoaDonGTGT_dto.getNgayChinhSua());
            hangHoaTrongHoaDonGTGT.setNgayTaoBanGhi(hangHoaTrongHoaDonGTGT_dto.getNgayTaoBanGhi());
            hangHoaTrongHoaDonGTGT.setDonGia(hangHoaTrongHoaDonGTGT_dto.getDonGia());
            hangHoaTrongHoaDonGTGT.setDonViTinh(hangHoaTrongHoaDonGTGT_dto.getDonViTinh());
            hangHoaTrongHoaDonGTGT.setHanDung(hangHoaTrongHoaDonGTGT_dto.getHanDung());
            hangHoaTrongHoaDonGTGT.setNguoiTaoId(hangHoaTrongHoaDonGTGT_dto.getNguoiTaoId());
            hangHoaTrongHoaDonGTGT.setSoLo(hangHoaTrongHoaDonGTGT_dto.getSoLo());
            hangHoaTrongHoaDonGTGT.setTenHangHoa(hangHoaTrongHoaDonGTGT_dto.getTenHangHoa());
            hangHoaTrongHoaDonGTGT.setThanhTien(hangHoaTrongHoaDonGTGT_dto.getThanhTien());
            hangHoaTrongHoaDonGTGT.setSoLuong(hangHoaTrongHoaDonGTGT_dto.getSoLuong());

            hangHoaTrongHoaDonGTGTRepository.save(hangHoaTrongHoaDonGTGT);

        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto) {
        Map<String, Object> result = new HashMap<>();

        try {
            HangHoaTrongHoaDonGTGT object = hangHoaTrongHoaDonGTGTRepository.findById(id).get();
            object.setFlag(hangHoaTrongHoaDonGTGT_dto.getFlag());
            object.setNgayChinhSua(hangHoaTrongHoaDonGTGT_dto.getNgayChinhSua());
            object.setNgayTaoBanGhi(hangHoaTrongHoaDonGTGT_dto.getNgayTaoBanGhi());
            object.setDonGia(hangHoaTrongHoaDonGTGT_dto.getDonGia());
            object.setDonViTinh(hangHoaTrongHoaDonGTGT_dto.getDonViTinh());
            object.setHanDung(hangHoaTrongHoaDonGTGT_dto.getHanDung());
            object.setNguoiTaoId(hangHoaTrongHoaDonGTGT_dto.getNguoiTaoId());
            object.setSoLo(hangHoaTrongHoaDonGTGT_dto.getSoLo());
            object.setTenHangHoa(hangHoaTrongHoaDonGTGT_dto.getTenHangHoa());
            object.setThanhTien(hangHoaTrongHoaDonGTGT_dto.getThanhTien());
            object.setSoLuong(hangHoaTrongHoaDonGTGT_dto.getSoLuong());
            hangHoaTrongHoaDonGTGTRepository.save(object);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Map<String, Object> updateHangHoaTrongHoaDonGTGT(Long id, HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto) {
        return null;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("result", hangHoaTrongHoaDonGTGTRepository.findById(id).orElse(null));
            result.put("status",true);
        }catch (Exception e){
            result.put("status",false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        return null;
    }


    @Override
    public Map<String, Object> delete(Long[] listIds) {
        return null;
    }

    @Override
    public Map<String, Object> deleteTungHoaDon(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            hangHoaTrongHoaDonGTGTRepository.deleteById(id);
            result.put("result","Xóa thành công");
        }catch (Exception e){
            result.put("result","Xoá thất bại");
        }
        return result;
    }

    @Override
    public void deleteById(Long id) {
        try{
            hangHoaTrongHoaDonGTGTRepository.deleteById(id);
        }catch (Exception e){

        }
    }

    @Override
    public QuanLyBanHang findById(Long id) {
        hangHoaTrongHoaDonGTGTRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public List<HangHoaTrongHoaDonGTGT_DTO> getAllHangHoaByIdHoaDon(Long id) {

        return  hangHoaTrongHoaDonGTGTRepository.findByHangHoaTheoIdHoaDonGTGT(id).stream().map(this::toDto).collect(Collectors.toList());

    }

    private HangHoaTrongHoaDonGTGT_DTO toDto(HangHoaTrongHoaDonGTGT hangHoaTrongHoaDonGTGT) {
        HangHoaTrongHoaDonGTGT_DTO hangHoaTrongHoaDonGTGT_dto = new HangHoaTrongHoaDonGTGT_DTO();
        hangHoaTrongHoaDonGTGT_dto.setId(hangHoaTrongHoaDonGTGT.getId());
        hangHoaTrongHoaDonGTGT_dto.setSoLuong(hangHoaTrongHoaDonGTGT.getSoLuong());
        hangHoaTrongHoaDonGTGT_dto.setNgayChinhSua(hangHoaTrongHoaDonGTGT.getNgayChinhSua());
        hangHoaTrongHoaDonGTGT_dto.setNgayTaoBanGhi(hangHoaTrongHoaDonGTGT.getNgayTaoBanGhi());
        hangHoaTrongHoaDonGTGT_dto.setHoaDonGTGTId(hangHoaTrongHoaDonGTGT.getHoaDonGTGT().getId());
        hangHoaTrongHoaDonGTGT_dto.setSoLo(hangHoaTrongHoaDonGTGT.getSoLo());
        hangHoaTrongHoaDonGTGT_dto.setTenHangHoa(hangHoaTrongHoaDonGTGT.getTenHangHoa());
        hangHoaTrongHoaDonGTGT_dto.setDonGia(hangHoaTrongHoaDonGTGT.getDonGia());
        hangHoaTrongHoaDonGTGT_dto.setDonViTinh(hangHoaTrongHoaDonGTGT.getDonViTinh());
        hangHoaTrongHoaDonGTGT_dto.setHanDung(hangHoaTrongHoaDonGTGT.getHanDung());
        hangHoaTrongHoaDonGTGT_dto.setThanhTien(hangHoaTrongHoaDonGTGT.getThanhTien());
        hangHoaTrongHoaDonGTGT_dto.setNguoiTaoId(hangHoaTrongHoaDonGTGT.getNguoiTaoId());

        return hangHoaTrongHoaDonGTGT_dto;
    }
}
