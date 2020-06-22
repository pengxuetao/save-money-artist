package com.luffy.artist.dao;

import com.luffy.artist.entity.SysDict;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class SysDictMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictMapperTest.class);

    @Resource
    private SysDictMapper sysDictMapper;

    @Test
    void updateByPrimaryKeySelective() {
        SysDict sysDict = new SysDict();
        sysDict.setId(1);
        sysDict.setSubtypeValue("1");
        assertEquals(1, sysDictMapper.updateByPrimaryKeySelective(sysDict));
    }

    @Test
    void selectByTypeKey() {
        assertNotNull(sysDictMapper.selectByTypeKey("signatureSwitch"));
    }
}