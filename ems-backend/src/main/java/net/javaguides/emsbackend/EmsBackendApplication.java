package net.javaguides.emsbackend;

import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.entity.Role;
import net.javaguides.emsbackend.repository.EmployeeRepository;
import net.javaguides.emsbackend.repository.RoleRepository;
import net.javaguides.emsbackend.service.impl.EmployeeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


//@EnableJpaRepositories(basePackages = "net.javaguides.emsbackend.repository")
//@EntityScan(basePackages = "net.javaguides.emsbackend.entity")
@SpringBootApplication
public class EmsBackendApplication {





	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);


	}

}
