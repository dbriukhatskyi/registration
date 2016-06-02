package com.redeyes.registration.util;

import com.redeyes.registration.model.Email;
import com.redeyes.registration.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

/**
 * Create email message.
 */
@Component
public final class EmailConstructor {
    /**
     * Non.. constructor.
     */
    private EmailConstructor() {
    }

    /**
     * Create email message for user.
     *
     * @param user User.
     * @return Email message.
     */
    public static Email createForUser(final User user) {
        Email email = new Email();
        email.setRecipient(user.getEmail());
        email.setSubject("Confirm your email!");
        email.setEmailText(getEmailText(user));
        return email;
    }

    /**
     * Hides the password behind the asterisks.
     *
     * @param user User to hide password.
     * @return Hidden password string.
     */
    private static String getStarPass(final User user) {
        char[] chars = user.getPassword().toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }

    /**
     * Returned confirm link.
     *
     * @param user User for confirm.
     * @return Confirmation link.
     */
    private static String getConfirmLink(final User user) {
        return "http://localhost:8080/confirm/"
                + Base64Utils.encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes());
    }

    /**
     * Creating email text.
     *
     * @param user User to create email text.
     * @return Email text.
     */
    private static String getEmailText(final User user) {
        StringBuilder emailText = new StringBuilder();
        emailText.append("<h1>Thank you for registration.</h1><br>")
                .append("You have succesfully created account on our site.<br>")
                .append("You email is ").append(user.getEmail()).append(" and you pass ends on ")
                .append(getStarPass(user))
                .append("<br><br>")
                .append("To confirm your account please click on this link<br>")
                .append(getConfirmLink(user));
        return emailText.toString();
    }
}
