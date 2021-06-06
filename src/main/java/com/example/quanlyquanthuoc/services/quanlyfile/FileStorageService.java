package com.example.quanlyquanthuoc.services.quanlyfile;


import com.example.quanlyquanthuoc.models.quanlyfiles.FileDB;
import com.example.quanlyquanthuoc.repositorys.quanlyfiles.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }

  public Map<String, Object> deleteFile(String id) {
    Map<String,Object> result = new HashMap<>();
    try{
            fileDBRepository.deleteById(id);
    }catch (Exception e){

    }
    result.put("status",true);
      return result;
  }

  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
