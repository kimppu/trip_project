package com.example.travelproject.service;

import com.example.travelproject.model.entity.UserEntity;


public interface UserService {

    public void deleteUser(String userId);

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin);

    public void joinUserDto(UserEntity dto);

    public void updateUserDto(UserEntity dto);

}
