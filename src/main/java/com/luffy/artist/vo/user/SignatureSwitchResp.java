package com.luffy.artist.vo.user;

/**
 * 查询签名开关返回参数
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class SignatureSwitchResp {

    /**
     * 签名开关 0-关 1-开
     */
    private String subtypeValue;

    public String getSubtypeValue() {
        return subtypeValue;
    }

    public void setSubtypeValue(String subtypeValue) {
        this.subtypeValue = subtypeValue;
    }
}
