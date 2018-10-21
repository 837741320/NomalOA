package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.User;

/**
 *@Author feri
 *@Date Created in 2018/8/13 15:48
 */
public interface UserService {
    boolean save(User user);
    User login(String name,String password);
    boolean checkName(String name);
    PageVo<User> queryByPage(int page,int limit);

    boolean updateRole(int[] rids,int uid);

}
