package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Module;

public interface ModuleExtMapper {
    
    List<Module> selectByUserId(Long userId);

}