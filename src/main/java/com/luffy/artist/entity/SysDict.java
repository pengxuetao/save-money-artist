package com.luffy.artist.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据字典
 * 系统字典配置表
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class SysDict implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID主键
     */
    private Integer id;
    /**
     * 类型键
     */
    private String typeKey;
    /**
     * 类型描述
     */
    private String typeDesc;
    /**
     * 子类型名称
     */
    private String subtypeName;
    /**
     * 子类型值
     */
    private String subtypeValue;
    /**
     * 排序
     */
    private Byte sort;
    /**
     * 备注
     */
    private String remark;
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

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getSubtypeName() {
        return subtypeName;
    }

    public void setSubtypeName(String subtypeName) {
        this.subtypeName = subtypeName;
    }

    public String getSubtypeValue() {
        return subtypeValue;
    }

    public void setSubtypeValue(String subtypeValue) {
        this.subtypeValue = subtypeValue;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "SysDict{" +
                "id=" + id +
                ", typeKey='" + typeKey + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", subtypeName='" + subtypeName + '\'' +
                ", subtypeValue='" + subtypeValue + '\'' +
                ", sort=" + sort +
                ", remark='" + remark + '\'' +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                '}';
    }
}