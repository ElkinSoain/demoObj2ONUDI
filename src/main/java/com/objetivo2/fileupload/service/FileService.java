package com.objetivo2.fileupload.service;

import com.objetivo2.fileupload.dto.UploadDTO;
import com.objetivo2.fileupload.model.UploadTable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileService {

    public UploadDTO save(MultipartFile file)throws Exception;

    public UploadDTO saveThree(MultipartFile file,MultipartFile fileTwo, MultipartFile fileThree)throws Exception;


    public Stream<Path> saveAll(List<MultipartFile> files) ;

    public UploadTable saveUploadTable(UploadTable uploadTable);


}
