package com.shiva.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HostpitalNameNotFoundException.class)
    public ResponseEntity<ErrorResponse> hostpitalNameNotFoundException(HostpitalNameNotFoundException ex) {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorcode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessege(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HostpitalCityNotFoundException.class)
    public ResponseEntity<ErrorResponse> hostpitalCityNotFoundException(HostpitalCityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorcode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessege(ex.getMessage());
        logger.error(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);


    }

}
