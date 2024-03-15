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


    //게시판 메인 페이지
    //권한 : 모두 접근 가능(authentication x)
    @GetMapping({"","/"})
    public String mainBoard(Model model){
        model.addAttribute("boardList", boardService.findNoticeList());
        return "board/boardMain";
    }


    //게시글 작성
    //권한 : 관리자만(authentication)
    @GetMapping("/notice")
    public String newNoticeForm(){
        return "board/noticeForm";
    }


    // 작성한 게시글 저장
    // 권한 : 관리자만(authentication)
    @PostMapping("/notice/save")
    public String createNotice(Authentication authentication,@ModelAttribute BoardDto dto){
        log.info("[BoardController][createNotice] start");

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        dto.setUserId(userDetails.getUsername());
        boardService.saveNotice(dto);
        return "redirect:/board";
    }


    // 글 상세페이지 
    // 권한 : 모두 
    @GetMapping("/notice/{noticeId}")
    public String viewNotice(@PathVariable("noticeId") Long noticeId, Model model){
        log.info("[BoardController][viewNotice] start");

        boardService.updateViewCnt(noticeId); 
        BoardDto boardDto = boardService.findtByNoticeId(noticeId);
        model.addAttribute("notice", boardDto);
        return "board/noticeView";
    }


    // 게시글 수정
    // 권한 : 관리자만(authentication)
    @PostMapping("/notice/{noticeId}/edit")
    public String editNotice(@PathVariable("noticeId") Long noticeId, Authentication authentication, Model model){
        log.info("[BoardController][editNotice] start");
        
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        BoardDto boardDto = boardService.findtByNoticeId(noticeId); 
        boardDto.setUserId(userDetails.getUsername());
        model.addAttribute("notice", boardDto);

        return "board/noticeForm"; 
    }


    // 게시글 삭제 
    @GetMapping("/notice/{noticeId}/delete")
    public String deleteNotice(@PathVariable("noticeId") Long noticeId, Authentication authentication, Model model){
        log.info("[BoardController][deleteNotice] start");

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        boardService.deleteNotice(noticeId); 
        model.addAttribute("msg", "삭제 완료");
        return "board/noticeMain"; //추후 시나리오 확인 후 수정
    }

    // 게시글 검색
    // 권한 : 모두 접근 가능(authentication 없음)
    @GetMapping("/notice/search")
    public String searchNotice(String keyword, Model model) {
        log.info("[BoardController][findNotice] start");

        model.addAttribute("searchList", boardService.findSearchList(keyword));
        return "";
    }


    // 페이지 넘기기
    // @GetMapping("notice/next")
    // public String getNextpage() {
    //     return "";
    // }
    
}
