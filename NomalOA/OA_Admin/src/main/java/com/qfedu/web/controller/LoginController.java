package com.qfedu.web.controller;

import com.qfedu.domain.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *@Author feri
 *@Date Created in 2018/8/18 09:39
 */
@Controller
public class LoginController {
    @RequestMapping("/loginname.do")
    @ResponseBody
    public User getName(){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return user;
    }

    @RequestMapping("/loginout.do")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        SecurityUtils.getSubject().logout();
        return "login.html";
    }
}
