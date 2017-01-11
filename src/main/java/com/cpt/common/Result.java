package com.cpt.common;

import java.io.Serializable;

/**
 * @author:sang
 * @date:15/12/21 下午2:24
 * <p/>
 * Description:
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;
    private String code;
    private String msg;
    private T value;

    public Result() {

    }

    public Result(T value) {
        this.code = ResultCode.C200.getCode();
        this.value = value;
    }

    public Result(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

    public Result(String code, String msg, T value) {
		super();
		this.code = code;
		this.msg = msg;
		this.value = value;
	}

	public static <T> Result<T> newResult(T value) {
        return new Result<>(value);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
