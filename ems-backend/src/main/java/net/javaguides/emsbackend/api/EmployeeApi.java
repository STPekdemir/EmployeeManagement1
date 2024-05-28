package net.javaguides.emsbackend.api;

import lombok.Generated;
import net.javaguides.emsbackend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


public interface EmployeeApi {

    @PostMapping
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto);

    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{user_name}")
    ResponseEntity<EmployeeDto> getEmployeeByUsername(@PathVariable("user_name") String employeeUsername);
}
