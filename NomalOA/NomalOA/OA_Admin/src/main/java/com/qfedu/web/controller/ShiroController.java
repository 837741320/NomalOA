package com.qfedu.web.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2018/8/16 09:35
 * 基于Shiro权限验证
 */
@Controller
public class ShiroController {

    //校验1个权限
    @RequestMapping("/shiropercheck.do")
    public void check(String per, HttpServletResponse response) throws IOException {
        try{
            SecurityUtils.getSubject().checkPermission(per);
            response.getWriter().print(0);//有权限0
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().print(1);//无权限1
        }
    }
    //校验多个权限
    @RequestMapping("/shiroperchecks.do")
    public void check(String[] per, HttpServletResponse response) throws IOException {
        try{
            SecurityUtils.getSubject().checkPermissions(per);
            response.getWriter().print(0);//有权限0
        }catch (Exception e){
            response.getWriter().print(1);//无权限1
        }
    }
}
