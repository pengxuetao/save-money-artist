package com.luffy.artist.service;

import com.luffy.artist.dao.UserSignatureMapper;
import com.luffy.artist.entity.UserSignature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserSignatureServiceTest {

    @Resource
    private UserSignatureMapper userSignatureMapper;

    @Test
    void queryUserSignatureListByUserId() {
        assertNotNull(userSignatureMapper.selectListByUserId("admin"));
    }

    @Test
    void queryUserSignatureById() {
        assertNull(userSignatureMapper.selectByPrimaryKey(1));
    }

    @Test
    void queryDefaultUserSignature() {
        assertNotNull(userSignatureMapper.selectDefaultByUserId("admin"));
    }

    @Test
    void addUserSignature() {
        UserSignature userSignature = new UserSignature();
        userSignature.setId(3);
        userSignature.setUserId("admin");
        userSignature.setTitle("11111");
        userSignature.setContent("22222");

        // 查询当前用户的签名列表
        List<UserSignature> userSignatureList = userSignatureMapper.selectListByUserId("admin");
        assertNotNull(userSignatureList);
        // 如果用户没有签名，则该签名设置为默认签名
        if (CollectionUtils.isEmpty(userSignatureList)) {
            userSignature.setIsDefault((byte) 1);
        }
        assertEquals(1, userSignatureMapper.insertSelective(userSignature));
    }

    @Test
    void modifyUserSignature() {
        UserSignature userSignature = new UserSignature();
        userSignature.setId(1);
        userSignature.setTitle("111");
        userSignature.setContent("222");
        assertEquals(0, userSignatureMapper.updateByPrimaryKeySelective(userSignature));
    }

    @Test
    void deleteUserSignature() {
        assertEquals(0, userSignatureMapper.deleteByPrimaryKey(1));
    }

    @Test
    void configDefaultUserSignature() {
        Integer id = 45;
        // 查询当前默认签名，没有则将传入签名设为默认，有且不是当前签名则将当前设为非默认
        UserSignature defaultUserSignature = userSignatureMapper.selectDefaultByUserId("admin");
        if (defaultUserSignature == null) {
            assertEquals(1, userSignatureMapper.updateDefaultByPrimaryKey(id, (byte) 1));
        }
        if (!id.equals(defaultUserSignature.getId())) {
            assertEquals(1, userSignatureMapper.updateDefaultByPrimaryKey(id, (byte) 1));
            assertEquals(1, userSignatureMapper.updateDefaultByPrimaryKey(defaultUserSignature.getId(), (byte) 0));
        }
    }
}