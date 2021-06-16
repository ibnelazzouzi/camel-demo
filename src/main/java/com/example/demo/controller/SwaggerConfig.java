package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerConfig {

  @Value("${com.example.demo.api.path}")
  String contextPath;

  @RequestMapping("/swagger-ui")
  public String redirectToUi() {
    return "redirect:/webjars/swagger-ui/index.html?url=" + this.contextPath + "/api-doc&validatorUrl=";
  }
}
