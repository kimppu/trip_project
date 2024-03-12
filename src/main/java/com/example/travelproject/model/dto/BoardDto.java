package com.example.travelproject.model.dto;

import com.example.travelproject.model.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

    private long noticeId; 
    private String userId; 
    private String title; 
    private String contents;
    private int viewCnt;
    private java.sql.Timestamp createDate;
}
