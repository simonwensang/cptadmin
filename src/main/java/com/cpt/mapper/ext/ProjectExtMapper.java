package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Project;
import com.cpt.req.ProjectReq;
import com.cpt.vo.ProjectVo;
import com.cpt.vo.ScheduleVo;

public interface ProjectExtMapper {

    List<ProjectVo> selectProjectList(ProjectReq projectReq);
    
    List<ProjectVo> selectDetailProjectList(ProjectReq projectReq);
    
    List<ScheduleVo> selectProjectSchedule(Long id);
   
    Integer selectPriceProject(Long id);
    
    Integer selectManagerProject(Long id);
    
    int insertSelective(Project record);

}