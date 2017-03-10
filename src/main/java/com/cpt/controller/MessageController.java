 package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.Result;
import com.cpt.model.Message;
import com.cpt.service.MessageService;
 
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired  
	private MessageService messageService;
	
	 /**
     * 分页数据
     *
     * @param UserQuery
     * @param user
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView pageList(ModelAndView modelMap,PageParam pageParam ) {
    	modelMap.addObject("messageList", messageService.pageList(pageParam));
        modelMap.setViewName("message/message_list");
		return modelMap;
    }
    
    /**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(Message message) {
    	return messageService.addOrEdit(message);
    }
 
	/**
     * 删除
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> delete(Long id) {
    	return messageService.delete(id);
    }
    /**
     * 查询
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Result<Message> get(Long id) {
    	return messageService.get(id);
    }
	
}
