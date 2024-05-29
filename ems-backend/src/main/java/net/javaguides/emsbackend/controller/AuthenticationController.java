package net.javaguides.emsbackend.controller;

import net.javaguides.emsbackend.dto.LoginEmployeeDto;
import net.javaguides.emsbackend.dto.LoginResponseDto;
import net.javaguides.emsbackend.dto.RegisterEmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.service.impl.AuthenticationService;
import net.javaguides.emsbackend.service.impl.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Employee> register(@RequestBody RegisterEmployeeDto registerUserDto) {
        Employee registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginEmployeeDto loginUserDto) {
        Employee authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
