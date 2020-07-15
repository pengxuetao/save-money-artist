package com.luffy.artist.controller.taobao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luffy.artist.utils.JSONUtil;
import com.luffy.artist.vo.ConvertReq;
import com.luffy.artist.vo.ConvertResp;
import com.luffy.artist.vo.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TaoPasswordControllerTest {

    @LocalServerPort
    private int port;

    @Resource
    private TestRestTemplate testRestTemplate;

    @Resource
    private MockMvc mockMvc;

    @Test
    void testConvertByHttp() {
        ConvertReq convertReq = new ConvertReq();
        convertReq.setOriString("欢迎选购 $123456abc$ QQQ");
        convertReq.setTargetString("欢迎313选购 $asfgg1232$ 4113");
        String result = testRestTemplate.postForObject("http://127.0.0.1:" + port + "/taopassword/convert", convertReq, String.class);
        Result<ConvertResp> respResult = JSONUtil.jsonStr2JavaObject(result, new TypeReference<Result<ConvertResp>>() {});
        assertEquals("0", respResult.getCode());
        assertEquals("欢迎选购 $asfgg1232$ QQQ", respResult.getData().getConvertResult());
    }

    @Test
    void testConvertByMockMvc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/taopassword/convert"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, spring"));
    }

    static Stream<ConvertReq> testConvertByParameterizedSuccess() {
        ConvertReq convertReq = new ConvertReq();
        convertReq.setOriString("欢迎选购 $123456abc$ QQQ");
        convertReq.setTargetString("欢迎313选购 $asfgg1232$ 4113");
        ConvertReq convertReq2 = new ConvertReq();
        convertReq2.setOriString("欢迎选购 $1yyyy6abc$ QQQ2222");
        convertReq2.setTargetString("欢迎313选购 $asDETG32$ 4113");
        return Stream.of(convertReq, convertReq2);
    }

    @ParameterizedTest
    @MethodSource
    void testConvertByParameterizedSuccess(ConvertReq convertReq) {
        String result = testRestTemplate.postForObject("http://127.0.0.1:" + port + "/taopassword/convert", convertReq, String.class);
        Result<ConvertResp> respResult = JSONUtil.jsonStr2JavaObject(result, new TypeReference<Result<ConvertResp>>() {});
        assertEquals("0", respResult.getCode());
    }

    static Stream<ConvertReq> testConvertByParameterizedFailure() {
        ConvertReq convertReq = new ConvertReq();
        convertReq.setOriString("欢迎选购 $123@##56abc$ QQQ");
        convertReq.setTargetString("欢迎313fgg1232$ 4113");
        ConvertReq convertReq2 = new ConvertReq();
        convertReq2.setOriString("");
        convertReq2.setTargetString("欢迎313选购 $asDETG32$ 4113");
        return Stream.of(convertReq, convertReq2);
    }

    @ParameterizedTest
    @MethodSource
    void testConvertByParameterizedFailure(ConvertReq convertReq) {
        String result = testRestTemplate.postForObject("http://127.0.0.1:" + port + "/taopassword/convert", convertReq, String.class);
        Result<ConvertResp> respResult = JSONUtil.jsonStr2JavaObject(result, new TypeReference<Result<ConvertResp>>() {});
        assertNotEquals("0", respResult.getCode());
    }
}