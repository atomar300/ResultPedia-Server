package com.ashishtomar.resultpedia.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {

    private boolean success = false;

    private int statusCode;

    private LocalDateTime timestamp;

    private String message;


    public ErrorMessage(int statusCode, LocalDateTime timestamp, String message){
        this.statusCode =statusCode;
        this.timestamp =timestamp;
        this.message = message;
    }

    public boolean getSuccess(){
        return success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

}
