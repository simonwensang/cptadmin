package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.req.ProjectReq;
import com.cpt.vo.ProjectVo;

public interface ProjectExtMapper {

    List<ProjectVo> selectProjectList(ProjectReq projectReq);

}