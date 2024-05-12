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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.travelproject.model.dto.BoardDto;
import com.example.travelproject.service.BoardService;
import com.example.travelproject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private BoardService boardService;

    @GetMapping("/admin-page")
    public String adminSetting(Authentication authentication, Model model) {
        log.info("[MainController][adminSetting] Start");
        model.addAttribute("userlist", userService.findAllUser());
        return "admin/admin_manage";
    }

    @GetMapping("/notice")
    public String newNoticeForm(Authentication authentication, Model model){
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

    @GetMapping("/notice/{noticeId}/edit")
    public String editNotice(@PathVariable("noticeId") Long noticeId, Authentication authentication, Model model){ 
        boardService.updateViewCnt(noticeId); 
        BoardDto boardDto = boardService.findtByNoticeId(noticeId);
        model.addAttribute("notice", boardDto);
        return "board/noticeForm";
    }

    @PostMapping("/notice/{noticeId}/update")
    public String updateNotice(@PathVariable("noticeId") Long noticeId,Authentication authentication
                                ,@ModelAttribute BoardDto boardDto,RedirectAttributes redirectAttributes){
        log.info("[BoardController][updateNotice] start");
        // log.info("noticeId:"+noticeId+"  boardDto : "+boardDto.toString());
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        boardDto.setUserId(userDetails.getUsername());
        boardService.updateNotice(boardDto);
        redirectAttributes.addAttribute("noticeId", noticeId);
        return "redirect:/board/notice/{noticeId}";
    }

    // 게시글 삭제 
    @PostMapping("/notice/{noticeId}/delete")
    public String deleteNotice(@PathVariable("noticeId") Long noticeId, Authentication authentication, Model model){
        log.info("[BoardController][deleteNotice] start");
        boardService.deleteNotice(noticeId); 
        // model.addAttribute("msg", "삭제 완료");
        return "redirect:/board"; 
    }
    
}
