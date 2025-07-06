package com.yjq.electricitysystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@MapperScan("com.yjq.electricitysystem.mapper")
public class ElectricitySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectricitySystemApplication.class, args);
    }

}


