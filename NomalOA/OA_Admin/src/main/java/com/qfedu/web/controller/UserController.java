package com.qfedu.web.controller;

import com.qfedu.common.vo.MenuVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.User;
import com.qfedu.service.ResourceService;
import com.qfedu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 *@Author feri
 *@Date Created in 2018/8/13 15:54
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private ResourceService resourceService;

    //登录
    @PostMapping("/userlogin.do")
    public String login(String name, String password, @RequestParam(defaultValue = "") String remberme, HttpSession session){
        User user=service.login(name,password);
        if(user!=null){
            //登录成功
            //进行Shiro  将登录结果告知Shiro
            //获取主题---当前登录信息
            Subject subject=SecurityUtils.getSubject();
            boolean rem=false;
            if(remberme!=null && remberme.length()>0){
                rem=true;
            }
            //创建令牌
            UsernamePasswordToken token=new UsernamePasswordToken(name,user.getPassword(),rem);
            //尝试登录
            subject.login(token);
            subject.getSession().setAttribute("user",user);//shiro
            session.setAttribute("user",user);//web
            return "index.html";
        }else {
            return "login.html";
        }
    }

    //左菜单
    @RequestMapping("/usermenus.do")
    @ResponseBody
    public List<MenuVo> queryMenus(){
       User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return resourceService.queryByUserName(user.getName());
    }
    //验证是否存在用户名 存在返回1 不存在返回0
    @RequestMapping("/usercheck.do")
    public void check(String name, HttpServletResponse response) throws IOException {
        if(service.checkName(name)){
            response.getWriter().print(0);
        }else {
            response.getWriter().print(1);
        }
    }

    //添加
    @RequestMapping("/usersave.do")
    public String save(User user){
        if(service.save(user)){
            return "userlist.html";
        }else {
            return "useradd.html";
        }
    }
    //查询 分页
    @RequestMapping("/userlist.do")
    @ResponseBody
    public PageVo<User> list(int page,int limit){
        return service.queryByPage(page,limit);
    }

    //修改用户角色
    //@RequiresPermissions({"uredit"})
    @RequestMapping("/userroleedit.do")
    public void edit(int[] rid,HttpServletResponse response) throws IOException {
        int r=1;
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        if(service.updateRole(rid,user.getId())){
            //成功
            r=0;
        }
        response.getWriter().print(r);
    }
}
