package com.example.travelproject.model.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.BoardDao;
import com.example.travelproject.model.entity.BoardEntity;
import com.example.travelproject.model.repository.BoardRepository;

@Service
public class BoardDaoImpl implements BoardDao{

    @Autowired
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
    public BoardEntity findByNoticeId(long noticeId){
        return boardRepository.findByNoticeId(noticeId);
    }

    // 게시글 목록 : show
    public List<BoardEntity> findNoticeList(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
    }
}
