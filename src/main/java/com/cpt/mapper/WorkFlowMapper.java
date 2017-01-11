package com.cpt.mapper;

import com.cpt.model.WorkFlow;
import com.cpt.model.WorkFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkFlowMapper {
	
    int countByExample(WorkFlowExample example);

    int deleteByExample(WorkFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkFlow record);

    int insertSelective(WorkFlow record);

    List<WorkFlow> selectByExample(WorkFlowExample example);

    WorkFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkFlow record, @Param("example") WorkFlowExample example);

    int updateByExample(@Param("record") WorkFlow record, @Param("example") WorkFlowExample example);

    int updateByPrimaryKeySelective(WorkFlow record);

    int updateByPrimaryKey(WorkFlow record);
}