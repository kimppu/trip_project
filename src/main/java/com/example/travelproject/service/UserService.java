package com.example.travelproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public void deleteUser(String userId) {
        UserEntity entity = userDao.findByUserId(userId);
        userDao.deleteUser(entity.getUserId());
    }

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin) {
        UserEntity dto = userRepository.getUserDtoById(id);
        dto.setIsLogin(isLogin);
        userRepository.save(dto);
    }

    public void joinUserDto(UserEntity dto) {
        
        // 권한 적용 
        dto.setRole("USER");
        if(dto.getUserId().equals("admin")) {
            dto.setRole("ADMIN");
        } else if(dto.getUserId().equals("manager")) {
            dto.setRole("MANAGER");
        }

        // 비밀번호 암호화 적용
        String rawPwd = dto.getUserPw();
        String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
        dto.setUserPw(encodedPwd);

        dto.setIsLogin(false);

        // 신규 유저 database에 저장!!
        userRepository.save(dto);
    }

    public void updateUserDto(UserEntity dto) {
        log.info("[UserService][dto]: " + dto);
        UserEntity entity = userRepository.getUserDtoById(dto.getUserId());
        log.info("[UserService][entity]: " + entity);
        
        if (dto.getUserNm() != null) {
            entity.setUserNm(dto.getUserNm());
        }
        if (dto.getUserPw() != null) {
            // 비밀번호 암호화 적용
            String rawPwd = dto.getUserPw();
            String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
            entity.setUserPw(encodedPwd);
        }
        log.info("[UserService]: " + entity);
        userRepository.save(entity);
        
    }

}
