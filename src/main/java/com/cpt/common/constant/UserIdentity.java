package com.cpt.common.constant;

public enum UserIdentity {

	//  0报价人1费用录入人
	PRICE_OFFER((byte)0,"报价人"),
	PRICE_RECORD_IN((byte)1,"费用录入人") ;

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
