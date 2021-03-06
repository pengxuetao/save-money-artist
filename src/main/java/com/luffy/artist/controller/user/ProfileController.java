package com.luffy.artist.controller.user;

import com.luffy.artist.entity.SysDict;
import com.luffy.artist.entity.UserSignature;
import com.luffy.artist.enums.ErrorCode;
import com.luffy.artist.service.SysDictService;
import com.luffy.artist.service.UserSignatureService;
import com.luffy.artist.vo.Result;
import com.luffy.artist.vo.user.AddUserSignatureReq;
import com.luffy.artist.vo.user.ModifyUserSignatureReq;
import com.luffy.artist.vo.user.SignatureSwitchResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 我的控制类
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
@RestController
@Api("我的")
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @Resource
    private SysDictService sysDictService;
    @Resource
    private UserSignatureService userSignatureService;

    /**
     * 查询签名开关设置
     *
     * @return Result<SysDict>
     */
    @GetMapping("/signature/switch")
    @ApiOperation(value = "查询签名开关设置")
    public Result<SignatureSwitchResp> querySignatureSwitch() {
        LOGGER.info("---查询签名开关设置start---");
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
            LOGGER.info("---查询签名开关设置end---");
            return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        SignatureSwitchResp signatureSwitchResp = new SignatureSwitchResp();
        signatureSwitchResp.setSubtypeValue(sysDict.getSubtypeValue());
        LOGGER.info("---查询签名开关设置end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), signatureSwitchResp);
    }

    /**
     * 设置签名开关
     *
     * @return Result<SysDict>
     */
    @PutMapping("/signature/switch")
    @ApiOperation(value = "设置签名开关")
    public Result<Boolean> signatureSwitch() {
        LOGGER.info("---设置签名开关start---");
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
            LOGGER.info("---设置签名开关end---");
            return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        SysDict updateSysDict = new SysDict();
        updateSysDict.setId(sysDict.getId());
        switch (sysDict.getSubtypeValue()) {
            case "0":
                updateSysDict.setSubtypeValue("1");
                LOGGER.info("---已打开签名开关---");
                break;
            case "1":
                updateSysDict.setSubtypeValue("0");
                LOGGER.info("---已关闭签名开关---");
                break;
            default:
                LOGGER.info("---设置签名开关end---");
                return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        sysDictService.updateSysDict(updateSysDict);
        LOGGER.info("---设置签名开关end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 查询用户签名列表
     *
     * @return Result<List < UserSignature>>
     */
    @GetMapping("/signature/list")
    @ApiOperation(value = "查询用户签名列表")
    public Result<List<UserSignature>> queryUserSignatureList() {
        LOGGER.info("---查询用户签名列表start---");
        List<UserSignature> userSignatureList = userSignatureService.queryUserSignatureListByUserId("admin");
        LOGGER.info("---查询用户签名列表end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), userSignatureList);
    }

    /**
     * 查询用户签名
     *
     * @param id ID主键
     * @return Result<UserSignature>
     */
    @GetMapping("/signature/{id}")
    @ApiOperation(value = "查询用户签名")
    public Result<UserSignature> queryUserSignature(@PathVariable("id") Integer id) {
        LOGGER.info("---查询用户签名start---");
        if (id < 1) {
            LOGGER.info("---查询用户签名end---");
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        UserSignature userSignature = userSignatureService.queryUserSignatureById(id);
        LOGGER.info("---查询用户签名end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), userSignature);
    }

    /**
     * 增加用户签名
     *
     * @param addUserSignatureReq 用户签名
     * @return int
     */
    @PostMapping("/signature")
    @ApiOperation(value = "增加用户签名")
    public Result<Boolean> addUserSignature(@RequestBody @Valid AddUserSignatureReq addUserSignatureReq) {
        LOGGER.info("---增加用户签名start---");
        UserSignature userSignature = new UserSignature();
        BeanUtils.copyProperties(addUserSignatureReq, userSignature);
        userSignature.setUserId("admin");
        userSignatureService.addUserSignature(userSignature);
        LOGGER.info("---增加用户签名end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 修改用户签名
     *
     * @param modifyUserSignatureReq 用户签名
     * @return int
     */
    @PutMapping("/signature")
    @ApiOperation(value = "修改用户签名")
    public Result<Boolean> modifyUserSignature(@RequestBody @Valid ModifyUserSignatureReq modifyUserSignatureReq) {
        LOGGER.info("---修改用户签名start---");
        UserSignature isExist = userSignatureService.queryUserSignatureById(modifyUserSignatureReq.getId());
        if (isExist == null) {
            LOGGER.info("---修改用户签名end---");
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        UserSignature userSignature = new UserSignature();
        BeanUtils.copyProperties(modifyUserSignatureReq, userSignature);
        userSignatureService.modifyUserSignature(userSignature);
        LOGGER.info("---修改用户签名end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 删除用户签名
     *
     * @param id ID主键
     * @return int
     */
    @DeleteMapping("/signature/{id}")
    @ApiOperation(value = "删除用户签名")
    public Result<Boolean> deleteUserSignature(@PathVariable("id") Integer id) {
        LOGGER.info("---删除用户签名start---");
        if (id < 1) {
            LOGGER.info("---删除用户签名end---");
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        userSignatureService.deleteUserSignature(id);
        LOGGER.info("---删除用户签名end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 设置默认用户签名
     *
     * @param id ID主键
     * @return int
     */
    @PutMapping("/signature/{id}/default")
    @ApiOperation(value = "设置默认用户签名")
    public Result<Boolean> configDefaultUserSignature(@PathVariable("id") Integer id) {
        LOGGER.info("---设置默认用户签名start---");
        if (id < 1) {
            LOGGER.info("---设置默认用户签名end---");
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        userSignatureService.configDefaultUserSignature(id);
        LOGGER.info("---设置默认用户签名end---");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }
}
