package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.sql.*;


@Configuration
@EnableWebMvc
@SpringBootApplication


// spring boot application
public class Application {

    public static void main(String[] args) throws IOException, SQLException {

        SpringApplication.run(Application.class, args);

    }

}
