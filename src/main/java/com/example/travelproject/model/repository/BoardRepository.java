package com.example.travelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    public BoardEntity selectByNotice(long noticeId);

    @Query(value = "select * from Notice order by desc", nativeQuery = true)
    public BoardEntity showNotice();
}