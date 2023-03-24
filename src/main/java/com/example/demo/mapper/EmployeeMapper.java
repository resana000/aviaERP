package com.example.demo.mapper;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeesItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    List<Employee> mapToEmployee(List<EmployeesItem> employeeDtos);

    @Mapping(target = "fleet", source = "dto.fleet")
    @Mapping(target = "gender", source = "dto.gender")
    @Mapping(target = "externalId", source = "dto.employeeId")
    Employee map(EmployeesItem dto);

}
