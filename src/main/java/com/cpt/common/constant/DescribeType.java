package com.cpt.common.constant;

public enum DescribeType {

	PROJECT_DESCRIBE((byte)0,"项目描述"),
	PROJECT_LOG((byte)1,"项目日志") ;

	private Byte  key;
	private String value;
	
	private DescribeType(Byte key, String value) {
		this.key = key;
		this.value = value;
	}

	public Byte getKey() {
		return key;
	}

	public void setKey(Byte key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	


}
