package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.travelproject.model.dto.CommentDto;
import com.example.travelproject.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 목록 페이지
    @GetMapping("list1")
    public String listComments(Model model) {
        model.addAttribute("comments", commentService.findAllComments());
        return "comments/list"; // comments/list.html 뷰 반환
    }

    // 댓글 작성 페이지
    @GetMapping("/new")
    public String newCommentForm(Model model) {
        model.addAttribute("comment", new CommentDto());
        return "comments/new"; // comments/new.html 뷰 반환
    }

    // 댓글 저장
    @PostMapping("/save")
    public String saveComment(CommentDto commentDto) {
        commentService.saveComment(commentDto);
        return "redirect:/comments"; // 댓글 목록으로 리다이렉트
    }

    // 댓글 상세 보기
    @GetMapping("/{commentId}")
    public String viewComment(@PathVariable Long commentId, Model model) {
        CommentDto commentDto = commentService.findCommentById(commentId);
        model.addAttribute("comment", commentDto);
        return "comments/view"; // comments/view.html 뷰 반환
    }

    // 댓글 삭제
    @GetMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/comments"; // 댓글 목록으로 리다이렉트
    }

    // 이렇게 컨트롤러를 수정하면, 각 메소드는 HTML 템플릿 뷰를 반환합니다.
    // 각 경로에 맞는 HTML 파일을 생성해야 합니다 (예: list.html, new.html, view.html 등).
}
