package io.cycevents.app.exception;

import jakarta.annotation.Resource;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
