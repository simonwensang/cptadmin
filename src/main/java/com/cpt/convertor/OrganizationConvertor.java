package com.cpt.convertor;

import java.util.List;

import com.cpt.model.Organization;
import com.cpt.vo.JsonModel;
import com.google.common.collect.Lists;

public class OrganizationConvertor {
 
    public static JsonModel toJsonModel(Organization  organization) {
        if (organization == null) {
            return null;
        }
        JsonModel jsonModel = new JsonModel();
        jsonModel.setId(organization.getId());
        jsonModel.setName(organization.getName());
        jsonModel.setPId(organization.getParentId());
        return jsonModel;
    }
   
    public static List<JsonModel> toJsonModelList(List<Organization>  organizations) {
        if (organizations == null) {
            return null;
        }
        List<JsonModel> jsonModelList = Lists.newArrayList();
        for(Organization organization:organizations){
        	jsonModelList.add(toJsonModel(organization));
        }
        return jsonModelList;
    }

}
