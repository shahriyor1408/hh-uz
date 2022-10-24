package com.company.hhuz;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@OpenAPIDefinition
@SpringBootApplication
@Configuration
public class HhUzApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhUzApplication.class, args);
    }

}
