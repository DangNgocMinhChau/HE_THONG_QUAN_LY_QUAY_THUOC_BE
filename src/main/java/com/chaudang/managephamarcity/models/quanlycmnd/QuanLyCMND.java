package com.chaudang.managephamarcity.models.quanlycmnd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuanLyCMND {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cmnd;
    private Long idUser;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;

    public QuanLyCMND() {
    }

    public QuanLyCMND(Long id, String cmnd, Long idUser, String ngayTaoBanGhi, String ngayChinhSua) {
        this.id = id;
        this.cmnd = cmnd;
        this.idUser = idUser;
        this.ngayTaoBanGhi = ngayTaoBanGhi;
        this.ngayChinhSua = ngayChinhSua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
}
