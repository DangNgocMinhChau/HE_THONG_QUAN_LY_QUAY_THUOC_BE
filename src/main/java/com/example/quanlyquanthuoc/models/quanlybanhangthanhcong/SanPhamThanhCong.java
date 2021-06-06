package com.example.quanlyquanthuoc.models.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;

import javax.persistence.*;

@Entity
public class SanPhamThanhCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private Long soLuongMua;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="quanlybanhangthanhcong_id",nullable = false)
    private QuanLyBanHangThanhCong quanLyBanHangThanhCong;


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

    public QuanLyBanHangThanhCong getQuanLyBanHangThanhCong() {
        return quanLyBanHangThanhCong;
    }

    public void setQuanLyBanHangThanhCong(QuanLyBanHangThanhCong quanLyBanHangThanhCong) {
        this.quanLyBanHangThanhCong = quanLyBanHangThanhCong;
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
