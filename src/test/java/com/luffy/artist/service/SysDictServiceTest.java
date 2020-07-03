package com.luffy.artist.service;

import com.luffy.artist.dao.SysDictMapper;
import com.luffy.artist.entity.SysDict;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class SysDictServiceTest {

    @Resource
    private SysDictMapper sysDictMapper;

    @Test
    void querySysDictByTypeKey() {
        assertNotNull(sysDictMapper.selectByTypeKey("signatureSwitch"));
    }

    @Test
    void updateSysDict() {
        SysDict sysDict = new SysDict();
        sysDict.setId(1);
        sysDict.setSubtypeValue("1");
        assertEquals(1, sysDictMapper.updateByPrimaryKeySelective(sysDict));
    }
}