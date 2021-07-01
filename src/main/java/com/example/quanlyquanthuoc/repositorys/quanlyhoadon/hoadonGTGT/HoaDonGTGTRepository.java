package com.example.quanlyquanthuoc.repositorys.quanlyhoadon.hoadonGTGT;

import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HoaDonGTGT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HoaDonGTGTRepository extends JpaRepository<HoaDonGTGT,Long> {
    @Query(value = "select * from hoa_dongtgt h" +
            " where h.flag = true and  h.ngay_hoa_don like CONCAT('%',:ngayHoaDon,'%')"+
            " order by " +
            "id desc"
            , nativeQuery = true)
    List<HoaDonGTGT> findAllHoaDonGTGTByTheoDate(@Param("ngayHoaDon") String ngayHoaDon);

    @Query(value = "select * from hoa_dongtgt h" +
            " where h.flag = false"+
            " order by " +
            "id desc"
            , nativeQuery = true)
    List<HoaDonGTGT> findAllHoaDonGTGTByFlagFalse();
}
