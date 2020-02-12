package com.jpaucruz.hdfs.hdfsapi.configuration;

import com.jpaucruz.hdfs.hdfsapi.domain.api.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionConfiguration extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(value = {HttpServerErrorException.class})
  protected ResponseEntity manageHttpServerErrorException(HttpServerErrorException ex) {
    
    return new ResponseEntity<>(
      ErrorResponse
        .builder()
        .message(ex.getMessage())
        .httpCode(ex.getStatusCode().value())
        .build(),
      ex.getStatusCode()
    );
    
  }
  
  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity manageException(Exception ex) {
    ErrorResponse errorResponse = ErrorResponse.builder().message(ex.getMessage()).build();
    return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(500));
  }
  
}