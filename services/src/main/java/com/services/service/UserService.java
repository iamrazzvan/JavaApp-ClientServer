package com.services.service;

import com.model.model.User;
import com.persistence.repository.IUserRepository;
import com.services.validation.IValidator;
import com.services.validation.UserValidator;

import java.util.Collection;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IValidator<User> validator;

    public UserService(final IUserRepository userRepository) {
        this.userRepository = userRepository;
        validator = new UserValidator();
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User newEntity) {
        validator.validateEntity(newEntity);
        userRepository.save(newEntity);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void update(User updatedEntity) {
        validator.validateEntity(updatedEntity);
        userRepository.update(updatedEntity);
    }

    @Override
    public Optional<User> getLogin(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }
}
