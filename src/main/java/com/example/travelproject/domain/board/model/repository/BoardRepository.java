package com.example.travelproject.domain.board.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travelproject.domain.board.model.entity.BoardEntity;



public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    // public BoardEntity findByTitle(String title);
    public BoardEntity selectByNotice(long noticeId);
}
