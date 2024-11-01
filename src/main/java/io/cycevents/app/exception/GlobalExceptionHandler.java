package io.cycevents.app.exception;

import io.cycevents.app.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicatesFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse handleDuplicateFoundException(DuplicatesFoundException ex){
        return ApiResponse.builder()
                .msg(ex.getMessage())
                .status(false)
                .build();
    }




    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse handleResourceNotFOund(ResourceNotFoundException ex){
        return ApiResponse.builder()
                .msg(ex.getMessage())
                .status(false)
                .build();
    }
}
