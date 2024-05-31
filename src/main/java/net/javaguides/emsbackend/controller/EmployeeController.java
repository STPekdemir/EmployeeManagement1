package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.api.EmployeeApi;
import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.dto.ErrorMessageDto;
import net.javaguides.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    public  ResponseEntity< ? extends Dto> getEmployeeByUsername(String employeeUsername){
        try{
            EmployeeDto employeeDto=employeeService.getEmployeeByuserName(employeeUsername);
            return ResponseEntity.ok(employeeDto);
        }catch (Exception e){
            ErrorMessageDto errorMessageDto=new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
        }

    }

    //@PreAuthorize("hasAnyRole('ADMIN','USER')")

    public ResponseEntity<List<?extends Dto>>getAllEmployees() {
        try {
            List<EmployeeDto> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);

        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(List.of(errorMessageDto), HttpStatus.NOT_FOUND);
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<? extends Dto>updateEmployee(String employeeUsername,
                                                      EmployeeDto updatedEmployee){
        try{
            EmployeeDto employeeDto= employeeService.updateEmployee(employeeUsername,updatedEmployee);
            return ResponseEntity.ok(employeeDto);
        }catch (Exception e){
            ErrorMessageDto errorMessageDto=new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);


        }

    }

public ResponseEntity<String>deleteEmployee(EmployeeDto employeeDto) {
    try {
        employeeService.deleteEmployee(employeeDto);
        return ResponseEntity.ok("Deleted Successfully");
    } catch (Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}

}
