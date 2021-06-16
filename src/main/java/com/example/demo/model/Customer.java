package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @ApiModelProperty(notes = "The first name", example = "Mohamed")
  private String firstName;
  @ApiModelProperty(notes = "The last name", example = "IBN EL AZZOUZI")
  private String lastName;
  @ApiModelProperty(notes = "The email", example = "mohamed-elazzouzi@yopmail.com")
  private String email;
  @ApiModelProperty(notes = "The password", example = "123")
  private String password;

}
