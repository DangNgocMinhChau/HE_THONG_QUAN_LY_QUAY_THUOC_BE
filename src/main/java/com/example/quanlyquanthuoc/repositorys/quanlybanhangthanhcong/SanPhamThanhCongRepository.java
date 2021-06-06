package com.example.quanlyquanthuoc.repositorys.quanlybanhangthanhcong;

import com.example.quanlyquanthuoc.models.quanlybanhangthanhcong.SanPhamThanhCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamThanhCongRepository extends JpaRepository<SanPhamThanhCong, Long> {
    @Query(value = "select * from san_pham_thanh_cong s where s.quanlybanhangthanhcong_id = ?1", nativeQuery = true)
    List<SanPhamThanhCong> findBySanPhamThanhCong(Long quanlybanhangthanhcong_id);
}
