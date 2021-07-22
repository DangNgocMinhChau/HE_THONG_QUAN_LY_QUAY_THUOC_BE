package com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuanLyBanHangThanhCongRepository extends JpaRepository<QuanLyBanHangThanhCong, Long> {
    @Query(value = "select id  from quan_ly_ban_hang_thanh_cong q" +
            " where q.check_edit = false and " +
            "q.id_khach_hang = ?1" +
            " order by " +
            "ngay_tao_ban_ghi desc", nativeQuery = true)
    List<Long> findAllHoaDonByIdKhachHang(Long id_khach_hang);

    @Query(value = "select sum(id_hoa_don_duoc_sua = ?1)  from quan_ly_ban_hang_thanh_cong q"
            , nativeQuery = true)
    Integer sumLichSuHoaDon(Long id_hoa_don);

    @Query(value = "select * from quan_ly_ban_hang_thanh_cong q" +
            " where q.check_edit = false and " +
            "q.ngay_tao_ban_ghi like CONCAT('%',:ngayTaoBanGhi,'%')" +
            " order by " +
            "id desc", nativeQuery = true)
    List<QuanLyBanHangThanhCong> findAllHoaDonByTheoDate(@Param("ngayTaoBanGhi") String ngayTaoBanGhi);

    @Query(value = "select * from quan_ly_ban_hang_thanh_cong q" +
            " where q.id_hoa_don_duoc_sua = :idHoaDon" +
            " order by " +
            "id desc", nativeQuery = true)
    List<QuanLyBanHangThanhCong> findAllLichSuChinhSuaHoaDonTheoIdHoaDon(@Param("idHoaDon") Long idHoaDon);

}
