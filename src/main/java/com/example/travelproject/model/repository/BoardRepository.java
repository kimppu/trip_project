package com.example.travelproject.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.model.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    public BoardEntity findByNoticeId(long noticeId);

    public List<BoardEntity> findByTitleContaining(String keyword);

    @Query(value = "update board b set b.viewCnt = b.viewCnt+1 where b.noticeId =: noticeId", nativeQuery = true)
    public BoardEntity updateViewCnt(@Param(value = "noticeId") long noticeId);

}
