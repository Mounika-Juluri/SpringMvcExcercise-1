package com.stackroute.controller;

import com.stackroute.Service.ServiceUser;
import com.stackroute.db.UserD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserD userDAO;


    private ServiceUser serviceUser=new ServiceUser();

    @GetMapping
    public String add(){
        return "index";
    }


    @PostMapping("/login")
    public String addUser(@RequestParam("username") String i,@RequestParam("password") String j ,ModelMap map){
        User user=serviceUser.populateUserClass(i,j);
        userDAO.saveUser(user);
        map.addAttribute("greeting","Welcome "+  user.getUsername() +" to Stackroute");
        return "display";
    }
}







