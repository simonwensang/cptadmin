package com.cpt.req;

import lombok.Data;

@Data
public class OptReq {

	private Long id;
	private Long userId;
	private Byte optType; // 1项指派目负责人，2指派报价负责人 ，3 指派报价人
	
}
