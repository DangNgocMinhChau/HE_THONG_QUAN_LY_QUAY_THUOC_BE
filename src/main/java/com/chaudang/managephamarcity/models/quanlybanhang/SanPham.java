package com.chaudang.managephamarcity.models.quanlybanhang;

import com.chaudang.managephamarcity.models.quanlykhothuoc.KhoThuoc;

import javax.persistence.*;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private Long soLuongMua;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="quanlybanhang_id",nullable = false)
    private QuanLyBanHang quanLyBanHang;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="khothuoc_id",nullable = false)
    private KhoThuoc khoThuoc;

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

    public Long getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Long soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
}
