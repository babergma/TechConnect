package com.techelevator.validation.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Login {

    @NotBlank(message="Please enter an email")
    @Email(message="Please enter an email")
    private String email;

    @NotBlank(message="Please enter a password")
    private String password;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}