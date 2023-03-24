package com.example.demo.mapper;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeesItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T04:24:53+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public List<Employee> mapToEmployee(List<EmployeesItem> employeeDtos) {
        if ( employeeDtos == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDtos.size() );
        for ( EmployeesItem employeesItem : employeeDtos ) {
            list.add( map( employeesItem ) );
        }

        return list;
    }

    @Override
    public Employee map(EmployeesItem dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFleet( dto.getFleet() );
        employee.setGender( dto.getGender() );
        employee.setExternalId( dto.getEmployeeId() );

        return employee;
    }
}
