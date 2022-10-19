package com.doanchuyennganh.ungtuyenvn.exception.model;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String message) {
        super(message);
    }
}
