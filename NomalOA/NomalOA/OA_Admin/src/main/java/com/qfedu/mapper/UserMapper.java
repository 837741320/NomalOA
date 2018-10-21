package com.qfedu.mapper;

import com.qfedu.domain.Department;
import com.qfedu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String name);

    List<User> selectByPage(@Param("index") int index, @Param("count") int count);
    long selectCount();

    //根据名字查询部门id

    int  getDidbyDname(String dname);

    //修改uid的部门id

    int changeDepartment(@Param("uid") String uid,@Param("did") int did  );


    //查询所有的部门，并且有一对多关系

     List<Department> selectDepart();

}