package com.example.quanlyquanthuoc.models.quanlybanhang;

import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquanthuoc.models.quanlythongtinkhachhang.QuanLyThongTinKhachHang;

import java.util.List;

public class QuanLyBanHangDTO {
    private Long id;
    private List sanPham;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private String tenKhachHang;
    private String soDienThoaiKhachHang;
    private Long nguoiTaoId;
    private Long idKhachHang;
    private String itemSanPham;
    private SanPham sanPhamitem;
    private QuanLyThongTinKhachHang thongTinNguoiMua;
    private QuanLyTaiKhoan thongTinNguoiBan;
    private Double totalTien;
    private Double tienNhan;
    private Boolean checkEdit;
    private String noiDungChinhSua;
    private Long idHoaDonDuocSua;
    private Integer tongCongLichSuHoaDon;

    public QuanLyBanHangDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List getSanPham() {
        return sanPham;
    }

    public void setSanPham(List sanPham) {
        this.sanPham = sanPham;
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

    public Long getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(Long nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getItemSanPham() {
        return itemSanPham;
    }

    public void setItemSanPham(String itemSanPham) {
        this.itemSanPham = itemSanPham;
    }

    public SanPham getSanPhamitem() {
        return sanPhamitem;
    }

    public void setSanPhamitem(SanPham sanPhamitem) {
        this.sanPhamitem = sanPhamitem;
    }

    public QuanLyThongTinKhachHang getThongTinNguoiMua() {
        return thongTinNguoiMua;
    }

    public void setThongTinNguoiMua(QuanLyThongTinKhachHang thongTinNguoiMua) {
        this.thongTinNguoiMua = thongTinNguoiMua;
    }

    public QuanLyTaiKhoan getThongTinNguoiBan() {
        return thongTinNguoiBan;
    }

    public void setThongTinNguoiBan(QuanLyTaiKhoan thongTinNguoiBan) {
        this.thongTinNguoiBan = thongTinNguoiBan;
    }

    public Double getTotalTien() {
        return totalTien;
    }

    public void setTotalTien(Double totalTien) {
        this.totalTien = totalTien;
    }

    public Double getTienNhan() {
        return tienNhan;
    }

    public void setTienNhan(Double tienNhan) {
        this.tienNhan = tienNhan;
    }

    public Boolean getCheckEdit() {
        return checkEdit;
    }

    public void setCheckEdit(Boolean checkEdit) {
        this.checkEdit = checkEdit;
    }

    public String getNoiDungChinhSua() {
        return noiDungChinhSua;
    }

    public void setNoiDungChinhSua(String noiDungChinhSua) {
        this.noiDungChinhSua = noiDungChinhSua;
    }

    public Long getIdHoaDonDuocSua() {
        return idHoaDonDuocSua;
    }

    public void setIdHoaDonDuocSua(Long idHoaDonDuocSua) {
        this.idHoaDonDuocSua = idHoaDonDuocSua;
    }

    public Integer getTongCongLichSuHoaDon() {
        return tongCongLichSuHoaDon;
    }

    public void setTongCongLichSuHoaDon(Integer tongCongLichSuHoaDon) {
        this.tongCongLichSuHoaDon = tongCongLichSuHoaDon;
    }
}
