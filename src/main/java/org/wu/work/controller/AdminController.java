package org.wu.work.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wu.work.entity.User;
import org.wu.work.service.UserService;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * 后台Controller
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginAdmin")
    public String login(User user, Model model){
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord()) ;
        try {
            subject.login(token);
            return "admin" ;
        }catch (Exception e){
            model.addAttribute("error","用户名或密码错误") ;
            return "login" ;
        }
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/student")
    public String student(){
        return "admin" ;
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "admin" ;
    }
}
