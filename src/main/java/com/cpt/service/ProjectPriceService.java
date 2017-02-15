package com.cpt.service;

import java.util.List;

import com.cpt.common.Result;
import com.cpt.model.ProjectPriceItem;
import com.cpt.req.PriceDeleteReq;
import com.cpt.vo.ProjectPriceVo;

public interface ProjectPriceService {

	public List<ProjectPriceVo> queryByProjectId(Long projectId);
	
	public Result<Integer> insert(ProjectPriceVo projectPriceVo);
	
	public Result<Integer> delete(PriceDeleteReq req);
	
	public Result<Integer> deleteItem(PriceDeleteReq req);
	
	public Result<Integer> savePriceOfferItem(ProjectPriceItem projectPriceItem);
}
