package com.luffy.artist.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON工具类
 *
 * @author Peng xue-tao
 * @since 2020/7/15
 */
public class JSONUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 忽略空BEAN转JSON错误
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 忽略反序列化字段不一致错误
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JSONUtil() {
    }

    /**
     * JSON字符串转Java对象
     *
     * @param jsonStr JSON字符串
     * @param type    Java对象类型
     * @param <T>     Java泛型
     * @return <T> T
     */
    public static <T> T jsonStr2JavaObject(String jsonStr, Class<T> type) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(jsonStr, type);
        } catch (JsonProcessingException e) {
            LOGGER.error("jsonStr2JavaObject error: ", e);
        }
        return object;
    }

    /**
     * JSON字符串转Java对象
     *
     * @param jsonStr       JSON字符串
     * @param typeReference Java对象类型
     * @param <T>           Java泛型
     * @return <T> T
     */
    public static <T> T jsonStr2JavaObject(String jsonStr, TypeReference<T> typeReference) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            LOGGER.error("jsonStr2JavaObject error: ", e);
        }
        return object;
    }

}
