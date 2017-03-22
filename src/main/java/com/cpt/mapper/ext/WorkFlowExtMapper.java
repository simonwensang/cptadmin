package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.WorkFlow;

public interface WorkFlowExtMapper {

    List<WorkFlow> selectByRefId(Long id);

}