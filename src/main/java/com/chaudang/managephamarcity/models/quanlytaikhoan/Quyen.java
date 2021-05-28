package com.chaudang.managephamarcity.models.quanlytaikhoan;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ma;
    private String ten;

    @OneToMany(mappedBy = "quyen")
    private Set<QuanLyTaiKhoan> quanLyTaiKhoans;

    public Quyen() {
    }

    public Quyen(String ma, String ten, Set<QuanLyTaiKhoan> quanLyTaiKhoans) {
        this.ma = ma;
        this.ten = ten;
        this.quanLyTaiKhoans = quanLyTaiKhoans;
    }

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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<QuanLyTaiKhoan> getQuanLyTaiKhoans() {
        return quanLyTaiKhoans;
    }

    public void setQuanLyTaiKhoans(Set<QuanLyTaiKhoan> quanLyTaiKhoans) {
        this.quanLyTaiKhoans = quanLyTaiKhoans;
    }
}
