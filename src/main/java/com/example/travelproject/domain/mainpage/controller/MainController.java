package com.example.travelproject.domain.mainpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.travelproject.domain.user.model.UserEntity;
import com.example.travelproject.domain.user.service.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public RedirectView redirectToMain() {
        return new RedirectView("/main");
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

    @GetMapping("/userPage")
    public String user(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "login/userPage";
    }


    @GetMapping("/main")
    public String mainIndex(Authentication authentication, Model model){
        if(authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("username", userDetails.getUsername());
            
        }
        model.addAttribute("menuTitle","홈");
        return "index";
    }

}
