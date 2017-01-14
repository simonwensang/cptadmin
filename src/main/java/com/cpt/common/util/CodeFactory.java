package com.cpt.common.util;

public class CodeFactory {

	public static final String CPT ="CPT";
	
	public static String getCode(){
		return CodeFactory.CPT+DateUtils.getCurrentDay(DateUtils.dateTimeLongString);
	}
	
}
