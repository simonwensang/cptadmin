package com.cpt.mapper;

import com.cpt.model.ProjectPrice;
import com.cpt.model.ProjectPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPriceMapper {
    int countByExample(ProjectPriceExample example);

    int deleteByExample(ProjectPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectPrice record);

    int insertSelective(ProjectPrice record);

    List<ProjectPrice> selectByExample(ProjectPriceExample example);

    ProjectPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectPrice record, @Param("example") ProjectPriceExample example);

    int updateByExample(@Param("record") ProjectPrice record, @Param("example") ProjectPriceExample example);

    int updateByPrimaryKeySelective(ProjectPrice record);

    int updateByPrimaryKey(ProjectPrice record);
}