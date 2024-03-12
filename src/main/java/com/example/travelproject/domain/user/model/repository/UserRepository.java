package com.example.travelproject.domain.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.domain.user.model.entity.UserEntity;

public interface  UserRepository extends JpaRepository<UserEntity,String>{
    @Query(value = "select * from user where user_id = :user_id", nativeQuery = true)
    public UserEntity getUserDtoById(@Param(value = "user_id") String name);

}
