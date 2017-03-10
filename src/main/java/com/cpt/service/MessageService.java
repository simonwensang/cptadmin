package com.cpt.service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Message;

public interface MessageService {
	
	public PageResult<Message> pageList(PageParam pageParam);
	
	public Result<Message> get(Long id);
	
	public Result<Integer> addOrEdit(Message message);
	
	public Result<Integer> delete(Long id);
	
}
