package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class CamelDemoApplication {

  public static void main(final String[] args) {
    SpringApplication.run(CamelDemoApplication.class, args);
  }

}
