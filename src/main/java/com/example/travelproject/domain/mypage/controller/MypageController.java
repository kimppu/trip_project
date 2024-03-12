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

import com.example.travelproject.domain.user.model.dto.UserDto;
import com.example.travelproject.domain.user.model.entity.UserEntity;
import com.example.travelproject.domain.user.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
    // 마이페이지 이동
    
    @Autowired
    private UserRepository userRepository;


    @GetMapping({"","/"})
	public String mypage(Authentication authentication, Model model) {
        if(authentication == null) {
            model.addAttribute("menuTitle", "홈");
            return "redirect:/index";
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userId", userDetails.getUsername());
        model.addAttribute("userEmail", userRepository.getUserDtoById(userDetails.getUsername()).getUserEmail());
		return "staff/mypage";
	}

    @PostMapping("/update")
    public String update(@ModelAttribute UserEntity dto) {
        log.info("[dto]: " + dto);
        log.info("[repository]: " + userRepository.getUserDtoById(dto.getUserId()));
        UserEntity update_dto = userRepository.getUserDtoById(dto.getUserId());
        update_dto.setUserEmail(dto.getUserEmail());
        log.info("[update]: " + update_dto);
        userRepository.save(update_dto);

        return "redirect:/mypage";
    }

    @PostMapping("/signout")
    public String signout(@ModelAttribute UserEntity dto) {
        log.info("[signout]: " + dto);
        return "/";
    }
    
}