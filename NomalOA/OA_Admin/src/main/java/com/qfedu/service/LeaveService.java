package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Leave;
import com.qfedu.domain.LeaveLog;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;

/**
 *@Author feri
 *@Date Created in 2018/8/17 15:14
 */
public interface LeaveService {

    void initPro();
    //发起申请
    void createPro(Leave leave,String uname,String rname);
    PageVo<Leave> doingTask(int uid);
    //确认申请
    void comTask(String tid,int lid,int flag,int uid);
    //查看流历史
    PageVo<HistoricTaskInstance> queryHistory(String uname,int page,int count);
    //查看日志
    PageVo<LeaveLog> queryLog(int page,int count);
}
