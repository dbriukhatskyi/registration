package com.redeyes.registration.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * A class to represent response to {@code User} fields validation.
 *
 * @author Dmytro Briukhatskyi
 * @author Oleksandr Dres
 */
public class UserValidationResult {

    /**
     * Indicates a successful validation result.
     */
    private boolean success;

    /**
     * Invalid e-mail field.
     */
    private boolean invalidEmail;

    /**
     * Invalid password field.
     */
    private boolean invalidPassword;

    /**
     * Not field-specific error message to display in the UI.
     */
    private String message;

    /**
     * An error message for e-mail field.
     */
    private String emailMessage;

    /**
     * An error message for password field.
     */
    private String passwordMessage;

    /**
     * Constructs a validation result from the given error message
     * with no specific field errors.
     *
     * @param errorMessage a message to set
     */
    public UserValidationResult(final String errorMessage) {
        success = false;
        message = errorMessage;
    }

    /**
     * Creates a new instance and initializes it with the information extracted from
     * the provided {@code BindingResult} instance.
     *
     * @param bindingResult validation result
     */
    public UserValidationResult(final BindingResult bindingResult) {
        success = !bindingResult.hasFieldErrors();
        invalidEmail = bindingResult.hasFieldErrors("email");
        invalidPassword = bindingResult.hasFieldErrors("password");

        StringBuilder emailMessageBuilder = new StringBuilder();
        StringBuilder passwordMessageBuilder = new StringBuilder();

        if (invalidEmail) {
            for (ObjectError error : bindingResult.getFieldErrors("email")) {
                emailMessageBuilder.append(error.getDefaultMessage() + "\n");
            }
        }

        emailMessage = emailMessageBuilder.toString();

        if (invalidPassword) {
            for (ObjectError error : bindingResult.getFieldErrors("password")) {
                passwordMessageBuilder.append(error.getDefaultMessage() + "\n");
            }
        }

        passwordMessage = passwordMessageBuilder.toString();
    }

    /**
     * @return the success flag
     */
    public final boolean isSuccess() {
        return success;
    }

    /**
     * @return the invalidEmail flag
     */
    public final boolean isInvalidEmail() {
        return invalidEmail;
    }

    /**
     * @return the invalidPassword flag
     */
    public final boolean isInvalidPassword() {
        return invalidPassword;
    }

    /**
     * @return current non-field-specific message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * @return the email field error message
     */
    public final String getEmailMessage() {
        return emailMessage;
    }

    /**
     * @param emailMessage a new email field error message to set
     */
    public final void setEmailMessage(final String emailMessage) {
        this.emailMessage = emailMessage;
    }

    /**
     * @return the password field error message
     */
    public final String getPasswordMessage() {
        return passwordMessage;
    }

    /**
     * @param newPasswordMessage a new password field error message to set
     */
    public final void setPasswordMessage(final String newPasswordMessage) {
        this.passwordMessage = newPasswordMessage;
    }

}
