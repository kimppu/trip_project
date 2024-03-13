package com.example.travelproject.model.repository;

import com.example.travelproject.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    CommentEntity findByCommentId(Long commentId); // 기존 메소드, 올바른 파라미터 명명으로 수정

    // 사용자 ID에 따른 댓글 검색 메소드 추가
    List<CommentEntity> findByUserUserId(String userId);
}

