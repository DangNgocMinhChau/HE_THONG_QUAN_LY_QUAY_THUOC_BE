package com.chaudang.managephamarcity.repositorys.quanlybanhang;

import com.chaudang.managephamarcity.models.quanlybanhang.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    @Query(value = "select * from san_pham s where s.quanlybanhang_id = ?1", nativeQuery = true)
    List<SanPham> findBySanPham(Long quanlybanhang_id);
}
