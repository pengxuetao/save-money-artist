package com.luffy.artist.enums;

/**
 * 系统错误码枚举值
 * code为实际使用值，errorDesc为具体描述或者文案
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public enum ErrorCode {

    /**
     * 系统错误码
     */
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

    ErrorCode(String code, String errorDesc) {
        this.code = code;
        this.errorDesc = errorDesc;
    }

    public String getCode() {
        return code;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

}
