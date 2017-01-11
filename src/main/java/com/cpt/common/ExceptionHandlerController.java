package com.cpt.common;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	/**
	 * 错误统一返回
	 * @param e
	 * @return
	 */
	@ExceptionHandler({Exception.class,IOException.class,RuntimeException.class})  
	@ResponseBody
    public Result<Boolean> exception(Exception e) { 
	    logger.error(e.getMessage(), e);
		e.printStackTrace();
		Result<Boolean> result = new Result<Boolean>();
		result.setCode(ResultCode.C500.getCode());
		result.setMsg(ResultCode.C500.getDesc());
		result.setValue(false);
        return result;  
    }  
}
