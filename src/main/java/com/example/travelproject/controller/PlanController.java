package com.example.travelproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @GetMapping({"","/"})
    public String mainPlan(Model model){
        return "plan/planMain";
    }
}
