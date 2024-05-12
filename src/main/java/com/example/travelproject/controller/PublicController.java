package com.example.travelproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.travelproject.model.dto.BoardDto;
import com.example.travelproject.model.dto.CommentDto;
import com.example.travelproject.service.BoardService;
import com.example.travelproject.service.CommentService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PublicController {
    // @Autowired
    // private UserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;
    
    @GetMapping("/favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
    }

    @GetMapping
    public String index(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Authentication authentication, HttpSession session, Model model) {
        log.info("[PublicController][index] Start");
        return "index";
    }

    @GetMapping("/board")
    public String mainBoard(Authentication authentication, Model model, HttpSession session){
        model.addAttribute("boardList", boardService.findNoticeList());
        return "board/boardMain";
    }

    @GetMapping("/lodge")
    public String mainLodge(){
        return "lodge/lodgeMain";
    }
    @GetMapping("/plan")
    public String mainPlan(){
        return "plan/planMain";
    }
    
    @GetMapping("/board/notice/{noticeId}")
    public String viewNotice(@PathVariable("noticeId") Long noticeId, Model model,HttpSession session, Authentication authentication){
        log.info("[BoardController][viewNotice] start");
        boardService.updateViewCnt(noticeId);
        BoardDto boardDto = boardService.findtByNoticeId(noticeId);
        String userId = "";
        if(authentication != null){
            userId = authentication.getName();
            model.addAttribute("userId", userId);
        }
        // String userId = authentication.getName();
        log.info("userId : " + userId);
        
        List<CommentDto> commentDtos = commentService.findAllComments(userId,noticeId);
        model.addAttribute("notice", boardDto);
        if(!commentDtos.isEmpty()){
            model.addAttribute("commentDtos", commentDtos);
        }
        return "board/noticeView";
    }
}
