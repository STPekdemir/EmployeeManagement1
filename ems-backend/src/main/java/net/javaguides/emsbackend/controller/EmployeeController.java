package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.api.EmployeeApi;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeApi {

    private EmployeeService employeeService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    public  ResponseEntity<EmployeeDto> getEmployeeByUsername(String employeeUsername){
        EmployeeDto employeeDto=employeeService.getEmployeeByuserName(employeeUsername);
        return ResponseEntity.ok(employeeDto);
    }

    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
        System.out.println("get all employees");
        List<EmployeeDto> employees =employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{userName}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("userName") String employeeUsername,
                                                     @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto= employeeService.updateEmployee(employeeUsername,updatedEmployee);

        return ResponseEntity.ok(employeeDto);
    }

}
