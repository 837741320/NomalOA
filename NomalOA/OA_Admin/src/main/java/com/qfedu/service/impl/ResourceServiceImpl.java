package com.qfedu.service.impl;

import com.qfedu.common.vo.MenuVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Resource;
import com.qfedu.mapper.ResourceMapper;
import com.qfedu.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/8/14 16:01
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper mapper;
    @Override
    public List<MenuVo> queryByUserName(String name) {
        List<Resource> total=mapper.queryByUserName(name);
        List<MenuVo> menuVos=new ArrayList<>();
        for(Resource r:total){
            if(r.getParentid()==-1){
               MenuVo menuVo=new MenuVo();
               menuVo.setParent(r);
               menuVo.setChildrens(new ArrayList<>());
               menuVos.add(menuVo);
            }else{
                //二级菜单
                int index=indexParent(menuVos,r);
                if(index>-1){
                    //找到上级菜单  将当前资源对象添加到对应的孩子中
                    menuVos.get(index).getChildrens().add(r);
                }
            }
        }
        return menuVos;
    }

    @Override
    public boolean save(Resource resource) {
        return mapper.insert(resource)>0;
    }

    @Override
    public List<Resource> queryFirstMenu() {
        return mapper.selectByPid();
    }

    @Override
    public PageVo<Resource> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return PageVo.createPage(mapper.selectByPage(index,count),mapper.selectCount());
    }

    @Override
    public List<Resource> selectByUid(int uid) {
        return mapper.selectByUid(uid);
    }

    private int indexParent(List<MenuVo> menuVos,Resource resource){
        for(int i=0;i<menuVos.size();i++){
            if(menuVos.get(i).getParent().getId().intValue()==resource.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }

}
