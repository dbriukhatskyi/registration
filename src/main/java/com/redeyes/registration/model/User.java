package com.redeyes.registration.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class User {
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = ".*!.*")
    private String password;

    private boolean is_confirmed = false;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, boolean is_confirmed) {
        this.email = email;
        this.password = password;
        this.is_confirmed = is_confirmed;
    }

    public boolean is_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed(boolean is_confirmed) {
        this.is_confirmed = is_confirmed;
    }

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


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_confirmed=" + is_confirmed +
                '}';
    }
}
