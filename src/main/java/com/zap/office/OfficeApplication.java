package com.zap.office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zap"})
public class OfficeApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }
}
