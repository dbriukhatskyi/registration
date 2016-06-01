package com.redeyes.registration.model;

/**
 * User transfer object.
 */
public class UserTo {
    /**
     * User email.
     */
    private String email;

    /**
     * User password.
     */
    private String password;

    /**
     * Non-parameter constructor.
     */
    public UserTo() {
    }

    /**
     * User email.
     *
     * @return User email.
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Set user email.
     *
     * @param mail User email.
     */
    public final void setEmail(final String mail) {
        this.email = mail;
    }

    /**
     * User password.
     *
     * @return User password.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Set user password.
     *
     * @param pass User password.
     */
    public final void setPassword(final String pass) {
        this.password = pass;
    }

    /**
     * User.
     *
     * @return New User.
     */
    public final User asUser() {
        return new User(this.email, this.password);
    }
}
