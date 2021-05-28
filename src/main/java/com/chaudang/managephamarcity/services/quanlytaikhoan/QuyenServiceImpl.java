package com.chaudang.managephamarcity.services.quanlytaikhoan;

import com.chaudang.managephamarcity.models.quanlytaikhoan.Quyen;
import com.chaudang.managephamarcity.repositorys.quanlytaikhoan.QuyenRepository;
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
