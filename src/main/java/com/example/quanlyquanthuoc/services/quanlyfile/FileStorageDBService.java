package com.example.quanlyquanthuoc.services.quanlyfile;


import com.example.quanlyquanthuoc.models.quanlyfiles.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public interface FileStorageDBService {
    public FileDB create(MultipartFile file) throws IOException;

    public FileDB getFile(String id);

    public Stream<FileDB> getAllFiles();
    public Map<String, Object> getAllSelect();

    public Map<String, Object> deleteFile(String id);

    public Stream<FileDB> getAllFilesImg();

    public Stream<FileDB> getAllFilesTxt();


}
