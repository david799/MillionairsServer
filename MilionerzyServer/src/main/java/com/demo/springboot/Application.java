package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@SpringBootApplication


// spring boot application
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);

    }

}
