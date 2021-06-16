package com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SanPhamThanhCongRepository extends JpaRepository<SanPhamThanhCong, Long> {
    @Query(value = "select * from san_pham_thanh_cong s where s.quanlybanhangthanhcong_id = ?1", nativeQuery = true)
    List<SanPhamThanhCong> findBySanPhamThanhCong(Long quanlybanhangthanhcong_id);


    @Query(value = "" +
            "select quanlynhathuoc.san_pham_thanh_cong.khothuoc_id," +
            " quanlynhathuoc.kho_thuoc.ten_thuoc," +
            "quanlynhathuoc.san_pham_thanh_cong.so_luong_mua," +
            " quanlynhathuoc.san_pham_thanh_cong.ngay_tao_ban_ghi," +
            "quanlynhathuoc.san_pham_thanh_cong.id, " +
            "quanlynhathuoc.san_pham_thanh_cong.flag, " +
            "quanlynhathuoc.san_pham_thanh_cong.ngay_chinh_sua, " +
            "quanlynhathuoc.san_pham_thanh_cong.quanlybanhangthanhcong_id " +
            "from quanlynhathuoc.san_pham_thanh_cong inner join quanlynhathuoc.kho_thuoc on quanlynhathuoc.san_pham_thanh_cong.khothuoc_id = quanlynhathuoc.kho_thuoc.id" +
            " where quanlybanhangthanhcong_id=?1 ", nativeQuery = true)
    SanPhamThanhCong getAllSanPhamByIdHoaDon(Long quanlybanhangthanhcong_id);


}
