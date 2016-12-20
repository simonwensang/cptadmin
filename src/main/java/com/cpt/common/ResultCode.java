package com.cpt.common;

/**
 * @author:杨果
 * @date:16/3/10 上午9:29
 * <p/>
 * Description:
 * <p/>
 * REST接口返回的结果状态码,这些结果状态码参照HTTP协议
 */
public enum ResultCode {
    C200(200, "Success"),
    C403(403, "Forbidden"),
    C404(404, "参数错误"),
    C500(500, "Internal Server Error");

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;//code
    private String desc;//description

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
