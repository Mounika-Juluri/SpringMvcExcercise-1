package com.stackroute.controller;

import com.stackroute.db.CrudOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    CrudOperation crudOperation = new CrudOperation();

    @RequestMapping("/")
    public String add(){
        return "index";
    }


    @RequestMapping("/login")
    public String login(@RequestParam("username") String i,@RequestParam("password") String j ,ModelMap map){
        crudOperation.insertData(i,j);

        System.out.println("inserted");
        map.addAttribute("greeting","Welcome "+  crudOperation.displayCustomerByName(i) +" to Stackroute");
        return "display";
    }
}
