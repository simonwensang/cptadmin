package com.cpt.req;

import lombok.Data;

@Data
public class SignContractReq {

	private Long projectId;
	
	private Byte sign;  // 0不签 1 签合同 
	
	private String reason;//  不签合同原因
	
}
