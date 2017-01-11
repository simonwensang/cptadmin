package com.cpt.common;

 
public enum ResultCode {
    C200("200", "Success"),
    C403("403", "Forbidden"),
    C404("404", "参数错误"),
    C500("500", "Internal Server Error"),
  //----------------------------------------
  	// 通用异常 
  	// 区间：10001-10050
  	//----------------------------------------
      COMMON_PARAM_NULL("10001",    "必要参数%s为空！"),
      COMMON_PARAM_INVALID("10002", "参数%s无效！"),
      CONTAINS_ILLEGAL_CHARACTERS("10003", "%s含有非法字符"),
      DATA_NOT_EXIST("10004", "%s不存在"),
      NO_PERMISSION_OPERATE("10005",  "没有%s的操作权限"),
      CAN_NOT_BE_OPERATE("10006",  "%s不能%s"),
      FIELD_NOT_ALLOWED_EMPTY("10010", "%s不能为空"),
  	FIELD_VALUE_MUST_LARGE_THAN("10011", "%s必须大于%s"),
  	FIELD_VALUE_MUST_LESS_THAN("10012", "%s必须小于%s"),
  	
  	FIELD_NOT_EMAIL("10013", "%s格式错误"),
  	FIELD_NOT_MOBILE("10014", "%s格式错误"),
  	FIELD_NOT_ID_NUM("10015", "%s格式错误"),
  	FIELD_NOT_DATE("10016", "%s格式错误"),
  	FIELD_LENGTH_MUST_LESS("10017", "%s必须小于%d"),
  	FIELD_LENGTH_MUST_MORE("10018", "%s必须大于%d"),
  	FIELD_LENGTH_MUST_BETWEEN("10019", "%s长度必须大于%d和小于%d"),
  	FILED_NOT_IN_ENUM_VALUES("10020", "不支持的%s"),
  	FIELD_NOT_BOTH_BE_EMPTY("10021", "%s不能同时为空"),
  	MUST_BE_INTEGER_MULTIPLE("10022", "%s必须是%s的整数倍"),
  	
  	
  	FIELD_VALUE_MUST_GE_THAN("10023", "%s必须大于等于%s"),
  	FIELD_VALUE_MUST_LE_THAN("10024", "%s必须小于等于%s"),
  	
  	
  	TIME_MUST_LARGE_THAN("10030", "%s必须晚于%s"),
  	TIME_VALUE_MUST_LESS_THAN("10031", "%s必须早于%s"),
  	INVALID_CHANGE_STATUS("10032","%s更新状态非法");
    
    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;//code
    private String desc;//description

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
