package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelproject.model.dto.CommentDto;
import com.example.travelproject.model.dto.UserDto;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.service.CommentService;
import com.example.travelproject.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    // 댓글 저장
    @PostMapping("/comment/save")
    public String saveComment(@RequestBody CommentDto commentDto,Authentication authentication) {
        log.info("[CommentController][save] start");
        log.info(commentDto.getNoticeId() + commentDto.getContents());
        log.info("CommentDto userId : "+commentDto.getUserId());
        commentService.saveComment(commentDto);
        return "redirect:/board/notice/"+commentDto.getNoticeId(); // 댓글 목록으로 리다이렉트
    }

    // 댓글 상세 보기
    @PostMapping("/comment/update")
    public String updateComment(@RequestBody CommentDto commentDto) {
        log.info("[CommentController][update] start");
        log.info("CommentController - dto => "+commentDto.toString());
        commentService.updateComment(commentDto);
        return "redirect:/board/notice/"+commentDto.getNoticeId();
    }

    // 댓글 삭제
    @PostMapping("/comment/delete")
    public String deleteComment(@RequestBody CommentDto commentDto) {
        commentService.deleteComment(commentDto.getCommentId());
        log.info("[CommentController][update] start");
        log.info("CommentController - dto => "+commentDto.toString());
        return "redirect:/board/notice/"+commentDto.getNoticeId();
    }
    
    @GetMapping("/mypage")
	public String mypage(Authentication authentication, Model model, HttpSession session) {
        log.info("[UserController][mypage] start");
        if(authentication == null) {
            model.addAttribute("menuTitle", "홈");
            return "redirect:/main";
        }
        
        UserDto userDto = userService.findByUserId(authentication.getName());
        log.info("userDto : "+userDto.toString());

        // session.setAttribute("userId", userDetails.getUsername());
        model.addAttribute("userId", userDto.getUserId());
        // model.addAttribute("userPw", userRepository.getUserDtoById(userDetails.getUsername()).getUserPw());
        model.addAttribute("userEmail", userDto.getUserEmail());
		return "user/mypage";
	}
    @PostMapping("/mypage/update")
    public String update(@ModelAttribute UserEntity dto) {
        log.info("[UserController][update] start");
        // log.info("[dto]: " + dto);
        // log.info("[repository]: " + userRepository.getUserDtoById(dto.getUserId()));
        UserDto update_dto = userService.findByUserId(dto.getUserId());
        update_dto.setUserEmail(dto.getUserEmail());
        log.info("[mypage/update] update_dto : " + update_dto.toString());
        userService.updateUserDto(update_dto);
        // userRepository.save(update_dto);

        return "redirect:/user/mypage";
    }
    
    @GetMapping("/mypage/signout")
    public String signout(Authentication authentication, HttpSession session) {
        if (authentication == null) {
            return "redirect:/main";
        }
        log.info("[signout]: " + authentication.getName());



        log.info("[signout][deleteComment] Start");
        commentService.deleteCommentByUserId(authentication.getName());
        log.info("[signout][deleteComment] End");
        
        userService.deleteUser(authentication.getName());

        session.removeAttribute("userNm");
        session.removeAttribute("adminYn");

        authentication.setAuthenticated(false);
        return "redirect:/main";
    }

    @PostMapping("/mypage/set-password")
    public String setPassword(@ModelAttribute UserDto userDto, Authentication authentication) {
        log.info("[UserController][mypage/set-password]: " + userDto.toString());
        UserDto updateUserDto = userService.findByUserId(userDto.getUserId());
        updateUserDto.setUserPw(userDto.getUserPw());
        userService.updateUserDto(userDto);

        if (authentication != null) {
            authentication.setAuthenticated(false);
            log.info("[find_pw2-3][auth]: " + authentication);
        }
        return "redirect:/logout";
    }
}
