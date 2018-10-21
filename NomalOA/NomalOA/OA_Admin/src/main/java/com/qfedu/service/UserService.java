package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Department;
import com.qfedu.domain.User;

import java.util.List;

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


    int chagedepartment(String uid ,String dname);

    List<Department> selectAllDepartmentAndUser();

}
