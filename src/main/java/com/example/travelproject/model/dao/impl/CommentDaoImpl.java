package com.example.travelproject.model.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.travelproject.model.dao.CommentDao;
import com.example.travelproject.model.entity.CommentEntity;
import com.example.travelproject.model.repository.CommentRepository;

@Component
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentRepository commentRepository;


    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    public Optional<CommentEntity> findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<CommentEntity> findAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    // 사용자 ID에 따른 댓글 검색
    public List<CommentEntity> findCommentsByUserId(String userId) {
        return commentRepository.findByUserUserId(userId);
    }
}

