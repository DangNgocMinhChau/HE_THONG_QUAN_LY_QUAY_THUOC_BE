package com.example.quanlyquanthuoc.repositorys.danhmuc.khuvucdethuoc;

import com.example.quanlyquanthuoc.models.danhmuc.khuvucdethuoc.KhuVucDeThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuVucDeThuocRepository extends JpaRepository<KhuVucDeThuoc, Long> {

}
