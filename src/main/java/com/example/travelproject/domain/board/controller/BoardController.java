package com.example.travelproject.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelproject.domain.board.model.repository.BoardRepository;
import com.example.travelproject.domain.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    
    @GetMapping({"","/"})
    public String mainBoard(Model model){
        model.addAttribute("menuTitle","게시판");
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
