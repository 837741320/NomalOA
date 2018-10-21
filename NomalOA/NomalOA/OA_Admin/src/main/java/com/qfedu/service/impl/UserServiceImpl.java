package com.qfedu.service.impl;

import com.qfedu.common.util.ShiroEncryUtil;
import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Department;
import com.qfedu.domain.User;
import com.qfedu.domain.UserRole;
import com.qfedu.mapper.UserMapper;
import com.qfedu.mapper.UserRoleMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/8/14 09:30
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public boolean save(User user) {
        //将明文转为密文
        user.setPassword(ShiroEncryUtil.md5(user.getPassword()));
        return mapper.insert(user)>0;
    }

    @Override
    public User login(String name, String password) {
        User user=mapper.selectByName(name);
        if(user!=null){
            if(Objects.equals(user.getPassword(),ShiroEncryUtil.md5(password))){
                return user;
            }
        }
        return null;
    }

    //存在就返回false不可用  不存在就返回true
    @Override
    public boolean checkName(String name) {
        User user=mapper.selectByName(name);
        if(user!=null){
            //存在
            return false;
        }else {
            //不存在
            return true;
        }
    }

    @Override
    public PageVo<User> queryByPage(int page, int limit) {
        int index=0;
        if(page>0){
            index=(page-1)*limit;
        }
//        PageVo<User> pageVo=new PageVo<>();
//        pageVo.setCode(0);
//        pageVo.setMsg("OK");
//        pageVo.setCount((int)mapper.selectCount());
//        pageVo.setData(mapper.selectByPage(index,limit));

        return PageVo.createPage(mapper.selectByPage(index,limit),(int)mapper.selectCount());
    }

    @Override
    public boolean updateRole(int[] rids, int uid) {
       try{
           userRoleMapper.deleteByUid(uid);
           for(int id:rids){
               UserRole ur=new UserRole();
               ur.setRid(id);
               ur.setUid(uid);
               userRoleMapper.insert(ur);
           }
           return true;
       }catch (Exception e){
           //记录异常日志
           //return false;
           throw  new RuntimeException("异常");
       }
    }

    @Override
    public int chagedepartment(String uid, String dname) {

      int did=  mapper.getDidbyDname(dname);


        return  mapper.changeDepartment(uid,did);
    }

    @Override
    public List<Department> selectAllDepartmentAndUser() {

        return  mapper.selectDepart();
    }
}
