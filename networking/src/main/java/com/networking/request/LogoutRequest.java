package com.networking.request;

import com.model.model.User;

public class LogoutRequest implements Request {
    private final User user;

    public LogoutRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
