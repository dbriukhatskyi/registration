package com.redeyes.registration.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class User {
    @Email
    private String email;
    @NotNull
    private String password;
    private boolean is_confirmed = false;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public boolean is_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed(boolean is_confirmed) {
        this.is_confirmed = is_confirmed;
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
