package com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc;

public class KhuVucDeThuocDTO {
    private Long id;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private String ngayXoaBanGhi;
    private Boolean flag;
    private String ma;
    private String ten;

    public KhuVucDeThuocDTO(Long id, String ngayTaoBanGhi, String ngayChinhSua, String ngayXoaBanGhi, Boolean flag) {
        this.id = id;
        this.ngayTaoBanGhi = ngayTaoBanGhi;
        this.ngayChinhSua = ngayChinhSua;
        this.ngayXoaBanGhi = ngayXoaBanGhi;
        this.flag = flag;
    }

    public KhuVucDeThuocDTO() {
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

    public String getNgayXoaBanGhi() {
        return ngayXoaBanGhi;
    }

    public void setNgayXoaBanGhi(String ngayXoaBanGhi) {
        this.ngayXoaBanGhi = ngayXoaBanGhi;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
