package com.example.quanlyquanthuoc.services.quanlytaikhoan;


import com.example.quanlyquanthuoc.models.quanlytaikhoan.Quyen;
import com.example.quanlyquanthuoc.repositorys.quanlytaikhoan.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    QuyenRepository quyenRepository;
    @Override
    public Quyen findById(Long quyenId) {
        return quyenRepository.findById(quyenId).orElse(null);
    }
}
