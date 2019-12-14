package com.zhouzhuolin.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

    @RequestMapping("/say1")
    public String say1(){
        return "说活1";
    }

    @RequestMapping("/say2")
    public String say2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "说活2";
    }

    @RequestMapping("/say3")
    public String say3(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "说活3";
    }

}
