package com.example.travelproject.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao{
        
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
