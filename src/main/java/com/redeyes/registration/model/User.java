package com.redeyes.registration.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Dmytro Briukhatskyi
 *
 */
public class User {
    /** User's e-mail address. */
    @Email
    private String email;

    /** User's password. */
    @Size(min = 1, max = 2)
    private String password;

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param eml the email to set
     */
    public final void setEmail(final String eml) {
        this.email = eml;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param pwd the password to set
     */
    public final void setPassword(final String pwd) {
        this.password = pwd;
    }

    /**
     *
     */
    @Override
    public final String toString() {
        return "{ "
                + "'email': '"
                + email
                + "', 'password': '"
                + password
                + "' }";
    }
}
