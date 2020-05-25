package com.yourname.ssm.user.controller;

import com.yourname.ssm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserContoller {
    @Autowired
    private UserService userService;

    @RequestMapping("/getLoginPage")
    public ModelAndView getPage(){
        return new ModelAndView("/student//login");
    }


    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam Map<String,Object> param){

        String msg = userService.login(param);

        return msg;
    }
    @RequestMapping("/getRegistPage")
    public ModelAndView getRegistPage(){
        return new ModelAndView("/student/regist");
    }
    /*注册*/
    @RequestMapping("/regist")
    @ResponseBody
    public String regist(@RequestParam Map<String,Object> param){
        String msg = userService.regist(param);
        return msg;
    }
}
