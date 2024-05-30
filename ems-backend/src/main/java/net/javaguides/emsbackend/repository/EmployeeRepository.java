package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Employee;
import org.hibernate.jpa.spi.JpaCompliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findByUserName(String userName);

   // @Query(value = "SELECT * FROM employees ORDER BY created_date DESC LIMIT 1", nativeQuery = true)
  //  List<Employee> returnLastEmployeeUserName();

}
