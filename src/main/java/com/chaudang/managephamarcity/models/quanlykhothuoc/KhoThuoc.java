package com.chaudang.managephamarcity.models.quanlykhothuoc;

import com.chaudang.managephamarcity.models.quanlybanhang.SanPham;
import com.chaudang.managephamarcity.models.quanlynhacungcap.QuanLyNhaCungCap;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KhoThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String khuVuc;
    private String phanLoaiThuoc;
    private String hanSuDungThuoc;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "nhacungcap_id",nullable = false)
    private QuanLyNhaCungCap quanLyNhaCungCap;

    @OneToMany(mappedBy = "khoThuoc")
    private Set<SanPham> sanPhams;

    public KhoThuoc() {

    }

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

    public QuanLyNhaCungCap getQuanLyNhaCungCap() {
        return quanLyNhaCungCap;
    }

    public void setQuanLyNhaCungCap(QuanLyNhaCungCap quanLyNhaCungCap) {
        this.quanLyNhaCungCap = quanLyNhaCungCap;
    }

    public Long getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(Long nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public String getHanSuDungThuoc() {
        return hanSuDungThuoc;
    }

    public void setHanSuDungThuoc(String hanSuDungThuoc) {
        this.hanSuDungThuoc = hanSuDungThuoc;
    }

    public Set<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
