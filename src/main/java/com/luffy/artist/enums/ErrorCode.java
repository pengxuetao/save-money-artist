package com.luffy.artist.enums;

/**
 * 系统错误码枚举值
 * @author Peng xue-tao
 */
public enum ErrorCode {

    SUCCESS("0", "请求成功"),
    FAILURE("1", "请求失败"),
    ERROR_10000("10000", "非法的请求参数"),
    ERROR_90001("90001", "请输入正确的淘口令");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String errorDesc;

    public String getCode() {
        return code;
    }

    ErrorCode(String code, String errorDesc) {
        this.code = code;
        this.errorDesc = errorDesc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}
