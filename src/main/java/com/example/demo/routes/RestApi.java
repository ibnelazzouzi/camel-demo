package com.example.demo.routes;

import javax.ws.rs.core.MediaType;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.demo.model.Customer;

@Component
public class RestApi extends RouteBuilder {

  @Value("${server.port}")
  String serverPort;

  @Value("${com.example.demo.api.path}")
  String contextPath;

  @Override
  public void configure() throws Exception {

    this.restConfiguration().contextPath(this.contextPath) //
        .port(this.serverPort)
        .enableCORS(true)
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "Test REST API")
        .apiProperty("api.version", "v1")
        .apiProperty("cors", "true") // cross-site
        .apiContextRouteId("doc-api")
        .component("servlet")
        .bindingMode(RestBindingMode.json)
        .dataFormatProperty("prettyPrint", "true");

    this.rest("/api/").description("Customer operations")
        .id("api-route")
        .enableCORS(true)
        .produces(MediaType.APPLICATION_JSON)
        .consumes(MediaType.APPLICATION_JSON)
        .bindingMode(RestBindingMode.auto)

        .get("/customers")
        .route()
        .to("bean:customerService?method=listCustomers")
        .removeHeaders("*")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, this.constant(200))
        .endRest()

        .post("/customers")
        .type(Customer.class)
        .outType(String.class)
        .route()
        .id("create-customer")
        .to("bean:customerService?method=createCustomer")
        .log(">>> response : ${body}")
        .setBody(this.simple("Hello ${body.firstName} your account is created"))
        .removeHeaders("*")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, this.constant(201))
        .endRest();
  }

}
