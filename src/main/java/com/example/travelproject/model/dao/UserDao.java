package com.example.travelproject.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;

public interface UserDao {
    

    public void deleteUser(String userId);

    public UserEntity findByUserId(String userId);

    public void insertUser(UserEntity entity);

    public void updateUser(UserEntity entity);
}
