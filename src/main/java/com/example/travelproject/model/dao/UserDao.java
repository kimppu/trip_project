package com.example.travelproject.model.dao;

import com.example.travelproject.model.entity.UserEntity;

public interface UserDao {
    

    public void deleteUser(String userId);

    public UserEntity findByUserId(String userId);

    public void insertUser(UserEntity entity);

    public void updateUser(UserEntity entity);
}
