package com.objetivo2.fileupload.repository;

import com.objetivo2.fileupload.model.UploadTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDataRepository extends JpaRepository<UploadTable,Integer> {

}
