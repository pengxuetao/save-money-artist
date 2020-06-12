package com.luffy.artist.service;

import com.luffy.artist.entity.UserSignature;

import java.util.List;

public interface UserSignatureService {

    /**
     * 根据用户ID查询签名列表
     * @param userId 用户ID
     * @return List<UserSignature>
     */
    List<UserSignature> queryUserSignatureListByUserId(String userId);

    /**
     * 根据ID主键查询签名
     * @param id ID主键
     * @return UserSignature
     */
    UserSignature queryUserSignatureById(Integer id);

    /**
     * 根据用户ID查询默认签名
     * @param userId 用户ID
     * @return UserSignature
     */
    UserSignature queryDefaultUserSignature(String userId);

    /**
     * 增加用户签名
     * @param userSignature 用户签名
     * @return int
     */
    int addUserSignature(UserSignature userSignature);

    /**
     * 修改用户签名
     * @param userSignature 用户签名
     * @return int
     */
    int modifyUserSignature(UserSignature userSignature);

    /**
     * 删除用户签名
     * @param id ID主键
     * @return int
     */
    int deleteUserSignature(Integer id);

    /**
     * 设置默认用户签名
     * @param id ID主键
     * @return int
     */
    int configDefaultUserSignature(Integer id);
}
