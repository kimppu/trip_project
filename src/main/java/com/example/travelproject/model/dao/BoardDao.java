package com.example.travelproject.model.dao;

import java.util.List;

import com.example.travelproject.model.entity.BoardEntity;

public interface BoardDao {
    
    // 글 작성 : insert
    public void saveNotice(BoardEntity entity);
    // 글 수정 : update
    public void updateNotice(BoardEntity entity);
    // 글 삭제 : delete
    public void deleteNotice(long noticeId);
    // 게시글 선택 : select
    public BoardEntity findByNoticeId(long noticeId);
    // 게시글 목록 : show
    public List<BoardEntity> findNoticeList();
}
