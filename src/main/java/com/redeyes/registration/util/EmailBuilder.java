package com.redeyes.registration.util;

import static com.redeyes.registration.controller.ConfirmController.CONFIRM_URI;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.redeyes.registration.model.Email;
import com.redeyes.registration.model.User;

/**
 * Create email message.
 */
@Component
public final class EmailBuilder {
    /**
     * A default constructor.
     */
    public EmailBuilder() {
    }

    /**
     * Velocity engine.
     */
    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * Create email message for user.
     *
     * @param user    User.
     * @param request
     * @return Email message.
     */
    public Email createForUser(final User user, HttpServletRequest request) {
        Email email = new Email();
        email.setRecipient(user.getEmail());
        email.setSubject("Confirm your email!");
        email.setEmailText(getEmailText(user, request));
        return email;
    }

    /**
     * Hides the password behind the asterisks.
     *
     * @param user User to hide password.
     * @return Hidden password string.
     */
    private String getStarPass(final User user) {
        char[] chars = user.getPassword().toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }

    /**
     * Returned confirm link.
     *
     * @param user    User for confirm.
     * @param request
     * @return Confirmation link.
     */
    private String getConfirmationLink(final User user, HttpServletRequest request) {
        String URI = request.getRequestURI();
        StringBuffer URL = request.getRequestURL();
        String url = URL.substring(0, URL.lastIndexOf(URI));
        return url + CONFIRM_URI + "/"
                + Base64Utils.encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes());
    }

    /**
     * Creating email text.
     *
     * @param user    User to create email text.
     * @param request
     * @return Email text.
     */
    private String getEmailText(final User user, HttpServletRequest request) {
        Template template = velocityEngine.getTemplate("email.vm");
        VelocityContext context = new VelocityContext();
        context.put("email", user.getEmail());
        context.put("pass", getStarPass(user));
        context.put("link", getConfirmationLink(user, request));

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }
}
