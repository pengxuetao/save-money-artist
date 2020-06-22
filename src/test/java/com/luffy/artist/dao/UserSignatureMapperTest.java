package com.luffy.artist.dao;

import com.luffy.artist.entity.UserSignature;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserSignatureMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSignatureMapperTest.class);

    @Resource
    private UserSignatureMapper userSignatureMapper;

    @Test
    void deleteByPrimaryKey() {
        assertEquals(0, userSignatureMapper.deleteByPrimaryKey(1));
    }

    @Test
    void insertSelective() {
        UserSignature userSignature = new UserSignature();
        userSignature.setId(3);
        userSignature.setUserId("admin");
        userSignature.setTitle("11111");
        userSignature.setContent("22222");
        assertEquals(1, userSignatureMapper.insertSelective(userSignature));
    }

    @Test
    void selectByPrimaryKey() {
        assertNull(userSignatureMapper.selectByPrimaryKey(1));
    }

    @Test
    void updateByPrimaryKeySelective() {
        UserSignature userSignature = new UserSignature();
        userSignature.setId(1);
        userSignature.setTitle("111");
        userSignature.setContent("222");
        assertEquals(0, userSignatureMapper.updateByPrimaryKeySelective(userSignature));
    }

    @Test
    void selectListByUserId() {
        assertNotNull(userSignatureMapper.selectListByUserId("admin"));
    }

    @Test
    void selectDefaultByUserId() {
        assertNotNull(userSignatureMapper.selectDefaultByUserId("admin"));
    }

    @Test
    void updateDefaultByPrimaryKey() {
        assertEquals(0, userSignatureMapper.updateDefaultByPrimaryKey(1, (byte) 1));
    }
}