package com.redeyes.registration.util;

import org.springframework.validation.BindingResult;

/**
 * A class to represent response to {@code User} fields validation.
 *
 * @author Dmytro Briukhatskyi
 */
public class UserValidationResult {

    /**
     * Validation success.
     */
    private boolean success;

    /**
     * Invalid email field.
     */
    private boolean invalidEmail;

    /**
     * Invalid password field.
     */
    private boolean invalidPassword;

    /**
     * Error message to display in the UI.
     */
    private String message;

    /**
     * @param errorMessage Error message.
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

        StringBuilder messageBuilder = new StringBuilder();

        if (invalidEmail) {
            messageBuilder.append("Please, provide a valid e-mail address!\n");
        }

        if (invalidPassword) {
            messageBuilder.append("Password should contain at least two numbers "
                    + "and one exclamation mark!");
        }

        message = messageBuilder.toString();
    }

    /**
     * @return the success flag
     */
    public final boolean isSuccess() {
        return success;
    }

    /**
     * @return the invalidEmail
     */
    public final boolean isInvalidEmail() {
        return invalidEmail;
    }

    /**
     * @return the invalidPassword
     */
    public final boolean isInvalidPassword() {
        return invalidPassword;
    }

    /**
     * @return current message
     */
    public final String getMessage() {
        return message;
    }

}
