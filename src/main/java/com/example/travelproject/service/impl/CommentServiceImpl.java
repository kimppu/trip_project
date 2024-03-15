package com.example.travelproject.service.impl;

import com.example.travelproject.model.dao.CommentDao;
import com.example.travelproject.model.dto.CommentDto;
import com.example.travelproject.model.entity.CommentEntity;
import com.example.travelproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void saveComment(CommentDto dto) {
        CommentEntity comment = new CommentEntity();
        // 필요한 필드 설정, 예를 들면:
        // comment.setNotice(dto.getNotice());
        // comment.setUser(dto.getUser());
        comment.setContents(dto.getContents());
        commentDao.saveComment(comment);
    }

    @Override
    public void updateComment(Long id, CommentDto dto) {
        Optional<CommentEntity> commentOptional = commentDao.findCommentById(id);
        if (commentOptional.isPresent()) {
            CommentEntity comment = commentOptional.get();
            comment.setContents(dto.getContents());
            commentDao.saveComment(comment);
        } else {
            throw new RuntimeException("Comment not found with id " + id);
        }
    }

    @Override
    public void deleteComment(Long id) {
        commentDao.deleteComment(id);
    }

    @Override
    public CommentDto findCommentById(Long id) {
        Optional<CommentEntity> comment = commentDao.findCommentById(id);
        if (comment.isPresent()) {
            CommentEntity entity = comment.get();
            return new CommentDto(
                entity.getCommentId(),
                // Convert Entity references to appropriate identifiers or objects
                entity.getNotice().toString(), // 예시입니다. 실제 구현은 조정이 필요합니다.
                entity.getUser().toString(), // 예시입니다.
                entity.getContents(),
                entity.getCreateDate()
            );
        } else {
            throw new RuntimeException("Comment not found with id " + id);
        }
    }

    @Override
    public List<CommentDto> findAllComments() {
        return commentDao.findAllComments().stream().map(entity -> new CommentDto(
            entity.getCommentId(),
            // Again, convert these entities as needed
            entity.getNotice().toString(), // 예시입니다.
            entity.getUser().toString(), // 예시입니다.
            entity.getContents(),
            entity.getCreateDate()
        )).collect(Collectors.toList());
    }
}
