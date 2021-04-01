package com.example.service_outsourcing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.service_outsourcing.mapper")
public class ServiceOutsourcingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOutsourcingApplication.class, args);
    }

}
