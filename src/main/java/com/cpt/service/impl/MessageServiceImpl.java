package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.mapper.MessageMapper;
import com.cpt.mapper.ext.MessageExtMapper;
import com.cpt.model.Message;
import com.cpt.service.MessageService;
import com.cpt.service.UserCommonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageExtMapper messageExtMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Resource
	private UserCommonService userCommonService;
	
	@Override
	public PageResult<Message> pageList(PageParam pageParam) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<Message> messages = messageExtMapper.pageList();
        //构造分页结果
        PageResult<Message> pageResult = PageResult.newPageResult(messages, ((Page<Message>)messages).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public Result<Integer> addOrEdit(Message message) {
		if(StringUtils.isBlank( message.getContent())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		message.setUser(userCommonService.getUser().getName());
		message.setUserId(userCommonService.getUserId());
		if(message.getId()==null){
			//判断登录名是否重复
			return Result.newResult(this.insert(message));
		}else{
			return Result.newResult(this.update(message));
		}
	}

	@Override
	public Result<Integer> delete(Long id) {
		return  Result.newResult(messageMapper.deleteByPrimaryKey(id));
	}

	private int insert(Message message){
		return messageMapper.insertSelective(message);
	}

	private int update(Message message){
		return messageMapper.updateByPrimaryKeySelective(message);
	}
}
