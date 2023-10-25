package com.abkmutliservices.orgmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
