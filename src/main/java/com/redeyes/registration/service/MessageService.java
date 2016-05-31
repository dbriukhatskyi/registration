package com.redeyes.registration.service;

import com.redeyes.registration.model.User;

public interface MessageService {
    void sendConfirmToUser(User user);
}
