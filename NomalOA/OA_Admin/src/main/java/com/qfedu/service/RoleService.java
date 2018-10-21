package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Role;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/13 15:48
 */
public interface RoleService {
    boolean save(Role role);

    PageVo<Role> queryByPage(int page,int count);
    List<Role> queryAll();

    List<Integer> selectByUid(int uid);
}
