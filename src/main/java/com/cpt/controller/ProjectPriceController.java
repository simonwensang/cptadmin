package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.common.Result;
import com.cpt.model.ProjectPriceItem;
import com.cpt.req.PriceDeleteReq;
import com.cpt.service.ProjectPriceService;
import com.cpt.vo.ProjectPriceVo;

@Controller
@RequestMapping("/projectPrice")
public class ProjectPriceController {
	
	@Autowired 
	ProjectPriceService projectPriceService ; 
	
	 /**
     * 保存报价
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/savePriceOffer", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> savePriceOffer( ProjectPriceVo projectPriceVo) {
    	return projectPriceService.insert( projectPriceVo);
    }
    
    /**
     * 删除客户
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletePriceOffer", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> deletePriceOffer(PriceDeleteReq req) {
    	return projectPriceService.delete( req);
    }
    
    /**
     * 删除客户报价
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletePriceOfferItem", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> deletePriceOfferItem(PriceDeleteReq req) {
    	return projectPriceService.deleteItem( req);
    }
    
    /**
     * 删除客户报价
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/savePriceOfferItem", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> savePriceOfferItem(ProjectPriceItem projectPriceItem) {
    	return projectPriceService.savePriceOfferItem( projectPriceItem);
    }
    
}
