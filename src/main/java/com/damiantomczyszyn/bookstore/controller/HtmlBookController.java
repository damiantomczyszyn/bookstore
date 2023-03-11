package com.damiantomczyszyn.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v2")
public class HtmlBookController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
