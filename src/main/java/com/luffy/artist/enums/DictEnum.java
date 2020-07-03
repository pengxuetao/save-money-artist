package com.luffy.artist.enums;

/**
 * 数据字典枚举值
 * code为实际使用值，errorDesc为具体描述或者文案
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public enum DictEnum {

    /**
     * 签名开关 0-关 1-开
     */
    SIGNATURE_SWITCH_OFF("0", "关"),
    SIGNATURE_SWITCH_ON("1", "开");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String errorDesc;

    DictEnum(String code, String errorDesc) {
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
