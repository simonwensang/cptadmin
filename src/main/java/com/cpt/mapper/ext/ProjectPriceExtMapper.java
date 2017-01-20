package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.ProjectPrice;
import com.cpt.vo.ProjectPriceVo;

public interface ProjectPriceExtMapper {
     
    List<ProjectPriceVo> selectByProjectId(Long projectId);
 
    Long insertSelective(ProjectPrice ProjectPrice);
    
}