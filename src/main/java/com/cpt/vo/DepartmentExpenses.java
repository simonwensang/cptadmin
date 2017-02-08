package com.cpt.vo;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class DepartmentExpenses {
	
	private Long departmentId;
	private String department;
	private BigDecimal total;
	private String ratio;
}
