package com.mycompany.entapp.snowman.domain.service;

import com.mycompany.entapp.snowman.domain.model.User;

public interface UserService {
    User getUser(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
