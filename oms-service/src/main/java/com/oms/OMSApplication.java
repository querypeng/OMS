package com.oms;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.oms.dao")
public class OMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OMSApplication.class, args);
    }
}
