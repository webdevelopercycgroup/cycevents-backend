package io.cycevents.app.exception;

public class DuplicatesFoundException extends RuntimeException {
    public DuplicatesFoundException(String msg) {
        super(msg);
    }
}
