package com.cpt.common.constant;

public enum AuthorityStatus {
	//1提报人，2项目负责人，3报价负责人，4报价人commit_user
	COMMIT_USER((byte)1,"提报人"),
	PROJECT_MANAGER((byte)2,"项目负责人"),
	PRICE_MANAGER((byte)3,"报价负责人"),
	PRICE_OFFER((byte)4,"报价人");

	private Byte  key;
	private String value;
	
	private AuthorityStatus(Byte key, String value) {
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
