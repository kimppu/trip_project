package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.travelproject.model.dto.UserDto;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "errorMessage", required = false) String errorMessage, Model model) {
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "auth/loginPage";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "auth/joinPage";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute UserEntity dto) throws Exception {

        userService.joinUserDto(dto);
        return "redirect:/auth/login";
    }

    @PostMapping("/find-password")
    public String findPwd(@ModelAttribute UserDto userDto, Model model, HttpSession session) {
        log.info("[AuthController][findPwd] start");
        UserDto targetDto = userService.findByUserEmail(userDto.getUserEmail());
        log.info("target = " + targetDto.toString());
        log.info("user = " + userDto.toString());
        if(targetDto == null || !targetDto.getUserId().equals(userDto.getUserId()) ||        
            !targetDto.getUserEmail().equals(userDto.getUserEmail()) || 
            !targetDto.getUserNm().equals(userDto.getUserNm())){
                log.info("가입된 아이디가 아닌 경우에...");
                return "redirect:/auth/login";
            }
        // log.info("[find_pw]: " + userService.findByUserId(userDto.getUserId()));
        // if (userService.findByUserId(userDto.getUserId()) == null) {
        //     log.info("가입된 아이디가 아닌 경우에...");
        //     return "redirect:/loginPage"; // 가입된 아이디가 아닙니다. 출력하는 방법?
        // }
        model.addAttribute("userId", targetDto.getUserId());
        log.info("[find_pw1-2]: " + model);
        return "auth/findPw";
    }

    @PostMapping("/confirm-id") // Id 중복확인
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(String id) {
        log.info("[MainController][ConfirmId] Start: " + id);
        boolean result = true;

        if (id.trim().isEmpty()) { // 입력된 Id가 비어있는 경우
            log.info("[ConfirmId][공백ID] >>> " + id);
            result = false;
        } else {
            log.info("[ConfirmId][저장된 ID] >>> " + userService.findByUserId(id));
            if (userService.findByUserId(id) != null) {
                result = false; // 저장된 ID가 있다면 false -> 중복
            } else {
                result = true;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    // Email 중복확인
    @PostMapping("/confirm-email")
    @ResponseBody
    public ResponseEntity<Boolean> confirmEmail(String email) {
        log.info("[MainController][confirmEmail] Start: " + email);
        boolean result = true;

        if (email.trim().isEmpty()) {
            result = false;
        } else {
            if (userService.findByUserEmail(email)!=null){
                result = false; // 저장된 Email이 있다면 false -> 중복
            } else {
                result = true;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 아이디찾기 페이지 이동
    @GetMapping("/find-id")
    public String findIdPage(@RequestParam(value = "erroMessage", required = false) String errorMessage, Model model) {
        model.addAttribute("errorMessage", errorMessage);
        return "auth/findIdPage";
    }

    @PostMapping("/find-id")
    public String findUserId(String userNm,String userEmail, Model model) throws Exception {
        log.info("[MainController][findUserId] " + userNm + userEmail);
        // UserDto userDto = userService.findByUserEmail(userEmail);
        String userId = userService.findUserIdByEmail(userNm, userEmail);
        log.info("[userId] = "+userId);
        // redirectAttributes.addAttribute("userId",userId);
        model.addAttribute("userId", userId);
        return "auth/userIdPage";
    }
}