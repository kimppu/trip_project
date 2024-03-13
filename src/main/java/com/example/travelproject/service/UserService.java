package com.example.travelproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


public interface UserService {

    public void deleteUser(String userId);

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin);

    public void joinUserDto(UserEntity dto);

    public void updateUserDto(UserEntity dto) ;

}
