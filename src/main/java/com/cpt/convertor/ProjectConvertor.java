package com.cpt.convertor;


import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.Project;
import com.cpt.req.ProjectReq;
import com.cpt.vo.ProjectVo;

public class ProjectConvertor {
	
    private static final BeanCopier beanCopierForReqToProject = BeanCopier.create(ProjectReq.class,Project.class,false);
    private static final BeanCopier beanCopierForProjectVo = BeanCopier.create(Project.class,ProjectVo.class,false);
    
    public static Project reqToProject(ProjectReq projectReq) {
        if (projectReq == null) {
            return null;
        }
        Project project = new Project();
        beanCopierForReqToProject.copy(projectReq, project, null);
        /*if(StringUtils.isNotBlank(projectReq.getTenderTime())){
        	 project.setTenderTime(DateUtils.parseStr(projectReq.getTenderTime(), DateUtils.dateTimeString));
        }*/
        return project;
    }

    public static ProjectVo toProjectVo(Project project) {
        if (project == null) {
            return null;
        }
        ProjectVo projectVo = new ProjectVo();
        beanCopierForProjectVo.copy(project, projectVo, null);
        return projectVo;
    }
}
