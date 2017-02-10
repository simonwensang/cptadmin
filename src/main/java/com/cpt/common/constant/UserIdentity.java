package com.cpt.common.constant;

public enum UserIdentity {

	// 0用户1报价人2费用录入人
	USER((byte)0,"用户"),
	PRICE_OFFER((byte)1,"报价人"),
	PRICE_RECORD_IN((byte)2,"费用录入人") ;

	private Byte  key;
	private String value;
	
	private UserIdentity(Byte key, String value) {
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
