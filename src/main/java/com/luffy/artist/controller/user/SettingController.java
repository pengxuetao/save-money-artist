package com.luffy.artist.controller.user;

import com.luffy.artist.entity.SysDict;
import com.luffy.artist.enums.ErrorCode;
import com.luffy.artist.service.SysDictService;
import com.luffy.artist.vo.ConvertReq;
import com.luffy.artist.vo.ConvertResp;
import com.luffy.artist.vo.Result;
import com.luffy.artist.vo.SignatureSwitchReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Api("设置")
@RequestMapping("/setting")
public class SettingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

    @Autowired
    private SysDictService sysDictService;

    /**
     * 设置签名开关
     * @param signatureSwitchReq 设置签名开关请求参数
     * @return Result<SysDict>
     */
    @ResponseBody
    @PostMapping("/signatureSwitch")
    @ApiOperation(value = "设置签名开关")
    public Result<SysDict> signatureSwitch(@RequestBody SignatureSwitchReq signatureSwitchReq){
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        String signatureSwitch = signatureSwitchReq.getSignatureSwitchStatus();
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
            return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        SysDict updateSysDict = new SysDict();
        updateSysDict.setId(sysDict.getId());
        if ("0".equals(signatureSwitch)) {
            updateSysDict.setSubtypeValue("1");
            LOGGER.info("---已打开签名开关---");
        }
        if ("1".equals(signatureSwitch)) {
            updateSysDict.setSubtypeValue("0");
            LOGGER.info("---已关闭签名开关---");
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
    public Result<SysDict> querySignatureSwitch(){
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        if (sysDict == null || StringUtils.isEmpty(sysDict.getSubtypeValue())) {
            return new Result<>(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getErrorDesc());
        }
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), sysDict);
    }

}
