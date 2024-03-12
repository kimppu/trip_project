package com.example.travelproject.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelproject.domain.article.model.ArticleDto;
import com.example.travelproject.domain.article.model.ArticleEntity;
import com.example.travelproject.domain.article.model.ArticleRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping({"","/"})
    public String mainBoard(Model model){
        model.addAttribute("menuTitle","게시판");
        return "board/boardMain";
    }

    //게시글 작성
    @GetMapping("/articleform")
    public String newArticleForm(Model model){
        model.addAttribute("menuTitle","게시판");    
        return "board/articleForm";
    }

    //작성된 게시글 저장
    @PostMapping("/articleform/create")
    public String createArticle(@ModelAttribute ArticleDto dto, Model model){
        model.addAttribute("menuTitle","게시판");    
        //1. dto -> entity
        ArticleEntity article = dto.toEntity();
        //2. repository에게 entity를 db에 저장
        ArticleEntity saved = articleRepository.save(article);

        return "redirect:/board"; 
    }
}
