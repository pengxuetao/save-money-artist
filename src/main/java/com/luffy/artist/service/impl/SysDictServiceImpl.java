package com.luffy.artist.service.impl;

import com.luffy.artist.dao.SysDictMapper;
import com.luffy.artist.entity.SysDict;
import com.luffy.artist.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    /**
     * 根据类型键查询字典
     * @param typeKey 类型键
     * @return SysDict
     */
    @Override
    public SysDict querySysDictByTypeKey(String typeKey) {
        return sysDictMapper.selectByTypeKey(typeKey);
    }

    /**
     * 更新数据字典
     * @param sysDict 数据字典
     * @return int
     */
    @Override
    public int updateSysDict(SysDict sysDict) {
        return sysDictMapper.updateByPrimaryKeySelective(sysDict);
    }
}
