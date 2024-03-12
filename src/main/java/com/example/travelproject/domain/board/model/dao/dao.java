package com.example.travelproject.domain.board.model.dao;

import com.example.travelproject.domain.board.model.entity.BoardEntity;
import com.example.travelproject.domain.board.model.repository.BoardRepository;

public class dao {
    private BoardRepository boardRepository; 

    // 글 작성 : insert
    public void saveNotice(BoardEntity entity){
        boardRepository.save(entity);
    }

    // 글 수정 : update
    public void updateNotice(BoardEntity entity){
        boardRepository.save(entity);

    }

    // 글 삭제 : delete
    public void deleteNotice(long noticeId){
        boardRepository.deleteById(noticeId);
    }

    public BoardEntity findByNotice(String title){
        return boardRepository.findByTitle(title);
    }
}
