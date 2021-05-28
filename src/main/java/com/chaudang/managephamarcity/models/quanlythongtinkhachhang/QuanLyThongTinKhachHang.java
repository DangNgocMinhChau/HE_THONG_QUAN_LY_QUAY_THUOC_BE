package com.chaudang.managephamarcity.models.quanlythongtinkhachhang;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuanLyThongTinKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenKhachHang;
    private String soDienThoai;
    private Boolean flag;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;

    public QuanLyThongTinKhachHang(String tenKhachHang, String soDienThoai, String ngayTaoBanGhi, String ngayChinhSua) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.ngayTaoBanGhi = ngayTaoBanGhi;
        this.ngayChinhSua = ngayChinhSua;
    }

    public QuanLyThongTinKhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
}
