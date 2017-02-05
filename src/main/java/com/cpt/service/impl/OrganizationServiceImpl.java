package com.cpt.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpt.common.constant.Constants;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.model.Organization;
import com.cpt.model.OrganizationExample;
import com.cpt.service.OrganizationService;
import com.cpt.vo.JsonModel;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Override
	public String getTreeNode() {
		OrganizationExample example = new OrganizationExample();
		//OrganizationExample.Criteria criteria =example.createCriteria();
		//criteria.andLevelNotEqualTo(Constants.LEVEL_1);
		List<Organization> organizations = organizationMapper.selectByExample(example);
		JSONArray jsonArray=new JSONArray();  
		for(Organization organization:organizations)  
	    {  
	        JSONObject jsonObject=new JSONObject();  
	        jsonObject.put("id",organization.getId());  
	        jsonObject.put("pId",organization.getParentId());  
	        jsonObject.put("name",organization.getName());  
	        if(organization.getId()==1){
	        	jsonObject.put("open","true");
	        }  
            //判断所选择节点是否是父节点，如果是设置isParent属性为true,不是设置为false  
	        if(organization.getLevel().byteValue() <(byte)4 )  
	        {  
	            jsonObject.put("isParent","true");  
	        }else {  
	            jsonObject.put("isParent","false");  
	        }  
	        jsonArray.add(jsonObject);  
	    }  
		 return jsonArray.toJSONString();
	}

}
