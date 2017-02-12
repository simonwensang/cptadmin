package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Message;

public interface MessageExtMapper {
	 List<Message> pageList();
	 
	 int logicalDelete(Long id);
}