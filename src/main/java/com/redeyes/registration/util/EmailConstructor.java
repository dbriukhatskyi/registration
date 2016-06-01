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

        StringBuilder emailText = new StringBuilder();

        char[] chars = user.getPassword().toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            chars[i] = '*';
        }
        String passStar = new String(chars);

        String link = "http://localhost:8080/confirm/"
                + Base64Utils.encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes());

        emailText.append("<h1>Thank you for registration.</h1><br>")
                .append("You have succesfully created account on our site.<br>")
                .append("You email is ").append(user.getEmail()).append(" and you pass ends on ").append(passStar)
                .append("<br><br>")
                .append("To confirm your account please click on this link<br>")
                .append(link);
        email.setEmailText(emailText.toString());
        return email;
    }
}
