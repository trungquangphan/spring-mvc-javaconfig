package com.doomphantoom.util;

/**
 * Created by doomphantom on 23/10/2015.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
    public JsonUtil() {
    }

    private static final ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        return mapper;
    }

    public static String convertObjectToJson(Object object) {
        ObjectMapper mapper = getObjectMapper();

        try {
            mapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException var3) {
            throw new IllegalArgumentException(var3.getMessage(), var3);
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> className) {
        ObjectMapper mapper = getObjectMapper();

        try {
            return mapper.readValue(json, className);
        } catch (JsonParseException var4) {
            throw new IllegalArgumentException(var4.getMessage());
        } catch (JsonMappingException var5) {
            throw new IllegalArgumentException(var5.getMessage());
        } catch (IOException var6) {
            throw new IllegalArgumentException(var6.getMessage());
        }
    }

    public static <T> T convertJsonToObject(String json, TypeReference<T> type) {
        ObjectMapper mapper = getObjectMapper();

        try {
            return mapper.readValue(json, type);
        } catch (JsonParseException var4) {
            throw new IllegalArgumentException(var4.getMessage());
        } catch (JsonMappingException var5) {
            throw new IllegalArgumentException(var5.getMessage());
        } catch (IOException var6) {
            throw new IllegalArgumentException(var6.getMessage());
        }
    }

    public static <T> List<T> convertJsonToCollection(String json, Class<T> className) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            CollectionType e = objectMapper.getTypeFactory().constructCollectionType(List.class, className);
            return (List) objectMapper.readValue(json, e);
        } catch (JsonParseException var4) {
            throw new IllegalArgumentException(var4.getMessage());
        } catch (JsonMappingException var5) {
            throw new IllegalArgumentException(var5.getMessage());
        } catch (IOException var6) {
            throw new IllegalArgumentException(var6.getMessage());
        }
    }

    public static <T, O> T convertJsonToObject(String json, Class<T> genericClass, Class<O> bodyClass) {
        ObjectMapper mapper = getObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(genericClass, new Class[]{bodyClass});

        try {
            return mapper.readValue(json, javaType);
        } catch (IOException var6) {
            throw new IllegalArgumentException(var6.getMessage());
        }
    }
}
