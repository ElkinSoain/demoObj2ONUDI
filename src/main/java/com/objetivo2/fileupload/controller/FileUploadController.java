package com.objetivo2.fileupload.controller;

import com.objetivo2.fileupload.dto.UploadDTO;
import com.objetivo2.fileupload.model.UploadTable;
import com.objetivo2.fileupload.service.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/file")
public class FileUploadController {




    @Autowired
    private FileService fileService;

    @Autowired
    @Qualifier("fileUploadMapper")
    private ModelMapper mapper;




    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {


        try {

            fileService.save(file);

            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }

    @PostMapping("/three")
    public ResponseEntity<?> uploadFileThree(@RequestParam("file") MultipartFile file , @RequestParam("filetwo") MultipartFile fileTwo ,@RequestParam("filethree") MultipartFile fileThree) throws Exception {

        try {

            fileService.saveThree(file,fileTwo,fileThree);


            return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }

    }



}
