package com.example.travelproject.domain.article.model;

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
public class ArticleDto {
    
    private String title; 
    private String content; 

    public ArticleEntity toEntity(){
        return new ArticleEntity();
    } 
}
