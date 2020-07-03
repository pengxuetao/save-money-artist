package com.luffy.artist.service.impl;

import com.luffy.artist.dao.SysDictMapper;
import com.luffy.artist.entity.SysDict;
import com.luffy.artist.service.SysDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 数据字典Service实现类
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    /**
     * 根据类型键查询字典
     *
     * @param typeKey 类型键
     * @return SysDict
     */
    @Override
    public SysDict querySysDictByTypeKey(String typeKey) {
        return sysDictMapper.selectByTypeKey(typeKey);
    }

    /**
     * 更新数据字典
     *
     * @param sysDict 数据字典
     * @return int
     */
    @Override
    public int updateSysDict(SysDict sysDict) {
        return sysDictMapper.updateByPrimaryKeySelective(sysDict);
    }
}
