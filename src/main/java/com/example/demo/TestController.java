package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/a")
    public String Hello(){
        System.out.println("1111");
        System.out.println("222");
        return "HelloWorld";
    }


}
