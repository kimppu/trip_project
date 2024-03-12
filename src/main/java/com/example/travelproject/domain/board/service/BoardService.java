package com.example.travelproject.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelproject.domain.board.model.dao.BoradDao;
import com.example.travelproject.domain.board.model.dto.BoardDto;
import com.example.travelproject.domain.board.model.entity.BoardEntity;

@Service
public class BoardService {

    @Autowired
    private BoradDao boradDao; 

    // 글 작성 : insert
    public void saveNotice(BoardDto dto){
        BoardEntity entity = new BoardEntity(); 
        entity.setNoticeId(dto.getNoticeId());
        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setContents(dto.getContents());
        entity.setViewCnt(dto.getViewCnt());
        entity.setCreateDate(dto.getCreateDate());
        
        boradDao.saveNotice(entity);
    }


    // // 글 수정 : update
    public void updateNotice(BoardDto dto){
        BoardEntity entity = boradDao.selectByNotice(dto.getNoticeId());
        boradDao.updateNotice(entity);
    }

    // 글 삭제 : delete
    public void deleteNotice(long noticeId){
        BoardEntity entity = boradDao.selectByNotice(noticeId);
        boradDao.deleteNotice(entity.getNoticeId());
    }

    public BoardDto selectByNotice(long noticeId){
        BoardEntity entity = boradDao.selectByNotice(noticeId);
        BoardDto dto = new BoardDto(); 
        dto.setNoticeId(noticeId);
        dto.setUserId(entity.getUserId());
        dto.setTitle(entity.getTitle());
        dto.setContents(entity.getContents());
        dto.setViewCnt(entity.getViewCnt());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }
    
}
