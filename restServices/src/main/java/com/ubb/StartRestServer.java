package com.ubb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Properties;

@ComponentScan("com.ubb.client")
@ComponentScan("com.ubb")
@ComponentScan("com.ubb.controller")
@ComponentScan("com.ubb.repository.jdbc")
@ComponentScan(basePackages = "com.ubb")
@SpringBootApplication
public class StartRestServer {
    public static void main(String[] args) {
        SpringApplication.run(StartRestServer.class, args);
    }

    @Bean(name = "properties")
    public Properties getProperties() {
        Properties properties = new Properties();

        try {
            properties.load(StartRestServer.class.getResourceAsStream("/db.properties"));
        } catch (IOException ioException) {
            System.out.println("Cannot find db.properties! " + ioException.getMessage());
        }
        return properties;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // portul pe care rulează Flutter web
                        .allowedMethods("*") // permite toate metodele HTTP
                        .allowedHeaders("*"); // permite orice headere
            }
        };
    }

}
