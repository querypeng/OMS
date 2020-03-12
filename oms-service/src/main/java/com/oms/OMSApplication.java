package com.oms;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.oms.dao")
public class OMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OMSApplication.class, args);
    }
}
