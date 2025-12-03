package com.elder.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

    // Sobrepor o construtor basico que recebe um String msg
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

}
