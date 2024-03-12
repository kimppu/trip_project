package com.example.travelproject.domain.board.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "Article")
public class BoardEntity {

    // private UserEntity userEntity; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long noticeId; 

    @ManyToOne()
    private String userId; //작성자
    @Column(nullable = false)
    private String title; 
    private String contents;
    private String noticePw;
    private int viewCnt;
    @CreationTimestamp
    private java.sql.Timestamp createDate;

}
