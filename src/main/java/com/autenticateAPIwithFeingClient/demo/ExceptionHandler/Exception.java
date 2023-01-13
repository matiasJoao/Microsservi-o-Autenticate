package com.autenticateAPIwithFeingClient.demo.ExceptionHandler;

import com.autenticateAPIwithFeingClient.demo.DTO.ResponseDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class Exception extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity ArrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e){
        return new ResponseEntity("Token Inexistente", HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(FeignException.class)
    public ResponseEntity FeingExceptionHandler(FeignException e){
        ResponseDTO error = new ResponseDTO("Login ou senha invalidos", "403", HttpStatus.FORBIDDEN);
        return new ResponseEntity(error, HttpStatus.FORBIDDEN);
    }

}
