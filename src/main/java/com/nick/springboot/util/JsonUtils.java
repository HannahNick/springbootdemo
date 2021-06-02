package com.nick.springboot.util;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE;

/**
 * @author zhangyx
 * @date 2019/10/10 11:40
 */
@UtilityClass
public class JsonUtils {

    public JSONObject toJsonObject(Object object) {
        return parseObject(toJSONString(object));
    }

    public JSONArray toJsonArray(List<?> objects) {
        return JSON.parseArray(toJSONString(objects));
    }

    public JSONArray toJsonArray(Object object) {
        return JSON.parseArray(toJSONString(object));
    }

    /**
     * 根据路径获取对象
     *
     * @param jsonObject 原对象
     * @param path       路径
     * @return 结果
     */
    public JSONObject getObjectByPath(JSONObject jsonObject, String path) {
        Object object = JSONPath.eval(jsonObject, path);
        return JSONObject.parseObject(JSONObject.toJSONString(object));
    }

    /**
     * 根据路径获取对象
     *
     * @param jsonObject 原对象
     * @param path       路径
     * @return 结果
     */
    public JSONArray getArrayByPath(JSONObject jsonObject, String path) {
        Object object = JSONPath.eval(jsonObject, path);
        return JSONObject.parseArray(JSONObject.toJSONString(object));
    }

    /**
     * 根据路径获取对象
     *
     * @param jsonObject 原对象
     * @param path       路径
     * @return 结果
     */
    public <T> T getObjectByPath(JSONObject jsonObject, Class<T> tClass, String path) {
        Object object = JSONPath.eval(jsonObject, path);
        return JSONObject.parseObject(JSONObject.toJSONString(object), tClass);
    }

    /**
     * 根据路径获取对象
     *
     * @param jsonObject 原对象
     * @param path       路径
     * @return 结果
     */
    public <T> List<T> getArrayByPath(JSONObject jsonObject, Class<T> tClass, String path) {
        Object object = JSONPath.eval(jsonObject, path);
        return JSONObject.parseArray(JSONObject.toJSONString(object), tClass);
    }

    public <T> T parseObject(String text, TypeReference<T> type, Feature... features) {
        return JSONObject.parseObject(text, type, features);
    }

    public static String toJSONString(Object object) {
        return JSONObject.toJSONString(object, SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteBigDecimalAsPlain);
    }

    /**
     * 采用fastJson默认转化JSON数据
     *
     * @param object 需要转换的对象
     * @return JSON串
     */
    public String toDefaultJSONString(Object object) {
        return JSONObject.toJSONString(object);
    }

    public String toJSONString(Object object, SerializerFeature... features) {
        return JSONObject.toJSONString(object, features);
    }

    public <T> T parseObject(String text, Class<T> clazz) {
        return JSONObject.parseObject(text, clazz);
    }

    public <T> T parseObject(String json, Type type, Feature... features) {
        return JSON.parseObject(json, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, features);
    }

    public <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSONObject.parseArray(text, clazz);
    }

    public Object getValueBykey(String text, String key) {
        JSONObject jsonObject = JSON.parseObject(text);
        return jsonObject.get(key);
    }

    public boolean isContainKey(String text, String key) {
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(text);
        } catch (Exception e) {
            return false;
        }
        return jsonObject.containsKey(key);
    }

    public JSONObject parseObject(String text) {
        return JSONObject.parseObject(text);
    }

    public boolean isJson(String text) {
        try {
            parseObject(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    private final ValueFilter RESULT_VALUE_FILTER = (object, name, value) -> {
//        if (value == null) {
//            return null;
//        }
//        try {
//            Field field = object.getClass().getDeclaredField(name);
//            if (null != field.getAnnotation(SerializeAsSting.class)) {
//                return value.toString();
//            }
//            return value;
//        } catch (Exception e) {
//            return value;
//        }
//    };
//
//    private final SerializeFilter[] RESULT_JSON_FILTERS = new SerializeFilter[]
//            {RESULT_VALUE_FILTER};
}
