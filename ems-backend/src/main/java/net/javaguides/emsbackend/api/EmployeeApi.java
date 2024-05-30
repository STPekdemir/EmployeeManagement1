package net.javaguides.emsbackend.api;

import lombok.Generated;
import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface EmployeeApi {

    @PostMapping
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto);

    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{user_name}")
    ResponseEntity<? extends Dto> getEmployeeByUsername(@PathVariable("user_name") String employeeUsername);

    @GetMapping
    ResponseEntity<List<?extends Dto>>getAllEmployees();


    @PutMapping("{userName}")
    public ResponseEntity<? extends Dto>updateEmployee(@PathVariable  ("userName") String employeeUsername,
                                                     @RequestBody EmployeeDto updatedEmployee);

@DeleteMapping("/")
    ResponseEntity<String>deleteEmployee(@RequestBody EmployeeDto employeeDto);
}
