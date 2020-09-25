package com.yaochen.manager.authorization.profession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //初期化
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String welcomeIndex(@ModelAttribute("userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "index";
    }

}
