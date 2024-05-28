//package net.javaguides.emsbackend.service.impl;
/*
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.dto.RegisterDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.repository.EmployeeRepository;
import net.javaguides.emsbackend.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;

   /* @Override
    public String register(EmployeeDto employeeDto) {;
        Employee employee = new Employee();
        employee.setUserName(employeeDto.getUserName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setRoles(roleRepository.findByName("ROLE_USER"));
        employeeRepository.save(employee);
        return "User Registered Successfully";
    } */


//}

