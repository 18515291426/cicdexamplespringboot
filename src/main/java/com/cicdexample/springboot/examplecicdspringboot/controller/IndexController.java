package com.cicdexample.springboot.examplecicdspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: example-cicd-springboot
 * @description:
 * @author: baijinlong
 * @create: 2019-09-25 18:37
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping(path = "/home")
    public String home(){
        return "hello springboot ci/cd example";
    }

}
