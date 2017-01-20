package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.ProjectPriceItem;

public interface ProjectPriceItemExtMapper {
  
    int insertList(List<ProjectPriceItem> itemList);

}