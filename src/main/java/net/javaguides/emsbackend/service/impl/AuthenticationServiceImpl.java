package net.javaguides.emsbackend.service.impl;

import net.javaguides.emsbackend.dto.LoginEmployeeDto;
import net.javaguides.emsbackend.dto.RegisterEmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.entity.Role;
import net.javaguides.emsbackend.repository.EmployeeRepository;
import net.javaguides.emsbackend.repository.RoleRepository;
import net.javaguides.emsbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


  public RoleRepository roleRepository;

    public AuthenticationServiceImpl(
            RoleRepository roleRepository,
            EmployeeRepository employeeRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee signup(RegisterEmployeeDto input) {
        Employee user = new Employee();

        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setUserName(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        Role role= roleRepository.findById(1L).get();
        user.setRoles(Set.of(role));

        return employeeRepository.save(user);
    }

    public Employee authenticate(LoginEmployeeDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return employeeRepository.findByUserName(input.getUsername())
                .orElseThrow();
    }
}
