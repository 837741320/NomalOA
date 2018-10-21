package com.qfedu.web.controller;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Leave;
import com.qfedu.domain.LeaveLog;
import com.qfedu.domain.User;
import com.qfedu.service.LeaveService;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2018/8/17 15:51
 * 基于Activiti实现工作流
 * 流程管理
 */
@Controller
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    //创建
    @RequestMapping("/leaveadd.do")
    public String add(Leave leave,String rname){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        leave.setUid(user.getId());
        leaveService.createPro(leave,user.getName(),rname);
        return "leavelist.html";
    }
    //审批
    @RequestMapping("leaveupdate.do")
    public void update(String tid,int flag, int id, HttpServletResponse response) throws IOException {
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        leaveService.comTask(tid,id,flag,user.getId());
        response.getWriter().print(0);
    }
    //我的待办事项
    @RequestMapping("leavelist.do")
    @ResponseBody
    public PageVo<Leave> list(){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return leaveService.doingTask(user.getId());
    }
    //我的历史
    @RequestMapping("leavehislist.do")
    @ResponseBody
    public PageVo<HistoricTaskInstance> hislist(int page,int limit){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return leaveService.queryHistory(user.getName(),page,limit);
    }
    //我的日志
    @RequestMapping("leaveloglist.do")
    @ResponseBody
    public PageVo<LeaveLog> loglist(int page, int limit){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return leaveService.queryLog(page,limit);
    }

}
