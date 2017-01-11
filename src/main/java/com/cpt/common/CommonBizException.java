package com.cpt.common;


public class CommonBizException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	private ResultCode mmcResultCode;

    public CommonBizException(String errorCode, String errorMsg, Throwable caused) {
        super(errorCode, errorMsg, caused);
    }

    public CommonBizException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public CommonBizException(String errorCode, String errorMsg, Object... args) {
        super(errorCode, errorMsg, args);
    }
    
    public CommonBizException(ResultCode resultCode){
        this(resultCode.getCode(),resultCode.getDesc());
        this.mmcResultCode = resultCode;
    }

    public CommonBizException(ResultCode resultCode, Object... args){
        this(resultCode.getCode(),resultCode.getDesc(), args);
        this.mmcResultCode = resultCode;
    }
    
    public CommonBizException(String errorCode, Throwable caused) {
        super(errorCode, caused);
    }

	public ResultCode getMmcResultCode() {
		return mmcResultCode;
	}
	
//	public void setMmcResultCode(MmcResultCode MmcResultCode) {
//		this.mmcResultCode = MmcResultCode;
//	}

}