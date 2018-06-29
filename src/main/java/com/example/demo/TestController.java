package com.example.demo;

import com.example.bean.JsonResult;
import com.example.bean.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @RequestMapping("/a")
    public String Hello(){
        System.out.println("1111");
        System.out.println("222");
        return "HelloWorld";
    }


    /**
     * 根据ID查询用户
     * @return
     */
    @RequestMapping("/aaa")
    public ModelAndView getUserById (){
        JsonResult r = new JsonResult();
        ModelAndView mv = null;
        mv = new ModelAndView();
        mv.setViewName("helloHtml");
        return mv;
    }
}
