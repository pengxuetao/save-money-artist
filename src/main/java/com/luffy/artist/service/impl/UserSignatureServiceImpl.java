package com.luffy.artist.service.impl;

import com.luffy.artist.dao.UserSignatureMapper;
import com.luffy.artist.entity.UserSignature;
import com.luffy.artist.service.UserSignatureService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户签名Service实现类
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
@Service
public class UserSignatureServiceImpl implements UserSignatureService {

    @Resource
    private UserSignatureMapper userSignatureMapper;

    /**
     * 根据用户ID查询签名列表
     *
     * @param userId 用户ID
     * @return List<UserSignature>
     */
    @Override
    public List<UserSignature> queryUserSignatureListByUserId(String userId) {
        return userSignatureMapper.selectListByUserId(userId);
    }

    /**
     * 根据ID主键查询签名
     *
     * @param id ID主键
     * @return UserSignature
     */
    @Override
    public UserSignature queryUserSignatureById(Integer id) {
        return userSignatureMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户ID查询默认签名
     *
     * @param userId 用户ID
     * @return UserSignature
     */
    @Override
    public UserSignature queryDefaultUserSignature(String userId) {
        return userSignatureMapper.selectDefaultByUserId(userId);
    }

    /**
     * 增加用户签名
     *
     * @param userSignature 用户签名
     * @return int
     */
    @Override
    public int addUserSignature(UserSignature userSignature) {
        // 查询当前用户的签名列表
        List<UserSignature> userSignatureList = userSignatureMapper.selectListByUserId("admin");
        // 如果用户没有签名，则该签名设置为默认签名
        if (CollectionUtils.isEmpty(userSignatureList)) {
            userSignature.setIsDefault((byte) 1);
        }
        return userSignatureMapper.insertSelective(userSignature);
    }

    /**
     * 修改用户签名
     *
     * @param userSignature 用户签名
     * @return int
     */
    @Override
    public int modifyUserSignature(UserSignature userSignature) {
        return userSignatureMapper.updateByPrimaryKeySelective(userSignature);
    }

    /**
     * 删除用户签名
     *
     * @param id ID主键
     * @return int
     */
    @Override
    public int deleteUserSignature(Integer id) {
        return userSignatureMapper.deleteByPrimaryKey(id);
    }

    /**
     * 设置默认用户签名
     *
     * @param id ID主键
     * @return int
     */
    @Override
    public int configDefaultUserSignature(Integer id) {
        // 查询当前默认签名，没有则将传入签名设为默认，有且不是当前签名则将当前设为非默认
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
