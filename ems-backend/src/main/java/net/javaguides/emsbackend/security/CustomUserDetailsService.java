//package net.javaguides.emsbackend.security;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.repository.EmployeeRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


/*

    @Service
    @AllArgsConstructor
    public class CustomUserDetailsService implements UserDetailsService {

        private EmployeeRepository employeeRepository;

        @Override
        public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

            Employee employee = employeeRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

            Set<GrantedAuthority> authorities = employee.getRoles().stream()
                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toSet());

            return new org.springframework.security.core.userdetails.User(
                    usernameOrEmail,
                    employee.getPassword(),
                    authorities
            );
        }
    }



*/
