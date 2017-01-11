package com.cpt.mapper;

import com.cpt.model.ProjectDescribe;
import com.cpt.model.ProjectDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectDescribeMapper {
    int countByExample(ProjectDescribeExample example);

    int deleteByExample(ProjectDescribeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectDescribe record);

    int insertSelective(ProjectDescribe record);

    List<ProjectDescribe> selectByExampleWithBLOBs(ProjectDescribeExample example);

    List<ProjectDescribe> selectByExample(ProjectDescribeExample example);

    ProjectDescribe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectDescribe record, @Param("example") ProjectDescribeExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectDescribe record, @Param("example") ProjectDescribeExample example);

    int updateByExample(@Param("record") ProjectDescribe record, @Param("example") ProjectDescribeExample example);

    int updateByPrimaryKeySelective(ProjectDescribe record);

    int updateByPrimaryKeyWithBLOBs(ProjectDescribe record);

    int updateByPrimaryKey(ProjectDescribe record);
}