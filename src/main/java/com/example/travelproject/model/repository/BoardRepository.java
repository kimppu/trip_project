package com.example.travelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.travelproject.model.entity.BoardEntity;
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
<<<<<<< HEAD
    
=======
>>>>>>> e904f9c68548ae55d61206915510f98e09a35eca
    public BoardEntity findByNoticeId(long noticeId);

    @Query(value = "select * from board order by createDate desc", nativeQuery = true)
    public List<BoardEntity> showAllPage();

}