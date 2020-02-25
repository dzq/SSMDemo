package com.dzq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/user")
@ApiIgnore
public class UserController {

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView insert(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("user_add");
//        System.out.println("正在访问UserController.insert()");
//        return mv;
//    }

//    @RequestMapping("/hi")
//    public String hi(){
//
//        System.out.println("正在访问UserController.hi()");
//        return "hi";
//    }
}
