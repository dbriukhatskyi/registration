package com.redeyes.registration.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User transfer object.
 */
public class RegistrationForm {
    /**
     * User email.
     */
    @NotBlank(message = "E-mail address should not be blank!")
    @Email(message = "Please provide a valid e-mail address!")
    private String email;

    /**
     * User password.
     */
    @Pattern(regexp = ".+", message = "Password should contain at least two numbers and one exclamation mark!")
    private String password;

    /**
     * Non-parameter constructor.
     */
    public RegistrationForm() {
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
     * @param newEmail User email.
     */
    public final void setEmail(final String newEmail) {
        this.email = newEmail;
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
     * @param newPassword User password.
     */
    public final void setPassword(final String newPassword) {
        this.password = newPassword;
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
