package com.luffy.artist.dao;

import com.luffy.artist.entity.SysDict;
import org.apache.ibatis.annotations.Param;

/**
 * 数据字典Mapper
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public interface SysDictMapper {
    /**
     * 根据id删除数据字典
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据字典
     * @param record 数据字典
     * @return int
     */
    int insert(SysDict record);

    /**
     * 选择性插入数据字典
     * @param record 数据字典
     * @return int
     */
    int insertSelective(SysDict record);

    /**
     * 根据id查询数据字典
     * @param id id
     * @return SysDict
     */
    SysDict selectByPrimaryKey(Integer id);

    /**
     * 选择性更新数据字典
     * @param record 数据字典
     * @return int
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     * 更新数据字典
     * @param record 数据字典
     * @return int
     */
    int updateByPrimaryKey(SysDict record);

    /**
     * 根据类型键查询字典
     * @param typeKey 类型键
     * @return SysDict
     */
    SysDict selectByTypeKey(@Param("typeKey") String typeKey);
}