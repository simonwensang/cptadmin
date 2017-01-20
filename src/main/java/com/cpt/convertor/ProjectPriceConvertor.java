package com.cpt.convertor;

import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.ProjectPrice;
import com.cpt.vo.ProjectPriceVo;

public class ProjectPriceConvertor {

    private static final BeanCopier beanCopierForProjectPrice = BeanCopier.create(ProjectPriceVo.class,ProjectPrice.class,false);
    
    private static final BeanCopier beanCopierForProjectPriceVo = BeanCopier.create(ProjectPrice.class,ProjectPriceVo.class,false);
    
    public static ProjectPrice toProjectPrice(ProjectPriceVo projectPriceVo) {
        if (projectPriceVo == null) {
            return null;
        }
        ProjectPrice projectPrice = new ProjectPrice();
        beanCopierForProjectPrice.copy(projectPriceVo, projectPrice, null);
        return projectPrice;
    }
    
    public static ProjectPriceVo toProjectPriceVo(ProjectPrice projectPrice) {
        if (projectPrice == null) {
            return null;
        }
        ProjectPriceVo projectPriceVo = new ProjectPriceVo();
        beanCopierForProjectPriceVo.copy(projectPrice, projectPriceVo, null);
        return projectPriceVo;
    }
    
}
