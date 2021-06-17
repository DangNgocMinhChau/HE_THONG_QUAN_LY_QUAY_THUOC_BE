package com.example.quanlyquanthuoc.models.quanlybanhangthanhcong;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuanLyBanHangThanhCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idKhachHang;
    private String sanPham;
    private String tenKhachHang;
    private String soDienThoaiKhachHang;
    private Double tienNhan;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;


    @OneToMany(mappedBy = "quanLyBanHangThanhCong")
    private Set<SanPhamThanhCong> sanPhamThanhCongs;

    public QuanLyBanHangThanhCong() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
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

    public Set<SanPhamThanhCong> getSanPhamThanhCongs() {
        return sanPhamThanhCongs;
    }

    public void setSanPhamThanhCongs(Set<SanPhamThanhCong> sanPhamThanhCongs) {
        this.sanPhamThanhCongs = sanPhamThanhCongs;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Double getTienNhan() {
        return tienNhan;
    }

    public void setTienNhan(Double tienNhan) {
        this.tienNhan = tienNhan;
    }
}
