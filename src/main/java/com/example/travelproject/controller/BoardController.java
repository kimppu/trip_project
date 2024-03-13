package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelproject.model.dto.BoardDto;
import com.example.travelproject.model.repository.BoardRepository;
import com.example.travelproject.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardRepository boardRepository; 

    @Autowired
    private BoardService boardService; 
    
    @GetMapping({"","/"})
    public String mainBoard(Model model){
        return "board/boardMain";
    }

    //게시글 작성페이지 불러오기 
    @GetMapping("/noticeform")
    public String newNoticeForm(){
        return "board/NoticeForm";
    }

    //작성된 게시글 저장
    @PostMapping("/noticeform/create")
    public String createNotice(@ModelAttribute Authentication authentication, Model model, BoardDto dto){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        dto.setUserId(userDetails.getUsername());
        boardService.saveNotice(dto); 
        return "redirect:/board";
    }
}
