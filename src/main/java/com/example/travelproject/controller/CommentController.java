package com.example.travelproject.controller;

import com.example.travelproject.model.dto.CommentDto;
import com.example.travelproject.model.entity.CommentEntity;
import com.example.travelproject.model.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    // private CommentRepository commentTestRepository;

    // @Autowired
    // public CommentController(CommentRepository commentTestRepository) {
    //     this.commentTestRepository = commentTestRepository;
    // }

    // // 모든 댓글 조회
    // @GetMapping
    // public ResponseEntity<List<CommentDto>> getAllComments() {
    //     List<CommentDto> comments = commentTestRepository.findAll().stream()
    //             .map(entity -> new CommentDto(entity.getCommentId(), entity.getNotice(), entity.getUser(), entity.getContents(), entity.getCreateDate()))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.ok(comments);
    // }

    // // 댓글 작성
    // @PostMapping
    // public ResponseEntity<CommentEntity> createComment(@RequestBody CommentDto commentDto) {
    //     CommentEntity newComment = new CommentEntity();
    //     newComment.setNotice(commentDto.getNotice());
    //     newComment.setUser(commentDto.getUser());
    //     newComment.setContents(commentDto.getContents());
    //     CommentEntity savedComment = commentTestRepository.save(newComment);
    //     return ResponseEntity.ok(savedComment);
    // }

    // // 댓글 수정
    // @PutMapping("/fixed")
    // public ResponseEntity<CommentEntity> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
    //     return commentTestRepository.findById(id)
    //             .map(comment -> {
    //                 comment.setContents(commentDto.getContents());
    //                 // 필요에 따라 다른 필드도 업데이트
    //                 CommentEntity updatedComment = commentTestRepository.save(comment);
    //                 return ResponseEntity.ok(updatedComment);
    //             }).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // // 댓글 삭제
    // @DeleteMapping("/delete")
    // public ResponseEntity<?> deleteComment(@PathVariable Long id) {
    //     if (commentTestRepository.existsById(id)) {
    //         commentTestRepository.deleteById(id);
    //         return ResponseEntity.ok().build();
    //     }
    //     return ResponseEntity.notFound().build();
    // }

    // // 댓글 ID로 조회
    // @GetMapping("/see") //"/{id}"
    // public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
    //     return commentTestRepository.findById(id)
    //             .map(entity -> new CommentDto(entity.getCommentId(), entity.getNotice(), entity.getUser(), entity.getContents(), entity.getCreateDate()))
    //             .map(ResponseEntity::ok)
    //             .orElseGet(() -> ResponseEntity.notFound().build());
    // }
}
