package com.luffy.artist.dao;

import com.luffy.artist.entity.SysDict;
import org.apache.ibatis.annotations.Param;

public interface SysDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    /**
     * 根据类型键查询字典
     * @param typeKey 类型键
     * @return SysDict
     */
    SysDict selectByTypeKey(@Param("typeKey") String typeKey);
}