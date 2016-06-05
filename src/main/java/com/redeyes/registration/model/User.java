package com.redeyes.registration.model;

import java.util.Objects;

/**
 * User model.
 */
public final class User {

    /**
     * User email.
     */
    private String email;

    /**
     * User password.
     */
    private String password;

    /**
     * User confirmed.
     */
    private boolean isConfirmed = false;

    /**
     * Non-parameter constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param mail User email.
     * @param pass User password.
     */
    public User(final String mail, final String pass) {
        this.email = mail;
        this.password = pass;
    }

    /**
     * Constructor.
     *
     * @param mail      User email.
     * @param pass      User password.
     * @param confirmed User confirmed.
     */
    public User(final String mail, final String pass, final boolean confirmed) {
        this.email = mail;
        this.password = pass;
        this.isConfirmed = confirmed;
    }

    /**
     * User confirmed.
     *
     * @return User confirmed.
     */
    public boolean isConfirmed() {
        return isConfirmed;
    }

    /**
     * User email.
     *
     * @return User confirmed.
     */
    public String getEmail() {
        return email;
    }

    /**
     * User password.
     *
     * @return User password.
     */
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(final Object o) {
        User user = (User) o;
        return isConfirmed() == user.isConfirmed()
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), isConfirmed());
    }

    @Override
    public String toString() {
        return "User{"
                + "email='" + email + '\''
                + ", password='" + password + '\''
                + ", isConfirmed=" + isConfirmed
                + '}';
    }
}
