package com.luffy.artist.enums;

/**
 * 符号枚举值
 * code为实际使用值，errorDesc为具体描述或者文案
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public enum SymbolEnum {

    /**
     * 半角圆括号
     */
    LEFT_PARENTHESIS("(", "左半角圆括号"),
    RIGHT_PARENTHESIS(")", "右半角圆括号");

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

    SymbolEnum(String code, String errorDesc) {
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
