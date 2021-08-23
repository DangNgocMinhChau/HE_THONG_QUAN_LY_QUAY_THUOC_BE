package com.example.quanlyquanthuoc.services.danhmuc.khuvucdethuoc;

import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuoc;
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
public class KhuVucDeThuocDao {
    @Autowired
    private EntityManager entityManager;

    public List<KhuVucDeThuoc> getListKhuVucDeThuoc(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;

        sql.append("select");
        sql.append(" kvdt");
        sql.append(" from KhuVucDeThuoc kvdt");
        sql.append(" where");
        sql.append(" kvdt.id is not null and ");
        sql.append(" kvdt.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(kvdt.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(kvdt.ten) LIKE :ten");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"kvdt");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<KhuVucDeThuoc> query = entityManager.createQuery(sql.toString(), KhuVucDeThuoc.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }
        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countKhucVucDeThuoc(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;

        sql.append("select");
        sql.append(" count(kvdt)");
        sql.append(" from KhuVucDeThuoc kvdt");
        sql.append(" where");
        sql.append(" kvdt.id is not null and ");
        sql.append(" kvdt.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(kvdt.ten) LIKE :ten");
            }

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(kvdt.ma) LIKE :ma");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
