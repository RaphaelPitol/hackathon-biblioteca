package com.biblioteca.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String iniciar(Model model){
        model.addAttribute("boasVindas", "Boas Vindas a Biblioteca HACKATHON");

        return "index";
    }
}
