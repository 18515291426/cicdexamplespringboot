package com.example.web.exampleweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.inf.util.User;


/**
 * @program: example-cicd-springboot
 * @description:
 * @author: baijinlong
 * @create: 2019-09-25 19:00
 **/
@RequestMapping("/home")
@RestController
public class HomeController {


    @GetMapping("/index")
    public User index(){

        User user = new User();
        user.setName("lilei");
        user.setAge(30);
        return user;
    }

}
