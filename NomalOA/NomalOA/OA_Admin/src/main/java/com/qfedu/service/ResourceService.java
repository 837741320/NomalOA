package com.qfedu.service;

import com.qfedu.common.vo.MenuVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Resource;
import com.qfedu.domain.Role;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/13 15:48
 */
public interface ResourceService {

    List<MenuVo> queryByUserName(String name);

    //新增
    boolean save(Resource resource);
    //查询一级菜单
    List<Resource> queryFirstMenu();
    PageVo<Resource> queryByPage(int page, int count);

    List<Resource> selectByUid(int uid);
}
