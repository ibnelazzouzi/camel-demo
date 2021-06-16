package com.example.demo.config;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${com.example.demo.api.path}")
  String contextPath;

  @Bean
  ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
    ServletRegistrationBean<CamelHttpTransportServlet> servlet =
        new ServletRegistrationBean<>(new CamelHttpTransportServlet(), this.contextPath + "/*");
    servlet.setName("CamelServlet");
    return servlet;
  }
}
