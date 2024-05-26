package com.example.travelproject.service;

import java.util.List;

import com.example.travelproject.model.dto.UserDto;
import com.example.travelproject.model.entity.UserEntity;

public interface UserService {

    // public UserDto findByUserId(String userId);

    public void deleteUser(String userId);

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin);

    public void joinUserDto(UserEntity dto) throws Exception;

    public void updateUserDto(UserDto dto);

    public String findUserIdByEmail(String userNm, String userEmail) throws Exception;

    public UserDto findByUserId(String username);

    public UserDto findByUserEmail(String email);
    
    public List<UserEntity> findAllUser();

}
