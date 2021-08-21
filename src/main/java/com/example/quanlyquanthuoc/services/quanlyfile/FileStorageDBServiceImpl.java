package com.example.quanlyquanthuoc.services.quanlyfile;

import com.example.quanlyquanthuoc.models.quanlyfiles.FileDB;
import com.example.quanlyquanthuoc.models.quanlyfiles.FileSelect;
import com.example.quanlyquanthuoc.repositorys.quanlyfiles.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileStorageDBServiceImpl implements FileStorageDBService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Override
    public FileDB create(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String pathFile = "D:\\LamViec\\IT\\DuAn\\QuayThuoc\\HE_THONG_QUAN_LY_QUAY_THUOC_FE\\public\\filedinhkem\\" + fileName;
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), pathFile);
        return fileDBRepository.save(FileDB);
    }

    @Override
    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    @Override
    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    @Override
    public Map<String, Object> getAllSelect() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<FileDB> fileDBList = fileDBRepository.findAll();
            List<FileSelect> fileSelects = new ArrayList<>();
            for (FileDB fileDB : fileDBList) {
                FileSelect fileSelect = new FileSelect();
                fileSelect.setId(fileDB.getId());
                fileSelect.setTen(fileDB.getName());
                fileSelect.setValue(fileDB.getPath());
                fileSelects.add(fileSelect);
            }
            result.put("result", fileDBList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> deleteFile(String id) {
        Map<String, Object> result = new HashMap<>();
        try {
            fileDBRepository.deleteById(id);
//            Files.deleteIfExists(Paths.get(fileDBRepository.getById(id).getPath()));
        } catch (Exception e) {
        }
        result.put("status", true);
        result.put("Trạng thái xoá file", "Xoá file thành công");
        return result;
    }

    @Override
    public Stream<FileDB> getAllFilesImg() {
        return fileDBRepository.findByFileTypeImg().stream();
    }

    @Override
    public Stream<FileDB> getAllFilesTxt() {
        return fileDBRepository.findByFileTypeTxt().stream();
    }


}
