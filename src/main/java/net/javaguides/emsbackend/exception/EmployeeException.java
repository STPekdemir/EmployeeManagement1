package net.javaguides.emsbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class EmployeeException extends RuntimeException {
    private HttpStatus status;
    private String message;



}
