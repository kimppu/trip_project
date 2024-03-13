package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;
import com.example.travelproject.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /*
     * 누구나 접근 가능
     */
    @GetMapping({"/index","/"})
    public String index(Authentication authentication, Model model) {
        if (authentication == null || userRepository.getUserDtoById(authentication.getName()) == null) {
            return "index";
        }
        if (authentication.getName().equals("admin")) {
            return "admin/index";
        } else {
            log.info("[user]: " + authentication);
            return "user/index";
        }
    }

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "errorMessage", required = false) String errorMessage, Model model) {

        model.addAttribute("errorMessage", errorMessage);
        return "login/loginPage";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "login/joinPage";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserEntity dto) {

        userService.joinUserDto(dto);
        return "redirect:/loginPage";
    }
    
    @PostMapping("/findPwd")
    public String findPwd2(@ModelAttribute UserEntity entity) {
        log.info("[find_pwd1]: " + entity);
        log.info("[find_pwd2]: " + userRepository.getUserDtoById(entity.getUserId()));
        if (userRepository.getUserDtoById(entity.getUserId()) == null) {
            log.info("가입된 아이디가 아닌 경우에...");
            return "/"; // 가입된 아이디가 아닙니다. 출력하는 방법?
        }
        return "login/findPwd";
    }
    
    @PostMapping("/findPwd2")
    public String findPwd(@ModelAttribute UserEntity entity) {
        log.info("[find_pwd1]: " + entity);
        log.info("[find_pwd2]: " + userRepository.getUserDtoById(entity.getUserId()));
        if (userRepository.getUserDtoById(entity.getUserId()) == null) {
            log.info("가입된 아이디가 아닌 경우에...");
            return "/"; // 가입된 아이디가 아닙니다. 출력하는 방법?
        }
        return "/";
    }

    /*
     * 로그인한 경우만 
     */
    @GetMapping("/user/index")
    public String user(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/user";
    }

    @GetMapping("/manager/index")
    public String manager(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/manager1";
    }

    @GetMapping("/admin/index")
    public String admin(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        model.addAttribute("admin", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/admin1";
    }

    @Secured("ADMIN")
    @GetMapping("/secured")
    public String secured(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/secured";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @GetMapping("/secured-roles")
    public String securedRoles(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/securedRoles";
    }

}
