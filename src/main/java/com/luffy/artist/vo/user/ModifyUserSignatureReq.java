package com.luffy.artist.vo.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改用户签名请求参数
 *
 * @author Peng xue-tao
 * @since 2020/6/22
 */
public class ModifyUserSignatureReq {
    private static final long serialVersionUID = 1L;
    /**
     * ID主键
     */
    @NotNull(message = "ID不能为空")
    @Min(value = 1, message = "ID不能小于1")
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "ModifyUserSignatureReq{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}