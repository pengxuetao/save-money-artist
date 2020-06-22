package com.luffy.artist.vo;

/**
 * 转换口令返回参数
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class ConvertResp {

    /**
     * 转换口令结果
     */
    private String convertResult;

    public String getConvertResult() {
        return convertResult;
    }

    public void setConvertResult(String convertResult) {
        this.convertResult = convertResult;
    }

    @Override
    public String toString() {
        return "ConvertResp{" +
                "convertResult='" + convertResult + '\'' +
                '}';
    }
}
