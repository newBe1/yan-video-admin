package com.yr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/15 17:03
 */
@Controller
@RequestMapping("/test")
public class Hello {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
