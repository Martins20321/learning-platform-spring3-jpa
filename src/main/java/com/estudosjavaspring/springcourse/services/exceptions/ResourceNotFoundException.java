package com.estudosjavaspring.springcourse.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource Not Found. Id " + id);
    }
}
