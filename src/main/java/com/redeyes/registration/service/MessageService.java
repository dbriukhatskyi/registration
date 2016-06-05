package com.redeyes.registration.service;

import com.redeyes.registration.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Message service.
 */
public interface MessageService {
    /**
     * Send confirm email for user.
     * @param user User for confirm.
     * @param request Servlet request.
     */
    void sendConfirmToUser(final User user, HttpServletRequest request);
}
