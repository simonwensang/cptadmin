package com.cpt.vo;

import java.util.List;

import lombok.Data;

import com.cpt.model.ProjectPriceItem;

@Data
public class ProjectPriceVo {

    private Long id;

    private Long projectId;
    
    private String company;

    private Long companyId;

    private String manager;

    private String tel;
    
    private List<ProjectPriceItem> projectPriceItems;

}
