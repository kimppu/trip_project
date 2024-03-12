package com.example.travelproject.domain.article.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class ArticleEntity {
    @Id
    @GeneratedValue    
    private long articleId; 

    private String title; 
    private String content; 
    private String subject; //작성자
    private String pwd;
    private long view;
    private String date;

    public ArticleEntity(long articleId, String title, String content){
        this.articleId = articleId; 
        this.title = title;
        this.content = content; 
    }
}
