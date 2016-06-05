package com.redeyes.registration.util;

import com.redeyes.registration.model.Email;
import com.redeyes.registration.model.User;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;

import static com.redeyes.registration.controller.ConfirmController.CONFIRM_URI;

/**
 * Create email message.
 */
@Component
public final class EmailConstructor {

    /**
     * Non.. constructor.
     */
    public EmailConstructor() {
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
     * @param request Servlet request.
     * @return Email message.
     */
    public Email createForUser(final User user, final HttpServletRequest request) {
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
     * @param request Servlet request.
     * @return Confirmation link.
     */
    private String getConfirmLink(final User user, final HttpServletRequest request) {
        String appURI = request.getRequestURI();
        StringBuffer appURL = request.getRequestURL();
        String url = appURL.substring(0, appURL.lastIndexOf(appURI));
        return url + CONFIRM_URI + "/"
                + Base64Utils.encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes());
    }

    /**
     * Creating email text.
     *
     * @param user    User to create email text.
     * @param request Servlet request.
     * @return Email text.
     */
    private String getEmailText(final User user, final HttpServletRequest request) {
        Template template = velocityEngine.getTemplate("email.vm");
        VelocityContext context = new VelocityContext();
        context.put("email", user.getEmail());
        context.put("pass", getStarPass(user));
        context.put("link", getConfirmLink(user, request));

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }
}
