package com.qfedu.common.vo;

import com.qfedu.domain.Resource;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/14 15:49
 */
public class MenuVo {
    private Resource parent;
    private List<Resource> childrens;

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public List<Resource> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Resource> childrens) {
        this.childrens = childrens;
    }
}
