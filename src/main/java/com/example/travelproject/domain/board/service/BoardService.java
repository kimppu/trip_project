package com.example.travelproject.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelproject.domain.board.model.dto.BoardDto;
import com.example.travelproject.domain.board.model.entity.BoardEntity;
import com.example.travelproject.domain.board.model.repository.BoardRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository articleRepository; 

    public void saveArticle(BoardDto dto){
        //1. dto -> entity
        BoardEntity article = dto.get(); 
        //2. repository에게 entity를 db에 저장
        articleRepository.save(article);
    }
    
}
