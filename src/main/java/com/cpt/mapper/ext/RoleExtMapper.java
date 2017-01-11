package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Role;

public interface RoleExtMapper {

	List<Role> selectByUserId(Long userId);
}
