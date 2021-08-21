package com.example.quanlyquanthuoc.repositorys.quanlyhoadon.hoadonGTGT;


import com.example.quanlyquanthuoc.models.quanlyhoadon.hoadonGTGT.HangHoaTrongHoaDonGTGT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HangHoaTrongHoaDonGTGTRepository extends JpaRepository<HangHoaTrongHoaDonGTGT, Long> {
    @Query(value = "select * from hang_hoa_trong_hoa_dongtgt h where h.hoadongtgt_id = ?1", nativeQuery = true)
    List<HangHoaTrongHoaDonGTGT> findByHangHoaTheoIdHoaDonGTGT(Long hoadongtgt_id);

}
