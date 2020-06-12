package com.luffy.artist.service.impl;

import com.luffy.artist.dao.UserSignatureMapper;
import com.luffy.artist.entity.UserSignature;
import com.luffy.artist.service.UserSignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSignatureServiceImpl implements UserSignatureService {

    @Autowired
    private UserSignatureMapper userSignatureMapper;

    /**
     * 根据用户ID查询签名列表
     * @param userId 用户ID
     * @return List<UserSignature>
     */
    @Override
    public List<UserSignature> queryUserSignatureListByUserId(String userId) {
        return userSignatureMapper.selectListByUserId(userId);
    }

    /**
     * 根据ID主键查询签名
     * @param id ID主键
     * @return UserSignature
     */
    @Override
    public UserSignature queryUserSignatureById(Integer id) {
        return userSignatureMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户ID查询默认签名
     * @param userId 用户ID
     * @return UserSignature
     */
    @Override
    public UserSignature queryDefaultUserSignature(String userId) {
        return userSignatureMapper.selectDefaultByUserId(userId);
    }

    /**
     * 增加用户签名
     * @param userSignature 用户签名
     * @return int
     */
    @Override
    public int addUserSignature(UserSignature userSignature) {
        return userSignatureMapper.insertSelective(userSignature);
    }

    /**
     * 修改用户签名
     * @param userSignature 用户签名
     * @return int
     */
    @Override
    public int modifyUserSignature(UserSignature userSignature) {
        return userSignatureMapper.updateByPrimaryKeySelective(userSignature);
    }

    /**
     * 删除用户签名
     * @param id ID主键
     * @return int
     */
    @Override
    public int deleteUserSignature(Integer id) {
        return userSignatureMapper.deleteByPrimaryKey(id);
    }

    /**
     * 设置默认用户签名
     * @param id ID主键
     * @return int
     */
    @Override
    public int configDefaultUserSignature(Integer id) {
        UserSignature defaultUserSignature = userSignatureMapper.selectDefaultByUserId("admin");
        if (defaultUserSignature == null) {
            return userSignatureMapper.updateDefaultByPrimaryKey(id, (byte) 1);
        }
        if (!id.equals(defaultUserSignature.getId())) {
            userSignatureMapper.updateDefaultByPrimaryKey(id, (byte) 1);
            userSignatureMapper.updateDefaultByPrimaryKey(defaultUserSignature.getId(), (byte) 0);
        }
        return 1;
    }
}
