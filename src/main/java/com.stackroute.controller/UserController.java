package com.stackroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @RequestMapping("/")
    public String add(){
        return "index";
    }


    @RequestMapping("/login")
    public String login(@RequestParam("username") String i,@RequestParam("password") String j ,ModelMap map){
        User user=new User();
        user.setName(i);
        map.addAttribute("greeting","Welcome "+ user.getName()+" to Stackroute");
        return "display";
    }
}
