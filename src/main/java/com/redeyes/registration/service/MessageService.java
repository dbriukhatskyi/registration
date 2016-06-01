package com.redeyes.registration.service;

import com.redeyes.registration.model.User;

/**
 * Message service.
 */
public interface MessageService {
    /**
     * Send confirm email for user.
     * @param user User for confirm.
     */
    void sendConfirmToUser(final User user);
}
