package com.example.travelproject.domain.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travelproject.domain.user.model.entity.UserEntity;
import com.example.travelproject.domain.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
    // 마이페이지 이동
    
    @Autowired
    private UserService userService;

    @GetMapping({"","/"})
	public String mypage(Authentication authentication, Model model) {
        if(authentication == null) {
            model.addAttribute("menuTitle", "홈");
            return "/index";
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();        
        model.addAttribute("username", userDetails.getUsername());
		return "staff/mypage";
	}

    @PostMapping("/update_mypage")
    public String getMethodName(@ModelAttribute UserEntity dto) {
        log.info("[update]: " + userService);
        log.info("[update]: " + dto);
        return "#";
    }    
}