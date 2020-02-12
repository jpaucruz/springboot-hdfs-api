package com.jpaucruz.hdfs.hdfsapi.controllers;

import com.jpaucruz.hdfs.hdfsapi.domain.api.HdfsFileRequest;
import com.jpaucruz.hdfs.hdfsapi.domain.api.HdfsFolderRequest;
import com.jpaucruz.hdfs.hdfsapi.services.HdfsApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Api(tags = "HDFS API")
@RequestMapping(value = "/api/hdfs")
public class HdfsApiController {

  private HdfsApiService hdfsApiService;
  
  @Autowired
  public HdfsApiController(HdfsApiService hdfsApiService){
    this.hdfsApiService = hdfsApiService;
  }
  
  @PostMapping(value = "/folder")
  public ResponseEntity createFolder(@RequestBody HdfsFolderRequest folderRequest) throws IOException{
    hdfsApiService.createFolder(folderRequest.getFolderName());
    return new ResponseEntity(HttpStatus.CREATED);
  }
  
  @PostMapping(value = "/file")
  public ResponseEntity createFile(@RequestBody HdfsFileRequest fileRequest) throws IOException{
    hdfsApiService.createFile(fileRequest.getFolderName(), fileRequest.getFileName());
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  
}
