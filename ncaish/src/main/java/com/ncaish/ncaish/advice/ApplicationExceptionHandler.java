package com.ncaish.ncaish.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ncaish.ncaish.exception.EventFoundException;
import com.ncaish.ncaish.exception.EventNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EventNotFoundException.class)
    public Map< String,String> handlerBussinessException(EventNotFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());

        return errorMap;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EventFoundException.class)
    public Map< String,String> handlerException(EventFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
    
}
