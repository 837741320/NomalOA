package com.qfedu.mapper;

import com.qfedu.domain.Role;
import com.qfedu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();

    List<Role> selectAll();
    List<Integer> selectByUid(int uid);

}