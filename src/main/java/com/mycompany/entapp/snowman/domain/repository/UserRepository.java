package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.User;

public interface UserRepository {
    User findUser(int userId);
    void saveUser(User user);
    void removeUser(int userId);
}
