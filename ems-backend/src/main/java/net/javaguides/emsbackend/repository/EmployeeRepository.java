package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Employee;
import org.hibernate.jpa.spi.JpaCompliance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

  /*  Optional<Employee>findByUserName(String userName);
    Boolean existsByEmail(String email);

    Optional<Employee>findByUserNameOrEmail(String username,String email);

   */
}
