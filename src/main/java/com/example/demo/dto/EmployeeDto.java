package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class EmployeeDto {

    @JsonProperty("Fleets")
    private List<String> fleets;

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Employees")
    private List<EmployeesItem> employees;

    @JsonProperty("Division")
    private String division;

    @JsonProperty("Caption")
    private String caption;

    @JsonProperty("Created")
    private String created;

}
