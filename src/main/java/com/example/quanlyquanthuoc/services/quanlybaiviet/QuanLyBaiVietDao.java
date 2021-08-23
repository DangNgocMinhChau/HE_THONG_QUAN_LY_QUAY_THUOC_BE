package com.example.quanlyquanthuoc.services.quanlybaiviet;

import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiViet;
import com.example.quanlyquanthuoc.models.quanlybaiviet.QuanLyBaiVietDto;
import com.example.quanlyquanthuoc.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuanLyBaiVietDao {
    @Autowired
    private EntityManager entityManager;

    public List<QuanLyBaiViet> getListBaiViet(String searchString, Pageable pageable,String sortData) {
        StringBuilder sql = new StringBuilder();
        Object noiDung = null;
        Object tag = null;
        Object tieuDe = null;
        Object gioiThieu = null;
        Object file = null;
        Object imgAvatar = null;

        sql.append("select");
        sql.append(" bv");
        sql.append(" from QuanLyBaiViet bv");
        sql.append(" where");
        sql.append(" bv.id is not null ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            noiDung = listSearchParams.get("noiDung");
            if(noiDung != null && noiDung != ""){
                sql.append(" AND LOWER(bv.noiDung) LIKE :noiDung");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bv.tag) LIKE :tag");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if(tieuDe != null && tieuDe != ""){
                sql.append(" AND LOWER(bv.tieuDe) LIKE :tieuDe");
            }

            gioiThieu = listSearchParams.get("gioiThieu");
            if(gioiThieu != null && gioiThieu != ""){
                sql.append(" AND LOWER(bv.gioiThieu) LIKE :gioiThieu");
            }

            file = listSearchParams.get("file");
            if(file != null && file != ""){
                sql.append(" AND LOWER(bv.file) LIKE :file");
            }

            imgAvatar = listSearchParams.get("imgAvatar");
            if(imgAvatar != null && imgAvatar != ""){
                sql.append(" AND LOWER(bv.imgAvatar) LIKE :imgAvatar");
            }
        }
        if(sortData!=null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"bv");
            sql.append(" ORDER BY " + sortQuery);
        }


        TypedQuery<QuanLyBaiViet> query = entityManager.createQuery(sql.toString(), QuanLyBaiViet.class);
        if(noiDung != null && noiDung !=""){
            query.setParameter("noiDung","%" + noiDung.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }

        if(tieuDe != null && tieuDe !=""){
            query.setParameter("tag","%" + tieuDe.toString().toLowerCase() + "%");
        }

        if(gioiThieu != null && gioiThieu !=""){
            query.setParameter("tag","%" + gioiThieu.toString().toLowerCase() + "%");
        }

        if(file != null && file !=""){
            query.setParameter("tag","%" + file.toString().toLowerCase() + "%");
        }

        if(imgAvatar != null && imgAvatar !=""){
            query.setParameter("tag","%" + imgAvatar.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }




    public Integer countBaiViet(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object noiDung = null;
        Object tag = null;
        Object tieuDe = null;
        Object gioiThieu = null;
        Object file = null;
        Object imgAvatar = null;

        sql.append("select");
        sql.append(" count(bv)");
        sql.append(" from QuanLyBaiViet bv");
        sql.append(" where");
        sql.append(" bv.id is not null ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            noiDung = listSearchParams.get("noiDung");
            if(noiDung != null && noiDung != ""){
                sql.append(" AND LOWER(bv.noiDung) LIKE :noiDung");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bv.tag) LIKE :tag");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if(tieuDe != null && tieuDe != ""){
                sql.append(" AND LOWER(bv.tieuDe) LIKE :tieuDe");
            }

            gioiThieu = listSearchParams.get("gioiThieu");
            if(gioiThieu != null && gioiThieu != ""){
                sql.append(" AND LOWER(bv.gioiThieu) LIKE :gioiThieu");
            }

            file = listSearchParams.get("file");
            if(file != null && file != ""){
                sql.append(" AND LOWER(bv.file) LIKE :file");
            }

            imgAvatar = listSearchParams.get("imgAvatar");
            if(imgAvatar != null && imgAvatar != ""){
                sql.append(" AND LOWER(bv.imgAvatar) LIKE :imgAvatar");
            }
        }



        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(noiDung != null && noiDung !=""){
            query.setParameter("noiDung","%" + noiDung.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }

        if(tieuDe != null && tieuDe !=""){
            query.setParameter("tag","%" + tieuDe.toString().toLowerCase() + "%");
        }

        if(gioiThieu != null && gioiThieu !=""){
            query.setParameter("tag","%" + gioiThieu.toString().toLowerCase() + "%");
        }

        if(file != null && file !=""){
            query.setParameter("tag","%" + file.toString().toLowerCase() + "%");
        }

        if(imgAvatar != null && imgAvatar !=""){
            query.setParameter("tag","%" + imgAvatar.toString().toLowerCase() + "%");
        }


        return ((Number) query.getSingleResult()).intValue();
    }






    public Integer getCountBaiViet(String searchString){
        StringBuilder sql = new StringBuilder();

        Object noiDung = null;
        Object tag = null;
        Object tieuDe = null;
        Object gioiThieu = null;
        Object file = null;
        Object imgAvatar = null;

        sql.append("select ");
        sql.append(" count(*) as Total");
        sql.append(" from quan_ly_bai_viet as bv");
        sql.append(" where");
        sql.append(" bv.id is Not NULL ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            noiDung = listSearchParams.get("noiDung");
            if(noiDung != null && noiDung != ""){
                sql.append(" AND LOWER(bv.noiDung) LIKE :noiDung");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bv.tag) LIKE :tag");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if(tieuDe != null && tieuDe != ""){
                sql.append(" AND LOWER(bv.tieuDe) LIKE :tieuDe");
            }

            gioiThieu = listSearchParams.get("gioiThieu");
            if(gioiThieu != null && gioiThieu != ""){
                sql.append(" AND LOWER(bv.gioiThieu) LIKE :gioiThieu");
            }

            file = listSearchParams.get("file");
            if(file != null && file != ""){
                sql.append(" AND LOWER(bv.file) LIKE :file");
            }

            imgAvatar = listSearchParams.get("imgAvatar");
            if(imgAvatar != null && imgAvatar != ""){
                sql.append(" AND LOWER(bv.imgAvatar) LIKE :imgAvatar");
            }
        }

        Query query = entityManager.createNativeQuery(sql.toString());

        if(noiDung != null && noiDung !=""){
            query.setParameter("noiDung","%" + noiDung.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }

        if(tieuDe != null && tieuDe !=""){
            query.setParameter("tag","%" + tieuDe.toString().toLowerCase() + "%");
        }

        if(gioiThieu != null && gioiThieu !=""){
            query.setParameter("tag","%" + gioiThieu.toString().toLowerCase() + "%");
        }

        if(file != null && file !=""){
            query.setParameter("tag","%" + file.toString().toLowerCase() + "%");
        }

        if(imgAvatar != null && imgAvatar !=""){
            query.setParameter("tag","%" + imgAvatar.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }

}
