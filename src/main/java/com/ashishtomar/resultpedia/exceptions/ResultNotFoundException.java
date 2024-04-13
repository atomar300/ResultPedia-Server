package com.ashishtomar.resultpedia.exceptions;

public class ResultNotFoundException extends RuntimeException{
    public ResultNotFoundException(String message) {
        super(message);
    }

    public ResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultNotFoundException(Throwable cause) {
        super(cause);
    }
}
