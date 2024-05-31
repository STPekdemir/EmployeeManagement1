package net.javaguides.emsbackend.api;

import net.javaguides.emsbackend.dto.LoginEmployeeDto;
import net.javaguides.emsbackend.dto.LoginResponseDto;
import net.javaguides.emsbackend.dto.RegisterEmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationApi {


    @PostMapping("/signup")
    public ResponseEntity<Employee> register(@RequestBody RegisterEmployeeDto registerUserDto);
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginEmployeeDto loginUserDto);
}
