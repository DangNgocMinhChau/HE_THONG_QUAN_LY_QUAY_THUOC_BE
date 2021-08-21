package com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap;

public class QuanLyNhaCungCapDTO {
    private Long id;
    private String ma;
    private String tenNhaCungCap;
    private String diaChiNhaCungCap;
    private String mstNhaCungCap;
    private String soDienThoaiNhaCungCap;
    private String zalo;
    private String email;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChiNhaCungCap() {
        return diaChiNhaCungCap;
    }

    public void setDiaChiNhaCungCap(String diaChiNhaCungCap) {
        this.diaChiNhaCungCap = diaChiNhaCungCap;
    }

    public String getMstNhaCungCap() {
        return mstNhaCungCap;
    }

    public void setMstNhaCungCap(String mstNhaCungCap) {
        this.mstNhaCungCap = mstNhaCungCap;
    }

    public String getSoDienThoaiNhaCungCap() {
        return soDienThoaiNhaCungCap;
    }

    public void setSoDienThoaiNhaCungCap(String soDienThoaiNhaCungCap) {
        this.soDienThoaiNhaCungCap = soDienThoaiNhaCungCap;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
