package net.javaguides.emsbackend.controller;

import net.javaguides.emsbackend.api.AuthenticationApi;
import net.javaguides.emsbackend.dto.LoginEmployeeDto;
import net.javaguides.emsbackend.dto.LoginResponseDto;
import net.javaguides.emsbackend.dto.RegisterEmployeeDto;
import net.javaguides.emsbackend.entity.Employee;

import net.javaguides.emsbackend.service.AuthenticationService;
import net.javaguides.emsbackend.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController implements AuthenticationApi {
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    public ResponseEntity<Employee> register(RegisterEmployeeDto registerUserDto) {
        Employee registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }


    public ResponseEntity<LoginResponseDto> authenticate(LoginEmployeeDto loginUserDto) {
        Employee authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
