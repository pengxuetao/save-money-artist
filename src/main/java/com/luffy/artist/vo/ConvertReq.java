package com.luffy.artist.vo;

/**
 * 转换口令请求参数
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class ConvertReq {

    /**
     * 旧链接
     */
    private String oriString;

    /**
     * 新链接
     */
    private String targetString;

    public String getOriString() {
        return oriString;
    }

    public void setOriString(String oriString) {
        this.oriString = oriString;
    }

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String targetString) {
        this.targetString = targetString;
    }
}
