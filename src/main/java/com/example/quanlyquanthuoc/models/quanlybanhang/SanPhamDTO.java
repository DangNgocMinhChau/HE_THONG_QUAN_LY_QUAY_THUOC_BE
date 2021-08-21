package com.example.quanlyquanthuoc.models.quanlybanhang;


import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;

public class SanPhamDTO {
    private Long id;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private QuanLyBanHang quanLyBanHang;
    private KhoThuoc khoThuoc;
    private Long soLuongMua;
    private Long khoThuocId;
    private Long quanLyBanHangId;
    private KhoThuoc sanPham;
    private String tenKhachHang;
    private String soDienThoaiKhachHang;
    private Long idKhachHang;
    private String tenThuoc;
    private String donViTinh;
    private Double tongTienTruocThue;
    private Double phanTramThue;
    private Double chietKhau;
    private Double giaTien;
    private String thanhToan;
    private Long soLuongNhap;
    private String ngayNhapThuoc;
    private Long soLuongDaBan;


    public SanPhamDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public QuanLyBanHang getQuanLyBanHang() {
        return quanLyBanHang;
    }

    public void setQuanLyBanHang(QuanLyBanHang quanLyBanHang) {
        this.quanLyBanHang = quanLyBanHang;
    }

    public KhoThuoc getKhoThuoc() {
        return khoThuoc;
    }

    public void setKhoThuoc(KhoThuoc khoThuoc) {
        this.khoThuoc = khoThuoc;
    }


    public Long getQuanLyBanHangId() {
        return quanLyBanHangId;
    }

    public void setQuanLyBanHangId(Long quanLyBanHangId) {
        this.quanLyBanHangId = quanLyBanHangId;
    }

    public Long getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Long soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public Long getKhoThuocId() {
        return khoThuocId;
    }

    public void setKhoThuocId(Long khoThuocId) {
        this.khoThuocId = khoThuocId;
    }

    public KhoThuoc getSanPham() {
        return sanPham;
    }

    public void setSanPham(KhoThuoc sanPham) {
        this.sanPham = sanPham;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoaiKhachHang() {
        return soDienThoaiKhachHang;
    }

    public void setSoDienThoaiKhachHang(String soDienThoaiKhachHang) {
        this.soDienThoaiKhachHang = soDienThoaiKhachHang;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Double getTongTienTruocThue() {
        return tongTienTruocThue;
    }

    public void setTongTienTruocThue(Double tongTienTruocThue) {
        this.tongTienTruocThue = tongTienTruocThue;
    }

    public Double getPhanTramThue() {
        return phanTramThue;
    }

    public void setPhanTramThue(Double phanTramThue) {
        this.phanTramThue = phanTramThue;
    }

    public Double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(Double chietKhau) {
        this.chietKhau = chietKhau;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public Long getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(Long soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public String getNgayNhapThuoc() {
        return ngayNhapThuoc;
    }

    public void setNgayNhapThuoc(String ngayNhapThuoc) {
        this.ngayNhapThuoc = ngayNhapThuoc;
    }

    public Long getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(Long soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }
}
