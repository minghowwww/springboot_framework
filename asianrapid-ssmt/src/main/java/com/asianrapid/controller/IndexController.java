package com.asianrapid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 上午 9:41 2018/2/9 0009
 */
@Controller
public class IndexController {

//    @RequestMapping(value = {"/login"})
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping(value = "/home")
//    public String gotohome(){
//        return "home";
//    }
//
//    @RequestMapping(value = {"/index", "/"})
//    public String gotoindex(){
//        return "index";
//    }
//
//    @RequestMapping(value = "/register")
//    public String gotoregister(){
//
//        return "register";
//    }

    @GetMapping("/view/{page}")
    public String getPage(@PathVariable String page){
        return page;
    }
}
