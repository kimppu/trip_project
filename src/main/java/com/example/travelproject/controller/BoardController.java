package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelproject.model.dto.BoardDto;
import com.example.travelproject.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
    public String mainBoard(Model model){
        model.addAttribute("boardList", boardService.findNoticeList());
        return "board/boardMain";
    }

    //게시글 작성
    @GetMapping("/notice")
    public String newNoticeForm(){
        return "board/noticeForm";
    }

    @PostMapping("/notice/save")
    public String createNotice(Authentication authentication,@ModelAttribute BoardDto dto){
        log.info("[noticeform]"+authentication.toString());
        log.info("[noticeform]"+dto.toString());

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        dto.setUserId(userDetails.getUsername());
        boardService.saveNotice(dto);
        return "redirect:/board";
    }
    @GetMapping("/notice/{noticeId}")
    public String viewNotice(@PathVariable("noticeId") Long noticeId, Model model){
        log.info("[BoardController][noticview] start");
        BoardDto boardDto = boardService.findtByNoticeId(noticeId);
        model.addAttribute("notice", boardDto);
        return "board/noticeView";
    }
}
