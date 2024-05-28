package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto
                (
                        employee.getUserName(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),


                        employee.getUpdatedDate(),
                        employee.getCreatedDate(),
                        employee.getPassword(),
                        employee.getRoles()
                );


    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getEmail() == null) {
            // Email alanı null ise, burada uygun bir işlem yapılabilir.
            // Örneğin, bir hata fırlatılabilir veya varsayılan bir email atanabilir.
           throw new IllegalArgumentException("Email cannot be null");
       }
        return new Employee
                (
                        employeeDto.getUserName(),
                        employeeDto.getFirstName(),
                        employeeDto.getLastName(),
                       employeeDto.getEmail(),


                        employeeDto.getUpdatedDate(),
                        employeeDto.getCreatedDate(),
                        employeeDto.getPassword(),
                        employeeDto.getRoles()


                );
    }
}
