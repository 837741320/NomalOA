package com.qfedu.mapper;

import com.qfedu.domain.UserRole;

public interface UserRoleMapper {
    int deleteByUid(int uid);
    int insert(UserRole record);

}