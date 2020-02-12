package com.jpaucruz.hdfs.hdfsapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {
  
  private static final String API_TITLE = "HDFS API using Spring Boot";
  private static final String API_DESCRIPTION = "This API supports HDFS operations";
  
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .useDefaultResponseMessages(false)
      .apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(regex(".*/hdfs/.*"))
      .build();
  }
  
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title(API_TITLE)
      .description(API_DESCRIPTION)
      .build();
  }

}
