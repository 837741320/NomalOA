package com.qfedu.service.impl;

import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Role;
import com.qfedu.mapper.RoleMapper;
import com.qfedu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/15 09:55
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public boolean save(Role role) {
        return mapper.insert(role)>0;
    }

    @Override
    public PageVo<Role> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return PageVo.createPage(mapper.selectByPage(index,count),mapper.selectCount());
    }

    @Override
    public List<Role> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Integer> selectByUid(int uid) {
        return mapper.selectByUid(uid);
    }
}
