package com.luffy.artist.controller;

import com.luffy.artist.vo.ConvertReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Api("淘口令")
@RequestMapping("/taopassword")
public class TaoPasswordController {

    /**
     * 转换口令
     * @param convertReq
     * @return
     */
    @ResponseBody
    @PostMapping("/convert")
    @ApiOperation(value = "转换口令")
    public String convert(@RequestBody ConvertReq convertReq){
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
            return "请输入正确的淘口令";
        }
        if(!matcher2.find()) {
            return "请输入正确的淘口令";
        }
        System.out.println("转换前--------------");
        System.out.println(content);
        System.out.println(content2);
        String s = matcher.group();
        String s2 = matcher2.group();
        System.out.println("转换后--------------");
        System.out.println(content.replace(s ,s2));
        return content.replace(s ,s2);
    }

}
