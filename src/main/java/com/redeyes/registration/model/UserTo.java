package com.redeyes.registration.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User transfer object.
 */
public class UserTo {
    /**
     * User email.
     */
    @Email
    private String email;

    /**
     * User password.
     */
    @NotEmpty
    private String password;

    /**
     * Non-parameter constructor.
     */
    public UserTo() {
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
