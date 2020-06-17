package com.luffy.artist.service;

import com.luffy.artist.entity.SysDict;

/**
 * 数据字典Service接口
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public interface SysDictService {

    /**
     * 根据类型键查询字典
     * @param typeKey 类型键
     * @return SysDict
     */
    SysDict querySysDictByTypeKey(String typeKey);

    /**
     * 更新数据字典
     * @param sysDict 数据字典
     * @return int
     */
    int updateSysDict(SysDict sysDict);
}
