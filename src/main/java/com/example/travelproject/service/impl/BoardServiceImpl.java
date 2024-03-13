package com.example.travelproject.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.BoardDao;
import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.dto.BoardDto;
import com.example.travelproject.model.entity.BoardEntity;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDao boradDao; 
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // bCryptPasswordEncoder.encode(rawPwd);

    public String encodingPassword(String pw){
        return bCryptPasswordEncoder.encode(pw);
    }
    // 글 작성 : insert
    public void saveNotice(BoardDto dto){
        BoardEntity entity = new BoardEntity(); 
        UserEntity userEntity = userDao.findByUserId(dto.getUserId());
        entity.setUser(userEntity);
        entity.setTitle(dto.getTitle());
        entity.setContents(dto.getContents());
        boradDao.saveNotice(entity);
    }


    // // 글 수정 : update
    public void updateNotice(BoardDto dto){
        BoardEntity entity = boradDao.findByNoticeId(dto.getNoticeId());
        boradDao.updateNotice(entity);
    }

    // 글 삭제 : delete
    public void deleteNotice(long noticeId){
        BoardEntity entity = boradDao.findByNoticeId(noticeId);
        boradDao.deleteNotice(entity.getNoticeId());
    }

    public BoardDto findtByNoticeId(long noticeId){
        BoardEntity entity = boradDao.findByNoticeId(noticeId);
        BoardDto dto = new BoardDto(); 
        dto.setNoticeId(noticeId);
        dto.setUserId(entity.getUser().getUserId());
        dto.setTitle(entity.getTitle());
        dto.setContents(entity.getContents());
        dto.setViewCnt(entity.getViewCnt());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    public List<BoardDto> findNoticeList(){
        List<BoardEntity> entities = boradDao.findNoticeList();
        List<BoardDto> dtoList = new ArrayList<>();
        for(BoardEntity boardEntity : entities){
            BoardDto dto = new BoardDto(); 
            dto.setNoticeId(boardEntity.getNoticeId());
            dto.setUserId(boardEntity.getUser().getUserId());
            dto.setTitle(boardEntity.getTitle());
            dto.setContents(boardEntity.getContents());
            dto.setViewCnt(boardEntity.getViewCnt());
            dto.setCreateDate(boardEntity.getCreateDate());
            dtoList.add(dto);
        } 
        return dtoList;   
    }
}
