package com.luffy.artist.controller;

import com.luffy.artist.enums.ErrorCode;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Api("淘口令")
@RequestMapping("/taopassword")
public class TaoPasswordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaoPasswordController.class);

    /**
     * 转换口令
     * @param convertReq
     * @return
     */
    @ResponseBody
    @PostMapping("/convert")
    @ApiOperation(value = "转换口令")
    public Result<ConvertResp> convert(@RequestBody ConvertReq convertReq){
        if(StringUtils.isEmpty(convertReq.getOriString()) || StringUtils.isEmpty(convertReq.getTargetString()) ) {
            return new Result<>(ErrorCode.ERROR_10000.getCode(), ErrorCode.ERROR_10000.getErrorDesc());
        }
        String patternExpression;
        if(convertReq.getOriString().contains("(") && convertReq.getOriString().contains(")")) {
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
        ConvertResp convertResp = new ConvertResp();
        convertResp.setConvertResult(content.replace(s ,s2));
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getErrorDesc(), convertResp);
    }

}
