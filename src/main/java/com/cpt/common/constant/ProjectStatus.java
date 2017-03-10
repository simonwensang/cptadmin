package com.cpt.common.constant;

public enum ProjectStatus {

	//项目状态0待制定项目负责人1待指派报价负责人2待指派报价人3报价中4合同已签订5合同不签订
	INIT_PROJECT((byte)0,"待制定项目负责人"),
	PROJECT_MANAGER((byte)1,"待指派报价负责人"),
	PRICE_MANAGER((byte)2,"待指派报价人"),
	PRICE_OFFER((byte)3,"报价中"),
	SIGN_CONTRACT((byte)4,"合同已签订"),
	NO_CONTRACT((byte)5,"合同不签订");
	private Byte  key;
	private String value;
	
	private ProjectStatus(Byte key, String value) {
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
	
	public static String getValueByKey(Byte key){
		for (ProjectStatus e : ProjectStatus.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	
}
