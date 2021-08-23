package com.example.quanlyquanthuoc.services.danhmuc.quanlynhacungcap;

import com.example.quanlyquanthuoc.models.danhmuc.quanlynhacungcap.QuanLyNhaCungCap;
import com.example.quanlyquanthuoc.models.danhmuc.tag.Tag;
import com.example.quanlyquanthuoc.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuanLyNhaCungCapDao {
    @Autowired
    private EntityManager entityManager;

    public List<QuanLyNhaCungCap> getListNhaCungCap(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object tenNhaCungCap = null;
        Object diaChiNhaCungCap = null;
        Object mstNhaCungCap = null;
        Object soDienThoaiNhaCungCap = null;
        Object zalo = null;
        Object email = null;

        sql.append("select");
        sql.append(" ncc");
        sql.append(" from QuanLyNhaCungCap ncc");
        sql.append(" where");
        sql.append(" ncc.id is not null and ");
        sql.append(" ncc.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(ncc.ma) LIKE :ma");
            }

            tenNhaCungCap = listSearchParams.get("tenNhaCungCap");
            if(tenNhaCungCap != null && tenNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.tenNhaCungCap) LIKE :tenNhaCungCap");
            }

            diaChiNhaCungCap = listSearchParams.get("diaChiNhaCungCap");
            if(diaChiNhaCungCap != null && diaChiNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.diaChiNhaCungCap) LIKE :diaChiNhaCungCap");
            }

            mstNhaCungCap = listSearchParams.get("mstNhaCungCap");
            if(mstNhaCungCap != null && mstNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.mstNhaCungCap) LIKE :mstNhaCungCap");
            }

            soDienThoaiNhaCungCap = listSearchParams.get("soDienThoaiNhaCungCap");
            if(soDienThoaiNhaCungCap != null && soDienThoaiNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.soDienThoaiNhaCungCap) LIKE :soDienThoaiNhaCungCap");
            }

            zalo = listSearchParams.get("zalo");
            if(zalo != null && zalo != ""){
                sql.append(" AND LOWER(ncc.zalo) LIKE :zalo");
            }

            email = listSearchParams.get("email");
            if(email != null && email != ""){
                sql.append(" AND LOWER(ncc.email) LIKE :email");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"ncc");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<QuanLyNhaCungCap> query = entityManager.createQuery(sql.toString(), QuanLyNhaCungCap.class);
        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(tenNhaCungCap != null && tenNhaCungCap !=""){
            query.setParameter("ma","%" + tenNhaCungCap.toString().toLowerCase() + "%");
        }


        if(diaChiNhaCungCap != null && diaChiNhaCungCap !=""){
            query.setParameter("diaChiNhaCungCap","%" + diaChiNhaCungCap.toString().toLowerCase() + "%");
        }

        if(mstNhaCungCap != null && mstNhaCungCap !=""){
            query.setParameter("mstNhaCungCap","%" + mstNhaCungCap.toString().toLowerCase() + "%");
        }

        if(soDienThoaiNhaCungCap != null && soDienThoaiNhaCungCap !=""){
            query.setParameter("soDienThoaiNhaCungCap","%" + soDienThoaiNhaCungCap.toString().toLowerCase() + "%");
        }

        if(zalo != null && zalo !=""){
            query.setParameter("zalo","%" + zalo.toString().toLowerCase() + "%");
        }

        if(email != null && email !=""){
            query.setParameter("email","%" + email.toString().toLowerCase() + "%");
        }


        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countNhaCungCap(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object tenNhaCungCap = null;
        Object diaChiNhaCungCap = null;
        Object mstNhaCungCap = null;
        Object soDienThoaiNhaCungCap = null;
        Object zalo = null;
        Object email = null;

        sql.append("select");
        sql.append(" count(ncc)");
        sql.append(" from QuanLyNhaCungCap ncc");
        sql.append(" where");
        sql.append(" ncc.id is not null and ");
        sql.append(" ncc.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            tenNhaCungCap = listSearchParams.get("tenNhaCungCap");
            if(tenNhaCungCap != null && tenNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.tenNhaCungCap) LIKE :tenNhaCungCap");
            }

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(ncc.ma) LIKE :ma");
            }

            diaChiNhaCungCap = listSearchParams.get("diaChiNhaCungCap");
            if(diaChiNhaCungCap != null && diaChiNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.diaChiNhaCungCap) LIKE :diaChiNhaCungCap");
            }

            mstNhaCungCap = listSearchParams.get("mstNhaCungCap");
            if(mstNhaCungCap != null && mstNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.mstNhaCungCap) LIKE :mstNhaCungCap");
            }

            soDienThoaiNhaCungCap = listSearchParams.get("soDienThoaiNhaCungCap");
            if(soDienThoaiNhaCungCap != null && soDienThoaiNhaCungCap != ""){
                sql.append(" AND LOWER(ncc.soDienThoaiNhaCungCap) LIKE :soDienThoaiNhaCungCap");
            }

            zalo = listSearchParams.get("zalo");
            if(zalo != null && zalo != ""){
                sql.append(" AND LOWER(ncc.zalo) LIKE :zalo");
            }

            email = listSearchParams.get("email");
            if(email != null && email != ""){
                sql.append(" AND LOWER(ncc.email) LIKE :email");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(tenNhaCungCap != null && tenNhaCungCap !=""){
            query.setParameter("tenNhaCungCap","%" + ma.toString().toLowerCase() + "%");
        }

        if(diaChiNhaCungCap != null && diaChiNhaCungCap !=""){
            query.setParameter("diaChiNhaCungCap","%" + diaChiNhaCungCap.toString().toLowerCase() + "%");
        }

        if(mstNhaCungCap != null && mstNhaCungCap !=""){
            query.setParameter("mstNhaCungCap","%" + mstNhaCungCap.toString().toLowerCase() + "%");
        }

        if(soDienThoaiNhaCungCap != null && soDienThoaiNhaCungCap !=""){
            query.setParameter("soDienThoaiNhaCungCap","%" + soDienThoaiNhaCungCap.toString().toLowerCase() + "%");
        }

        if(zalo != null && zalo !=""){
            query.setParameter("zalo","%" + zalo.toString().toLowerCase() + "%");
        }

        if(email != null && email !=""){
            query.setParameter("email","%" + email.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
