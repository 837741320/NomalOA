package com.qfedu.web.controller;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Role;
import com.qfedu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/15 09:56
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService service;
    //新增
    @RequestMapping("/rolesave.do")
    public String save(Role role){
        if(service.save(role)){
            return "rolelist.html";
        }else {
            return "roleadd.html";
        }
    }
    //列表
    @RequestMapping("/rolelist.do")
    @ResponseBody
    public PageVo<Role> list(int page,int limit){
        return service.queryByPage(page,limit);
    }

    //获取所有角色
    @RequestMapping("/roleall.do")
    @ResponseBody
    public List<Role> all(){
        return service.queryAll();
    }

    @RequestMapping("/rolelistbyuid.do")
    @ResponseBody
    public List<Integer> queryByUid(int uid){
        return service.selectByUid(uid);
    }
}
