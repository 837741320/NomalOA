package com.qfedu.web.controller;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Resource;
import com.qfedu.service.ResourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/15 10:45
 */
@Controller
public class ResourceController  {
    @Autowired
    private ResourceService service;

    //新增
    @RequestMapping("/resourcesave.do")
    public String save(Resource resource){
        if(service.save(resource)){
            return "resourcelist.html";
        }else {
            return "resourceadd.html";
        }
    }
    //查询一级菜单
    @RequestMapping("/resourcerootmenu.do")
    @ResponseBody
    public List<Resource> rootmenu(){
        return service.queryFirstMenu();
    }


    @RequestMapping("resourcelist.do")
    @ResponseBody
    public PageVo<Resource> list(int page,int limit){
        return service.queryByPage(page,limit);
    }
}
