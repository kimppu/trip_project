package com.example.travelproject.model.dto;

import java.sql.Timestamp;
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
public class CommentDto {

    private long commentId;
    private String notice; // 게시판 엔티티에 대한 참조
    private String user; // 사용자 엔티티에 대한 참조
    private String contents;
    private Timestamp createDate;

    // 기본 생성자, 전체 파라미터 생성자, Getter, Setter, ToString 메소드는 Lombok 어노테이션을 통해 자동 생성
}

