package com.luffy.artist.vo.user;

import javax.validation.constraints.NotBlank;

/**
 * 增加用户签名请求参数
 *
 * @author Peng xue-tao
 * @since 2020/6/22
 */
public class AddUserSignatureReq {

    private static final long serialVersionUID = 1L;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddUserSignatureReq{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}