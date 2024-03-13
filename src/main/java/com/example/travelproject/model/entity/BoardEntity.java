package com.example.travelproject.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity(name = "BoardEntity")
@Table(name = "board")
public class BoardEntity {

    // private UserEntity userEntity; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long noticeId; 

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; //작성자
=======
    // 작성자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; 

>>>>>>> e904f9c68548ae55d61206915510f98e09a35eca
    @Column(nullable = false)
    private String title; 
    private String contents;
    private String noticePw;
    private int viewCnt;
    @CreationTimestamp
    private java.sql.Timestamp createDate;

}
