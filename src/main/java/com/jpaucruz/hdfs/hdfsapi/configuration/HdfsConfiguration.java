package com.jpaucruz.hdfs.hdfsapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HdfsConfiguration{
  
  @Value("${hdfs.configuration.server}") String hdfsServer;
  @Value("${hdfs.configuration.user}") String hdfsUser;
  
  @Bean
  public org.apache.hadoop.conf.Configuration config(){
    System.setProperty("HADOOP_USER_NAME", hdfsUser);
    org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration(true);
    config.set("fs.defaultFS", hdfsServer);
    return config;
  }
  
}
