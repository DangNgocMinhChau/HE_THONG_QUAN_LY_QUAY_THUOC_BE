package com.chaudang.managephamarcity.repositorys.quanlybanhangthanhcong;

import com.chaudang.managephamarcity.models.quanlybanhangthanhcong.SanPhamThanhCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamThanhCongRepository extends JpaRepository<SanPhamThanhCong, Long> {
    @Query(value = "select * from san_pham_thanh_cong s where s.quanlybanhangthanhcong_id = ?1", nativeQuery = true)
    List<SanPhamThanhCong> findBySanPhamThanhCong(Long quanlybanhangthanhcong_id);
}
