package com.example.travelproject.model.dao;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.travelproject.model.entity.BoardEntity;
import com.example.travelproject.model.repository.BoardRepository;

@Service
public class BoardDao {
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

    // 게시글 선택 : select
    public BoardEntity selectByNotice(long noticeId){
        return boardRepository.selectByNotice(noticeId);
    }

    // 게시글 목록 : show
    public List<BoardEntity> showAllPage(){
        return boardRepository.showAllPage();
    }

}
