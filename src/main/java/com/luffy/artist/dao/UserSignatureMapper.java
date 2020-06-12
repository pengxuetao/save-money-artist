package com.luffy.artist.dao;

import com.luffy.artist.entity.UserSignature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSignatureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSignature record);

    int insertSelective(UserSignature record);

    UserSignature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSignature record);

    int updateByPrimaryKey(UserSignature record);

    /**
     * 根据用户ID查询签名列表
     * @param userId 用户ID
     * @return List<UserSignature>
     */
    List<UserSignature> selectListByUserId(@Param("userId") String userId);

    /**
     * 根据用户ID查询默认签名
     * @param userId 用户ID
     * @return UserSignature
     */
    UserSignature selectDefaultByUserId(@Param("userId") String userId);

    /**
     * 根据ID主键更新默认签名
     * @param id ID主键
     * @param isDefault 是否默认 0-否 1-是
     * @return int
     */
    int updateDefaultByPrimaryKey(@Param("id") Integer id, @Param("isDefault") Byte isDefault);
}