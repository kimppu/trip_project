package com.example.travelproject.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    // @ManyToOne
    // @JoinColumn(name = "userId")
    private String userId; //작성자
    @Column(nullable = false)
    private String title; 
    private String contents;
    private String noticePw;
    private int viewCnt;
    @CreationTimestamp
    private java.sql.Timestamp createDate;

}
