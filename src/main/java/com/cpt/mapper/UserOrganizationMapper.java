package com.cpt.mapper;

import com.cpt.model.UserOrganization;
import com.cpt.model.UserOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrganizationMapper {
    int countByExample(UserOrganizationExample example);

    int deleteByExample(UserOrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOrganization record);

    int insertSelective(UserOrganization record);

    List<UserOrganization> selectByExample(UserOrganizationExample example);

    UserOrganization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserOrganization record, @Param("example") UserOrganizationExample example);

    int updateByExample(@Param("record") UserOrganization record, @Param("example") UserOrganizationExample example);

    int updateByPrimaryKeySelective(UserOrganization record);

    int updateByPrimaryKey(UserOrganization record);
}