package com.luffy.artist.controller;

import com.luffy.artist.entity.SysDict;
import com.luffy.artist.entity.UserSignature;
import com.luffy.artist.enums.DictEnum;
import com.luffy.artist.enums.ErrorCode;
import com.luffy.artist.enums.SymbolEnum;
import com.luffy.artist.service.SysDictService;
import com.luffy.artist.service.UserSignatureService;
import com.luffy.artist.vo.ConvertReq;
import com.luffy.artist.vo.ConvertResp;
import com.luffy.artist.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 淘口令控制类
 * @author Peng xue-tao
 * @since 2020/6/17
 */
@Controller
@Api("淘口令")
@RequestMapping("/taopassword")
public class TaoPasswordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaoPasswordController.class);

    @Resource
    private SysDictService sysDictService;
    @Resource
    private UserSignatureService userSignatureService;

    /**
     * 转换口令
     * @param convertReq 转换口令请求参数
     * @return Result<ConvertResp>
     */
    @ResponseBody
    @PostMapping("/convert")
    @ApiOperation(value = "转换口令")
    public Result<ConvertResp> convert(@RequestBody ConvertReq convertReq){
        if(StringUtils.isEmpty(convertReq.getOriString()) || StringUtils.isEmpty(convertReq.getTargetString()) ) {
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        String patternExpression;
        if(convertReq.getOriString().contains(SymbolEnum.LEFT_PARENTHESIS.getCode())
                && convertReq.getOriString().contains(SymbolEnum.RIGHT_PARENTHESIS.getCode())) {
            patternExpression = "([\\p{Punct}])\\w{8,12}([\\p{Punct}])";
        } else {
            patternExpression = "([\\p{Sc}])\\w{8,12}([\\p{Sc}])";
        }
        String content = convertReq.getOriString();
        String content2 = convertReq.getTargetString();

        Pattern pattern = Pattern.compile(patternExpression);
        Matcher matcher = pattern.matcher(content);
        Matcher matcher2 = pattern.matcher(content2);
        if(!matcher.find()) {
            return new Result<>(ErrorCode.ERROR_90001.getCode(), ErrorCode.ERROR_90001.getErrorDesc());
        }
        if(!matcher2.find()) {
            return new Result<>(ErrorCode.ERROR_90001.getCode(), ErrorCode.ERROR_90001.getErrorDesc());
        }
        LOGGER.info("转换前--------------");
        LOGGER.info(content);
        LOGGER.info(content2);
        String s = matcher.group();
        String s2 = matcher2.group();
        LOGGER.info("转换后--------------");
        LOGGER.info(content.replace(s ,s2));
        String result = content.replace(s ,s2);
        SysDict sysDict = sysDictService.querySysDictByTypeKey("signatureSwitch");
        // 签名设置打开，且有默认签名，则把签名拼接到转换后的口令结果上
        if (DictEnum.SIGNATURE_SWITCH_ON.getCode().equals(sysDict.getSubtypeValue())) {
            UserSignature userSignature = userSignatureService.queryDefaultUserSignature("admin");
            if (userSignature != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(result);
                sb.append("\n---------------------\n");
                sb.append(userSignature.getContent());
                result = sb.toString();
            }
        }
        ConvertResp convertResp = new ConvertResp();
        convertResp.setConvertResult(result);
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), convertResp);
    }

}
