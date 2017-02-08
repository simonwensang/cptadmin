package com.cpt.req;

import lombok.Data;

@Data
public class ExpensesQuery {

	private Long userId;
	
	private Byte type; //0自己 1部门  2全部
	
}
