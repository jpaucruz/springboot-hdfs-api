package com.jpaucruz.hdfs.hdfsapi.domain.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {
  
  private String message;
  private int httpCode;
  
}
