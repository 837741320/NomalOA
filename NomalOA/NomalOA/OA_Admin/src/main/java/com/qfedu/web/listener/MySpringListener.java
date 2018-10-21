package com.qfedu.web.listener;

import com.qfedu.service.LeaveService;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;

/**
 *@Author feri
 *@Date Created in 2018/8/17 15:49
 */
public class MySpringListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        LeaveService leaveService=getCurrentWebApplicationContext().getBean(LeaveService.class);
        leaveService.initPro();
    }
}
