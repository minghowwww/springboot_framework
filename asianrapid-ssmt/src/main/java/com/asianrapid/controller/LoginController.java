package com.asianrapid.controller;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.po.SysUser;
import com.asianrapid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 下午 16:12 2018/2/9 0009
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public ModelAndView register(SysUser user){
        int i = userService.insertUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        if (i == 1){
            modelAndView.addObject("success", true);
        }else{
            modelAndView.addObject("error", true);
        }
        return modelAndView;
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public AsianrapidResult login(SysUser user, HttpServletRequest request){
//        AsianrapidResult login = userService.login(user, request);
//        return login;
//    }

}
