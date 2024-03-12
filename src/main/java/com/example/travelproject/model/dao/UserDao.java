package com.example.travelproject.model.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;

public class UserDao {
    
    @Autowired
    private UserRepository userRepository;

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public UserEntity findByUserId(String userId) {
        return userRepository.getUserDtoById(userId);
    }

    public void insertUser(UserEntity entity) {
        userRepository.save(entity);
    }

    public void updateUser(UserEntity entity) {
        userRepository.save(entity);
    }
}
