package com.services.service;

import com.model.model.User;

import java.util.Optional;

public interface IUserService extends IService<Long, User> {
    Optional<User> getLogin(String username, String password);
}
