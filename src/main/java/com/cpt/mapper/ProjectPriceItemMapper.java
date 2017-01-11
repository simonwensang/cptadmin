package com.cpt.mapper;

import com.cpt.model.ProjectPriceItem;
import com.cpt.model.ProjectPriceItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPriceItemMapper {
    int countByExample(ProjectPriceItemExample example);

    int deleteByExample(ProjectPriceItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectPriceItem record);

    int insertSelective(ProjectPriceItem record);

    List<ProjectPriceItem> selectByExample(ProjectPriceItemExample example);

    ProjectPriceItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectPriceItem record, @Param("example") ProjectPriceItemExample example);

    int updateByExample(@Param("record") ProjectPriceItem record, @Param("example") ProjectPriceItemExample example);

    int updateByPrimaryKeySelective(ProjectPriceItem record);

    int updateByPrimaryKey(ProjectPriceItem record);
}