package com.qfedu.mapper;

import com.qfedu.domain.LeaveLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveLogMapper {

    int insert(LeaveLog record);

    List<LeaveLog> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();
}