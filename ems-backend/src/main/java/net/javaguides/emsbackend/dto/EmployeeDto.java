package net.javaguides.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.emsbackend.entity.Role;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Date updatedDate;
    private Date createdDate;
    private String password;
    private Set<Role> roles;
}
