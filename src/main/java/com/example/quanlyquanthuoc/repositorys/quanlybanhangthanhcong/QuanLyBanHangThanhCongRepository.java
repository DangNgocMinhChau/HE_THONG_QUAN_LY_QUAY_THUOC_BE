package com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.QuanLyBanHangThanhCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuanLyBanHangThanhCongRepository extends JpaRepository<QuanLyBanHangThanhCong, Long> {
    @Query(value = "select id  from quan_ly_ban_hang_thanh_cong q" +
            " where " +
            "q.id_khach_hang = ?1" +
            " order by " +
            "ngay_tao_ban_ghi desc", nativeQuery = true)
    List<Long> findAllHoaDonByIdKhachHang(Long id_khach_hang);

}
