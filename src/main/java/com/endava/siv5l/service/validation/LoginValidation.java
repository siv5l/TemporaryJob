package com.endava.siv5l.service.validation;


import javax.validation.constraints.Size;

/**
 * Created by siv5l on 4/12/16.
 */
public class LoginValidation {

    @Size(min=2,max=30)
    private String username;
    private String password;


    public LoginValidation(){}

    public LoginValidation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
