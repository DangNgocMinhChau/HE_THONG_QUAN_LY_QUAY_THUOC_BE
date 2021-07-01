package com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;

import javax.persistence.*;
import java.util.Set;

@Entity
public class HoaDonGTGT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoTenNguoiMua;
    private String tenDonVi;
    private String maSoThue;
    private String diaChi;
    private String thanhToan;
    private String soTK;
    private String mauSo;
    private String kyHieu;
    private String so;
    private String phanTramThue;
    private Double congTienHang;
    private Double tienThueGTGT;
    private Double tongTienThanhToan;
    private String soTienVietBangChu;
    private String kyBoi;
    private String ngayKy;
    private String ngayHoaDon;
    private Boolean flag;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;

    @OneToMany(mappedBy = "hoaDonGTGT")
    private Set<HangHoaTrongHoaDonGTGT> hangHoaTrongHoaDonGTGTS;

    public HoaDonGTGT() {
    }

    public String getHoTenNguoiMua() {
        return hoTenNguoiMua;
    }

    public void setHoTenNguoiMua(String hoTenNguoiMua) {
        this.hoTenNguoiMua = hoTenNguoiMua;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getMauSo() {
        return mauSo;
    }

    public void setMauSo(String mauSo) {
        this.mauSo = mauSo;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getPhanTramThue() {
        return phanTramThue;
    }

    public void setPhanTramThue(String phanTramThue) {
        this.phanTramThue = phanTramThue;
    }

    public Double getCongTienHang() {
        return congTienHang;
    }

    public void setCongTienHang(Double congTienHang) {
        this.congTienHang = congTienHang;
    }

    public Double getTienThueGTGT() {
        return tienThueGTGT;
    }

    public void setTienThueGTGT(Double tienThueGTGT) {
        this.tienThueGTGT = tienThueGTGT;
    }

    public Double getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(Double tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getSoTienVietBangChu() {
        return soTienVietBangChu;
    }

    public void setSoTienVietBangChu(String soTienVietBangChu) {
        this.soTienVietBangChu = soTienVietBangChu;
    }

    public String getKyBoi() {
        return kyBoi;
    }

    public void setKyBoi(String kyBoi) {
        this.kyBoi = kyBoi;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(String ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }

    public Set<HangHoaTrongHoaDonGTGT> getHangHoaTrongHoaDonGTGTS() {
        return hangHoaTrongHoaDonGTGTS;
    }

    public void setHangHoaTrongHoaDonGTGTS(Set<HangHoaTrongHoaDonGTGT> hangHoaTrongHoaDonGTGTS) {
        this.hangHoaTrongHoaDonGTGTS = hangHoaTrongHoaDonGTGTS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Long getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(Long nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public String getNgayTaoBanGhi() {
        return ngayTaoBanGhi;
    }

    public void setNgayTaoBanGhi(String ngayTaoBanGhi) {
        this.ngayTaoBanGhi = ngayTaoBanGhi;
    }

    public String getNgayChinhSua() {
        return ngayChinhSua;
    }

    public void setNgayChinhSua(String ngayChinhSua) {
        this.ngayChinhSua = ngayChinhSua;
    }
}
