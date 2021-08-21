package com.example.quanlyquanthuoc.models.quanlybaiviet;

import javax.persistence.*;

@Entity
public class QuanLyBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=1000)
    private String noiDung;
    private String tag;
    private String tieuDe;
    @Column(length=1000)
    private String file;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public QuanLyBaiViet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
