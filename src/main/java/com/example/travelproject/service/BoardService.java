package com.example.travelproject.service;
import java.util.List;

import com.example.travelproject.model.dto.BoardDto;


public interface BoardService {
    // 글 작성 : insert
    public void saveNotice(BoardDto dto);

    // // 글 수정 : update
    public void updateNotice(BoardDto dto);

    // 글 삭제 : delete
    public void deleteNotice(long noticeId);

    public BoardDto findtByNoticeId(long noticeId);

    public List<BoardDto> findNoticeList();
    
}
