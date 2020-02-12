package com.jpaucruz.hdfs.hdfsapi.domain.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HdfsFileRequest {
  
  private String folderName;
  private String fileName;

}
