package com.example.travelproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @GetMapping()
    public String mainBoard(Model model){
        return "board/boardMain";
    }

    //게시글 작성
    @GetMapping("/articleform")
    public String newArticleForm(){
        return "board/articleForm";
    }

    // //작성된 게시글 저장
    // @PostMapping("/articleform/create")
    // public String createArticle(BoardDto dto){
    //     System.out.println(dto);
    //     // ArticleService saveArticle(dto);
    //     return "redirect:/board"; 
    // }
}
