package com.abkmutliservices.orgmanagement.exceptions;


import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errMap = new HashMap<>();
        for (FieldError err : ex.getFieldErrors()) {
            errMap.put(err.getField(), err.getDefaultMessage());
        }
        return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();

        Map<String, String> errMap = new HashMap<>();
        errMap.put("message",ex.getMessage());

        return new ResponseEntity<>(errMap, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException ex) {
        Map<String, String> errMap = new HashMap<>();
        errMap.put("message",ex.getMessage());
        return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MyUnqiueContraintException.class)
    public ResponseEntity<?> handleMyUnqiueContraintException(MyUnqiueContraintException ex) {
        Map<String, String> errMap = new HashMap<>();
        errMap.put("message",ex.getMessage());
        return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
    }
}
