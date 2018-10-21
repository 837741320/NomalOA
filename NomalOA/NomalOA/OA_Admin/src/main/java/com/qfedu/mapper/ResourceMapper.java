package com.qfedu.mapper;

import com.qfedu.domain.Resource;
import com.qfedu.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    List<Resource> selectByPid();

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> queryByUserName(String name);

    List<Resource> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();

    //根据用户查询对应的所有权限
    List<Resource> selectByUid(int uid);

}