package com.ashishtomar.resultpedia.dto;


import com.ashishtomar.resultpedia.models.User;

public class UserResponse {

    // default value is true
    private boolean success = true;

    private User user;

    private String token;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
