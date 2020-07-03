package com.luffy.artist.dao;

import com.luffy.artist.entity.UserSignature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户签名Mapper
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public interface UserSignatureMapper {
    /**
     * 根据id删除用户签名
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户签名
     *
     * @param record 用户签名
     * @return int
     */
    int insert(UserSignature record);

    /**
     * 选择性插入用户签名
     *
     * @param record 用户签名
     * @return int
     */
    int insertSelective(UserSignature record);

    /**
     * 根据id查询用户签名
     *
     * @param id id
     * @return UserSignature
     */
    UserSignature selectByPrimaryKey(Integer id);

    /**
     * 选择性更新用户签名
     *
     * @param record 用户签名
     * @return int
     */
    int updateByPrimaryKeySelective(UserSignature record);

    /**
     * 更新用户签名
     *
     * @param record 用户签名
     * @return int
     */
    int updateByPrimaryKey(UserSignature record);

    /**
     * 根据用户ID查询签名列表
     *
     * @param userId 用户ID
     * @return List<UserSignature>
     */
    List<UserSignature> selectListByUserId(@Param("userId") String userId);

    /**
     * 根据用户ID查询默认签名
     *
     * @param userId 用户ID
     * @return UserSignature
     */
    UserSignature selectDefaultByUserId(@Param("userId") String userId);

    /**
     * 根据ID主键更新默认签名
     *
     * @param id        ID主键
     * @param isDefault 是否默认 0-否 1-是
     * @return int
     */
    int updateDefaultByPrimaryKey(@Param("id") Integer id, @Param("isDefault") Byte isDefault);
}