package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User findUser(int userId) {
        return userJpaRepository.findById(userId).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public void removeUser(int userId) {
        userJpaRepository.deleteById(userId);
    }
}
