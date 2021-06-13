package com.example.quanlyquanthuoc.models.quanlykhothuoc;


import com.example.quanlyquanthuoc.models.quanlyfiles.FileDB;
import com.example.quanlyquanthuoc.models.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.quanlytaikhoan.QuanLyTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class KhoThuocDTO {
    private Long id;
    private String tenThuoc;
    private String ma;
    private String donViTinh;
    private Double tongTienTruocThue;
    private Double phanTramThue;
    private Double chietKhau;
    private Double giaTien;
    private String thanhToan;
    private Long soLuongNhap;
    private Long soLuongDaBan;
    private Long soLuongMua;
    private String hanSuDungThuoc;
    private Long nguoiTaoId;
    private Long nhaCungCapId;
    private String khuVuc;
    private String phanLoaiThuoc;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private QuanLyNhaCungCap quanLyNhaCungCap;
    private QuanLyTaiKhoan thongTinNguoiTao;
    private String fileDinhKem;
    private String tenNhaCungCap;
    private List fileDBArrayList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

    public Long getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(Long soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public Long getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Long soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getPhanLoaiThuoc() {
        return phanLoaiThuoc;
    }

    public void setPhanLoaiThuoc(String phanLoaiThuoc) {
        this.phanLoaiThuoc = phanLoaiThuoc;
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

    public Long getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(Long nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public Long getNhaCungCapId() {
        return nhaCungCapId;
    }

    public void setNhaCungCapId(Long nhaCungCapId) {
        this.nhaCungCapId = nhaCungCapId;
    }

    public String getHanSuDungThuoc() {
        return hanSuDungThuoc;
    }

    public void setHanSuDungThuoc(String hanSuDungThuoc) {
        this.hanSuDungThuoc = hanSuDungThuoc;
    }

    public QuanLyNhaCungCap getQuanLyNhaCungCap() {
        return quanLyNhaCungCap;
    }

    public void setQuanLyNhaCungCap(QuanLyNhaCungCap quanLyNhaCungCap) {
        this.quanLyNhaCungCap = quanLyNhaCungCap;
    }

    public QuanLyTaiKhoan getThongTinNguoiTao() {
        return thongTinNguoiTao;
    }

    public void setThongTinNguoiTao(QuanLyTaiKhoan thongTinNguoiTao) {
        this.thongTinNguoiTao = thongTinNguoiTao;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getFileDinhKem() {
        return fileDinhKem;
    }

    public void setFileDinhKem(String fileDinhKem) {
        this.fileDinhKem = fileDinhKem;
    }

    public List getFileDBArrayList() {
        return fileDBArrayList;
    }

    public void setFileDBArrayList(List fileDBArrayList) {
        this.fileDBArrayList = fileDBArrayList;
    }
}
