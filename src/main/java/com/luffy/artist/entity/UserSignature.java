package com.luffy.artist.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户签名
 * 用户签名表
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class UserSignature implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否默认 0-否 1-是
     */
    private Byte isDefault;
    /**
     * 更新时间
     */
    private LocalDateTime updateDate;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserSignature{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isDefault=" + isDefault +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                '}';
    }
}