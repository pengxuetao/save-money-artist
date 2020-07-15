package com.luffy.artist.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.luffy.artist.vo.ConvertResp;
import com.luffy.artist.vo.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONUtilTest {

    @Test
    void testJSONStr2JavaObject() {
        String json = "{\"code\":\"0\",\"data\":{\"convertResult\":\"存款利率\"},\"message\":\"\"}";
        Result result = JSONUtil.jsonStr2JavaObject(json, Result.class);
        assertEquals("Result{code='0', message='', data={convertResult=存款利率}}", result.toString());
        Result<ConvertResp> result2 = JSONUtil.jsonStr2JavaObject(json, new TypeReference<Result<ConvertResp>>() {
        });
        assertEquals("Result{code='0', message='', data=ConvertResp{convertResult='存款利率'}}", result2.toString());
    }
}