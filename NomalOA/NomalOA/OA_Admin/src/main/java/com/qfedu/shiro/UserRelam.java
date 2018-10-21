package com.qfedu.shiro;

import com.qfedu.domain.Resource;
import com.qfedu.domain.User;
import com.qfedu.service.ResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/13 15:53
 */

public class UserRelam extends AuthorizingRealm {

    private ResourceService service;
    public UserRelam(ResourceService service){
        this.service=service;
    }

    //授权---提供当前用户的权限和角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();//授权集合
        if(user!=null){
            //获取当前用户的所有权限
            List<Resource> list=service.selectByUid(user.getId());
            //获取当前用户的角色

            List<String> pers=new ArrayList<>();
            for(Resource r:list){
                pers.add(r.getPer());
            }
            System.out.println("aaabbb--->"+pers);
            //将对应的权限集合添加到授权集合中
            info.addStringPermissions(pers);
        }
        return info;
    }

    //认证---登录校验
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取令牌
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //外界已经进行过登录校验，此处只需要进行对象封装
        if(token.getUsername().length()>0){
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
            //存储到Session
            //SecurityUtils.getSubject().getSession().setAttribute("username",token.getUsername());
            return info;
        }
        return null;
    }
}
