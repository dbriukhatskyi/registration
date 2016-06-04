package com.redeyes.registration.model;

/**
 * User model.
 */
public class User {

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
    public final boolean isConfirmed() {
        return isConfirmed;
    }

    /**
     * User email.
     *
     * @return User confirmed.
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

    @Override
    public final String toString() {
        return "User{"
                + "email='" + email + '\''
                + ", password='" + password + '\''
                + ", isConfirmed=" + isConfirmed
                + '}';
    }
}
