package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import com.mycompany.entapp.snowman.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(int userId) {
        return userRepository.findUser(userId);
    }

    @Override
    public void createUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.removeUser(userId);
    }
}
