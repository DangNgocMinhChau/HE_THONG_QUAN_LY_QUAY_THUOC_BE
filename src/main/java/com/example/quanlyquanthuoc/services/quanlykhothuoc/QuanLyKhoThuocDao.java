package com.example.quanlyquanthuoc.services.quanlykhothuoc;

import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.quanlykhothuoc.KhoThuoc;
import com.example.quanlyquanthuoc.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuanLyKhoThuocDao {
    @Autowired
    private EntityManager entityManager;

    public List<KhoThuoc> getListKhoThuoc(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object tenThuoc = null;
        Object ma = null;
        Object donViTinh = null;
        Object tongTienTruocThue = null;
        Object phanTramThue = null;
        Object chietKhau = null;
        Object giaTien = null;
        Object thanhToan = null;
        Object soLuongNhap = null;
        Object soLuongDaBan = null;
        Object soLuongMua = null;
        Object khuVuc = null;
        Object hanSuDungThuoc = null;
        Object nguoiTaoId = null;

        sql.append("select");
        sql.append(" kt");
        sql.append(" from KhoThuoc kt");
        sql.append(" where");
        sql.append(" kt.id is not null and ");
        sql.append(" kt.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(kt.ma) LIKE :ma");
            }

            tenThuoc = listSearchParams.get("tenThuoc");
            if(tenThuoc != null && tenThuoc != ""){
                sql.append(" AND LOWER(kt.tenThuoc) LIKE :tenThuoc");
            }

            donViTinh = listSearchParams.get("donViTinh");
            if(donViTinh != null && donViTinh != ""){
                sql.append(" AND LOWER(kt.donViTinh) LIKE :donViTinh");
            }

            tongTienTruocThue = listSearchParams.get("tongTienTruocThue");
            if(tongTienTruocThue != null && tongTienTruocThue != ""){
                sql.append(" AND LOWER(kt.tongTienTruocThue) LIKE :tongTienTruocThue");
            }

            phanTramThue = listSearchParams.get("phanTramThue");
            if(phanTramThue != null && phanTramThue != ""){
                sql.append(" AND LOWER(kt.phanTramThue) LIKE :phanTramThue");
            }

            chietKhau = listSearchParams.get("chietKhau");
            if(chietKhau != null && chietKhau != ""){
                sql.append(" AND LOWER(kt.chietKhau) LIKE :chietKhau");
            }

            giaTien = listSearchParams.get("giaTien");
            if(giaTien != null && giaTien != ""){
                sql.append(" AND LOWER(kt.giaTien) LIKE :giaTien");
            }

            thanhToan = listSearchParams.get("thanhToan");
            if(thanhToan != null && thanhToan != ""){
                sql.append(" AND LOWER(kt.thanhToan) LIKE :thanhToan");
            }

            soLuongNhap = listSearchParams.get("soLuongNhap");
            if(soLuongNhap != null && soLuongNhap != ""){
                sql.append(" AND LOWER(kt.soLuongNhap) LIKE :soLuongNhap");
            }

            soLuongDaBan = listSearchParams.get("soLuongDaBan");
            if(soLuongDaBan != null && soLuongDaBan != ""){
                sql.append(" AND LOWER(kt.soLuongDaBan) LIKE :soLuongDaBan");
            }

            soLuongMua = listSearchParams.get("soLuongMua");
            if(soLuongMua != null && soLuongMua != ""){
                sql.append(" AND LOWER(kt.soLuongMua) LIKE :soLuongMua");
            }

            khuVuc = listSearchParams.get("khuVuc");
            if(khuVuc != null && khuVuc != ""){
                sql.append(" AND LOWER(kt.khuVuc) LIKE :khuVuc");
            }

            hanSuDungThuoc = listSearchParams.get("hanSuDungThuoc");
            if(hanSuDungThuoc != null && hanSuDungThuoc != ""){
                sql.append(" AND LOWER(kt.hanSuDungThuoc) LIKE :hanSuDungThuoc");
            }

            nguoiTaoId = listSearchParams.get("nguoiTaoId");
            if(nguoiTaoId != null && nguoiTaoId != ""){
                sql.append(" AND LOWER(kt.nguoiTaoId) LIKE :nguoiTaoId");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"kt");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<KhoThuoc> query = entityManager.createQuery(sql.toString(), KhoThuoc.class);
        if(tenThuoc != null && tenThuoc !=""){
            query.setParameter("tenThuoc","%" + tenThuoc.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(donViTinh != null && donViTinh !=""){
            query.setParameter("donViTinh","%" + donViTinh.toString().toLowerCase() + "%");
        }

        if(tongTienTruocThue != null && tongTienTruocThue !=""){
            query.setParameter("tongTienTruocThue","%" + tongTienTruocThue.toString().toLowerCase() + "%");
        }

        if(phanTramThue != null && phanTramThue !=""){
            query.setParameter("phanTramThue","%" + phanTramThue.toString().toLowerCase() + "%");
        }

        if(chietKhau != null && chietKhau !=""){
            query.setParameter("chietKhau","%" + chietKhau.toString().toLowerCase() + "%");
        }

        if(giaTien != null && giaTien !=""){
            query.setParameter("giaTien","%" + giaTien.toString().toLowerCase() + "%");
        }
        if(thanhToan != null && thanhToan !=""){
            query.setParameter("thanhToan","%" + thanhToan.toString().toLowerCase() + "%");
        }

        if(soLuongNhap != null && soLuongNhap !=""){
            query.setParameter("soLuongNhap","%" + soLuongNhap.toString().toLowerCase() + "%");
        }
        if(soLuongDaBan != null && soLuongDaBan !=""){
            query.setParameter("soLuongDaBan","%" + soLuongDaBan.toString().toLowerCase() + "%");
        }

        if(soLuongMua != null && soLuongMua !=""){
            query.setParameter("soLuongMua","%" + soLuongMua.toString().toLowerCase() + "%");
        }
        if(khuVuc != null && khuVuc !=""){
            query.setParameter("khuVuc","%" + khuVuc.toString().toLowerCase() + "%");
        }

        if(hanSuDungThuoc != null && hanSuDungThuoc !=""){
            query.setParameter("hanSuDungThuoc","%" + hanSuDungThuoc.toString().toLowerCase() + "%");
        }

        if(nguoiTaoId != null && nguoiTaoId !=""){
            query.setParameter("nguoiTaoId","%" + nguoiTaoId.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countKhoThuoc(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object tenThuoc = null;
        Object ma = null;
        Object donViTinh = null;
        Object tongTienTruocThue = null;
        Object phanTramThue = null;
        Object chietKhau = null;
        Object giaTien = null;
        Object thanhToan = null;
        Object soLuongNhap = null;
        Object soLuongDaBan = null;
        Object soLuongMua = null;
        Object khuVuc = null;
        Object hanSuDungThuoc = null;
        Object nguoiTaoId = null;

        sql.append("select");
        sql.append(" kt");
        sql.append(" from KhoThuoc kt");
        sql.append(" where");
        sql.append(" kt.id is not null and ");
        sql.append(" kt.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(kt.ma) LIKE :ma");
            }

            tenThuoc = listSearchParams.get("tenThuoc");
            if(tenThuoc != null && tenThuoc != ""){
                sql.append(" AND LOWER(kt.tenThuoc) LIKE :tenThuoc");
            }

            donViTinh = listSearchParams.get("donViTinh");
            if(donViTinh != null && donViTinh != ""){
                sql.append(" AND LOWER(kt.donViTinh) LIKE :donViTinh");
            }

            tongTienTruocThue = listSearchParams.get("tongTienTruocThue");
            if(tongTienTruocThue != null && tongTienTruocThue != ""){
                sql.append(" AND LOWER(kt.tongTienTruocThue) LIKE :tongTienTruocThue");
            }

            phanTramThue = listSearchParams.get("phanTramThue");
            if(phanTramThue != null && phanTramThue != ""){
                sql.append(" AND LOWER(kt.phanTramThue) LIKE :phanTramThue");
            }

            chietKhau = listSearchParams.get("chietKhau");
            if(chietKhau != null && chietKhau != ""){
                sql.append(" AND LOWER(kt.chietKhau) LIKE :chietKhau");
            }

            giaTien = listSearchParams.get("giaTien");
            if(giaTien != null && giaTien != ""){
                sql.append(" AND LOWER(kt.giaTien) LIKE :giaTien");
            }

            thanhToan = listSearchParams.get("thanhToan");
            if(thanhToan != null && thanhToan != ""){
                sql.append(" AND LOWER(kt.thanhToan) LIKE :thanhToan");
            }

            soLuongNhap = listSearchParams.get("soLuongNhap");
            if(soLuongNhap != null && soLuongNhap != ""){
                sql.append(" AND LOWER(kt.soLuongNhap) LIKE :soLuongNhap");
            }

            soLuongDaBan = listSearchParams.get("soLuongDaBan");
            if(soLuongDaBan != null && soLuongDaBan != ""){
                sql.append(" AND LOWER(kt.soLuongDaBan) LIKE :soLuongDaBan");
            }

            soLuongMua = listSearchParams.get("soLuongMua");
            if(soLuongMua != null && soLuongMua != ""){
                sql.append(" AND LOWER(kt.soLuongMua) LIKE :soLuongMua");
            }

            khuVuc = listSearchParams.get("khuVuc");
            if(khuVuc != null && khuVuc != ""){
                sql.append(" AND LOWER(kt.khuVuc) LIKE :khuVuc");
            }

            hanSuDungThuoc = listSearchParams.get("hanSuDungThuoc");
            if(hanSuDungThuoc != null && hanSuDungThuoc != ""){
                sql.append(" AND LOWER(kt.hanSuDungThuoc) LIKE :hanSuDungThuoc");
            }

            nguoiTaoId = listSearchParams.get("nguoiTaoId");
            if(nguoiTaoId != null && nguoiTaoId != ""){
                sql.append(" AND LOWER(kt.nguoiTaoId) LIKE :nguoiTaoId");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if(tenThuoc != null && tenThuoc !=""){
            query.setParameter("tenThuoc","%" + tenThuoc.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(donViTinh != null && donViTinh !=""){
            query.setParameter("donViTinh","%" + donViTinh.toString().toLowerCase() + "%");
        }

        if(tongTienTruocThue != null && tongTienTruocThue !=""){
            query.setParameter("tongTienTruocThue","%" + tongTienTruocThue.toString().toLowerCase() + "%");
        }

        if(phanTramThue != null && phanTramThue !=""){
            query.setParameter("phanTramThue","%" + phanTramThue.toString().toLowerCase() + "%");
        }

        if(chietKhau != null && chietKhau !=""){
            query.setParameter("chietKhau","%" + chietKhau.toString().toLowerCase() + "%");
        }

        if(giaTien != null && giaTien !=""){
            query.setParameter("giaTien","%" + giaTien.toString().toLowerCase() + "%");
        }
        if(thanhToan != null && thanhToan !=""){
            query.setParameter("thanhToan","%" + thanhToan.toString().toLowerCase() + "%");
        }

        if(soLuongNhap != null && soLuongNhap !=""){
            query.setParameter("soLuongNhap","%" + soLuongNhap.toString().toLowerCase() + "%");
        }
        if(soLuongDaBan != null && soLuongDaBan !=""){
            query.setParameter("soLuongDaBan","%" + soLuongDaBan.toString().toLowerCase() + "%");
        }

        if(soLuongMua != null && soLuongMua !=""){
            query.setParameter("soLuongMua","%" + soLuongMua.toString().toLowerCase() + "%");
        }
        if(khuVuc != null && khuVuc !=""){
            query.setParameter("khuVuc","%" + khuVuc.toString().toLowerCase() + "%");
        }

        if(hanSuDungThuoc != null && hanSuDungThuoc !=""){
            query.setParameter("hanSuDungThuoc","%" + hanSuDungThuoc.toString().toLowerCase() + "%");
        }

        if(nguoiTaoId != null && nguoiTaoId !=""){
            query.setParameter("nguoiTaoId","%" + nguoiTaoId.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
