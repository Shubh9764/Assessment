package com.abkmutliservices.orgmanagement.exceptions;

public class MySQLIntegrityConstraintViolationException extends RuntimeException {
    public MySQLIntegrityConstraintViolationException(String message) {
        super(message);
    }
}
