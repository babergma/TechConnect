package com.techelevator.validation.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {

    @NotBlank(message="*")
    private String firstName;

    @NotBlank(message="*")
    private String lastName;

    @NotBlank(message="Invalid email")
    @Email(message="Please enter an email")
    private String email;

    @NotBlank(message="Email address does not match")
    @Email(message="Please enter an email")
    private String verifyEmail;

    @Length(min=8, message="Password minimum is 8 characters")
    private String password;

    @NotBlank(message="Passwords do not match")
    private String verifyPassword;

    @NotNull(message = "Birthday is required!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @NotNull(message="# of Tickets must be between 1 and 10")
    @Range(min=1, max=10, message="# of Tickets must be between 1 and 10")
    private int tickets;

    private boolean passwordMatching;
    @AssertTrue(message="Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(verifyPassword);
        }
        else {
            return false;
        }
    }

    private boolean emailMatching;
    @AssertTrue(message="Emails must match")
    public boolean isEmailMatching() {
        if (email != null) {
            return email.equals(verifyEmail);
        }
        else {
            return false;
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getVerifyEmail() {
        return verifyEmail;
    }
    public void setVerifyEmail(String verifyEmail) {
        this.verifyEmail = verifyEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getVerifyPassword() {
        return verifyPassword;
    }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

}