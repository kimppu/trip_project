package com.example.travelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.travelproject.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    public BoardEntity findByNoticeId(long noticeId);

}