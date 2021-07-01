package com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;

import javax.persistence.*;

@Entity
public class HangHoaTrongHoaDonGTGT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenHangHoa;
    private String donViTinh;
    private String hanDung;
    private Long soLuong;
    private String soLo;
    private Double donGia;
    private Double thanhTien;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="hoadongtgt_id",nullable = false)
    private HoaDonGTGT hoaDonGTGT;

    public HangHoaTrongHoaDonGTGT() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHanDung() {
        return hanDung;
    }

    public void setHanDung(String hanDung) {
        this.hanDung = hanDung;
    }

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public String getSoLo() {
        return soLo;
    }

    public void setSoLo(String soLo) {
        this.soLo = soLo;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public HoaDonGTGT getHoaDonGTGT() {
        return hoaDonGTGT;
    }

    public void setHoaDonGTGT(HoaDonGTGT hoaDonGTGT) {
        this.hoaDonGTGT = hoaDonGTGT;
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
