package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.LoginEmployeeDto;
import net.javaguides.emsbackend.dto.RegisterEmployeeDto;
import net.javaguides.emsbackend.entity.Employee;

public interface AuthenticationService {

    Employee signup(RegisterEmployeeDto input);
    Employee authenticate(LoginEmployeeDto input);

}