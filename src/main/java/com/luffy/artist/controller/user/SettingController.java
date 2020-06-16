package com.luffy.artist.controller.user;

import com.luffy.artist.entity.SysDict;
import com.luffy.artist.entity.UserSignature;
import com.luffy.artist.enums.ErrorCode;
import com.luffy.artist.service.SysDictService;
import com.luffy.artist.service.UserSignatureService;
import com.luffy.artist.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api("设置")
@RequestMapping("/setting")
public class SettingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private UserSignatureService userSignatureService;

    /**
     * 设置签名开关
     * @return Result<SysDict>
     */
    @ResponseBody
    @PostMapping("/signatureSwitch")
    @ApiOperation(value = "设置签名开关")
    public Result<SysDict> signatureSwitch() {
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
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
                return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        sysDictService.updateSysDict(updateSysDict);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), sysDict);
    }

    /**
     * 查询签名开关设置
     * @return Result<SysDict>
     */
    @ResponseBody
    @PostMapping("/querySignatureSwitch")
    @ApiOperation(value = "查询签名开关设置")
    public Result<SysDict> querySignatureSwitch() {
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
            return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), sysDict);
    }

    /**
     * 查询用户签名列表
     * @return Result<List<UserSignature>>
     */
    @ResponseBody
    @GetMapping("/queryUserSignatureList")
    @ApiOperation(value = "查询用户签名列表")
    public Result<List<UserSignature>> queryUserSignatureList() {
        List<UserSignature> userSignatureList = userSignatureService.queryUserSignatureListByUserId("admin");
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), userSignatureList);
    }

    /**
     * 查询用户签名
     * @param id ID主键
     * @return Result<UserSignature>
     */
    @ResponseBody
    @GetMapping("/queryUserSignature")
    @ApiOperation(value = "查询用户签名")
    public Result<UserSignature> queryUserSignature(@RequestParam("id") Integer id) {
        UserSignature userSignature = userSignatureService.queryUserSignatureById(id);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), userSignature);
    }

    /**
     * 增加用户签名
     * @param userSignature 用户签名
     * @return int
     */
    @ResponseBody
    @PostMapping("/addUserSignature")
    @ApiOperation(value = "增加用户签名")
    public Result<Boolean> addUserSignature(@RequestBody UserSignature userSignature) {
        userSignature.setUserId("admin");
        userSignatureService.addUserSignature(userSignature);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 修改用户签名
     * @param userSignature 用户签名
     * @return int
     */
    @ResponseBody
    @PostMapping("/modifyUserSignature")
    @ApiOperation(value = "修改用户签名")
    public Result<Boolean> modifyUserSignature(@RequestBody UserSignature userSignature) {
        userSignatureService.modifyUserSignature(userSignature);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 删除用户签名
     * @param id ID主键
     * @return int
     */
    @ResponseBody
    @PostMapping("/deleteUserSignature")
    @ApiOperation(value = "删除用户签名")
    public Result<Boolean> deleteUserSignature(@RequestParam("id") Integer id) {
        userSignatureService.deleteUserSignature(id);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }

    /**
     * 设置默认用户签名
     * @param id ID主键
     * @return int
     */
    @ResponseBody
    @PostMapping("/configDefaultUserSignature")
    @ApiOperation(value = "设置默认用户签名")
    public Result<Boolean> configDefaultUserSignature(@RequestParam("id") Integer id) {
        userSignatureService.configDefaultUserSignature(id);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), true);
    }
}
