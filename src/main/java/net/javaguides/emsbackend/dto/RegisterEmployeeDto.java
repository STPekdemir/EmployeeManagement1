package net.javaguides.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployeeDto implements Dto{
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

}
