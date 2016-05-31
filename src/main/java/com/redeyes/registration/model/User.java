package com.redeyes.registration.model;

public class User {

    private String email;

    private String password;

    private boolean isConfirmed = false;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, boolean isConfirmed) {
        this.email = email;
        this.password = password;
        this.isConfirmed = isConfirmed;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
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
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
