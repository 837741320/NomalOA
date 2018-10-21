package com.qfedu.mapper;

import com.qfedu.domain.Leave;
import com.qfedu.domain.LeaveLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveMapper {
    int insert(Leave record);
    List<Leave> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();
    int updateFlag(@Param("id")int id,@Param("flag")int flag);
    List<Leave> selectByUid(int uid);
}