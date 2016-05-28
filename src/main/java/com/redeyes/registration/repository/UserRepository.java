package com.redeyes.registration.repository;

import com.redeyes.registration.model.User;

public interface UserRepository {
    int save(User user);

    User getByEmail(String email);

    void update(User user);
}
