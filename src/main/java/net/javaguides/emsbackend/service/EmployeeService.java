package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByuserName(String employeeUsername);

    List<EmployeeDto>getAllEmployees();

    EmployeeDto updateEmployee(String employeeUsername,EmployeeDto updatedEmployee);

    void deleteEmployee(EmployeeDto employeeDto);

}
