package com.luffy.artist.vo;

import javax.validation.constraints.NotBlank;

/**
 * 转换口令请求参数
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class ConvertReq {

    /**
     * 旧链接
     */
    @NotBlank(message = "旧链接不能为空")
    private String oriString;

    /**
     * 新链接
     */
    @NotBlank(message = "新链接不能为空")
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

    @Override
    public String toString() {
        return "ConvertReq{" +
                "oriString='" + oriString + '\'' +
                ", targetString='" + targetString + '\'' +
                '}';
    }
}
