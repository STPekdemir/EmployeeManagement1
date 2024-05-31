package net.javaguides.emsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//belirli kimliğe sahip employee veritabanında yoksa o zaman bu ResourceNotFoundExceptionı atacağız
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}



