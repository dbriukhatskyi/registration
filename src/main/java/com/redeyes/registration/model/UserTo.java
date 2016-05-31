package com.redeyes.registration.model;

public class UserTo {
    private String email;

    private String password;

    public UserTo() {
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

    public User asUser() {
        return new User(this.email, this.password);
    }
}
