package com.yuhe.spring2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ServletComponentScan(basePackages = "com.yuhe.spring2demo.web.servlet")
public class Spring2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring2DemoApplication.class, args);
    }

}

