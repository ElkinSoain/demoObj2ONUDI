package com.objetivo2.fileupload.service.impl;

import com.objetivo2.fileupload.dto.UploadDTO;
import com.objetivo2.fileupload.model.UploadTable;
import com.objetivo2.fileupload.repository.UploadDataRepository;
import com.objetivo2.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@Service
public class FileServiceImpl implements FileService {


    @Autowired
    private UploadDataRepository    uploadDataRepository;

    

    private final Path rootFolder = Paths.get("cargas");




    @Override
    public UploadDTO save(MultipartFile file) throws Exception {

        Files.copy(file.getInputStream(), rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));


        String archiBase = (convert(rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())).toString()));
        //System.out.println(archiBase);


       //  uploadDataRepository.save(new UploadTable(1, "Rta", true,archiBase , "archiBase", "archiBase", true, LocalDateTime.now(), "User", LocalDateTime.now(), "User"));
       // saveUploadTable( new UploadTable(1, "Rta", true,archiBase , "archiBase", "archiBase", true, LocalDateTime.now(), "User", LocalDateTime.now(), "User"));
        return null;
    }
    //carga los 3 archivos
    @Override
    public UploadDTO saveThree(MultipartFile file,MultipartFile fileTwo, MultipartFile fileThree) throws Exception {

        Files.copy(file.getInputStream(), rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        Files.copy(fileTwo.getInputStream(), rootFolder.resolve(Objects.requireNonNull(fileTwo.getOriginalFilename())));
        Files.copy(fileThree.getInputStream(), rootFolder.resolve(Objects.requireNonNull(fileThree.getOriginalFilename())));

        String archiBase = (convert(rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())).toString()));
        String archiBaseTwo = (convert(rootFolder.resolve(Objects.requireNonNull(fileTwo.getOriginalFilename())).toString()));
        String archiBaseThree = (convert(rootFolder.resolve(Objects.requireNonNull(fileThree.getOriginalFilename())).toString()));

        System.out.println("1 :"+archiBase);
        System.out.println("2 :"+archiBaseTwo);
        System.out.println("3 :"+archiBaseThree);

        saveUploadTable( new UploadTable(null, "respuesta", true,archiBase , archiBaseTwo, archiBaseThree, true, LocalDateTime.now(), "User", LocalDateTime.now(), "User"));
        return null;
    }

    //guarda los 3 archivos
    @Override
    public Stream<Path> saveAll(List<MultipartFile> files) {
        try{
            return Files.walk(this.rootFolder,1).filter(path -> !path.equals(this.rootFolder)).
                    map(this.rootFolder::relativize);





        }  catch (RuntimeException | IOException e) {
            throw new RuntimeException("Error saving files", e);

        }
    }

    @Override
    public UploadTable saveUploadTable(UploadTable uploadTable) {
        return uploadDataRepository.save(uploadTable);
    }












    public static String convert(String filePath) {
        String encodedBase64 = null;
        try {
            byte[] fileContent = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath));
            encodedBase64 = java.util.Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodedBase64;
    }
}
