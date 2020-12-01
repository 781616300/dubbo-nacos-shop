package com.xialuo.shop.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class ObjectMapperUtil {

  protected static ObjectMapper objectMapper = new ObjectMapper();

  static {
    getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  }

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  /**
   * 转JSONString
   *
   * @param obj
   * @return
   */
  public static String toJSONString(Object obj) {
    if (obj != null) {
      try {
        return getObjectMapper().writeValueAsString(obj);
      } catch (JsonProcessingException ex) {
        log.error("Could not write JSON: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }

  /**
   * 转JsonNode
   *
   * @param json
   * @return
   */
  public static JsonNode parseJSON(String json) {
    if (!StringUtils.isEmpty(json)) {
      try {

        return getObjectMapper().readTree(json);
      } catch (JsonProcessingException ex) {
        log.error("Could not read JSON Object: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }
  /**
   * 转实体对象
   *
   * @param json
   * @param valueType
   * @param <T>
   * @return
   */
  public static <T> T parseObject(String json, Class<T> valueType) {
    if (!StringUtils.isEmpty(json)) {
      try {
        return getObjectMapper().readValue(json, valueType);
      } catch (JsonProcessingException ex) {
        log.error("Could not read JSON Object: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }

  /**
   * 转实体对象
   * @param node
   * @param valueType
   * @param <T>
   * @return
   */
  public static <T> T parseObject(JsonNode node, Class<T> valueType) {
    if (node != null) {
      try {

        return getObjectMapper().convertValue(node, valueType);

      } catch (Exception ex) {
        log.error("Could not convert JsonNode, node: {}, type:{}", node, valueType, ex);
      }
    }
    return null;
  }

  /**
   * 转List对象
   * @param json
   * @param valueType
   * @param <T>
   * @return
   */
  public <T> List<T> parseList(JsonNode json, Class<T> valueType) {

    if (json != null) {
      try {
        JavaType javaType = getObjectMapper().getTypeFactory().constructParametricType(List.class, valueType);

        return getObjectMapper().convertValue(json, javaType);

      } catch (Exception ex) {
        log.error("Could not read JSON Object: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }

  /**
   * 转List对象
   *
   * @param json
   * @param valueType
   * @param <T>
   * @return
   */
  public static <T> List<T> parseList(String json, Class<T> valueType) {
    if (!StringUtils.isEmpty(json)) {
      try {
        JavaType javaType = getObjectMapper().getTypeFactory().constructParametricType(List.class, valueType);
        return getObjectMapper().readValue(json, javaType);
      } catch (JsonProcessingException ex) {
        log.error("Could not read JSON Object: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }

  /**
   * 转Map
   *
   * @param json
   * @param valueType
   * @param <T>
   * @return
   */
  @Deprecated
  public static <T> Map<String, T> parseMap(String json, Class<T> valueType) {
    if (!StringUtils.isEmpty(json)) {
      try {
        JavaType javaType = getObjectMapper().getTypeFactory().constructParametricType(Map.class, String.class, valueType);
        return getObjectMapper().readValue(json, javaType);
      } catch (JsonProcessingException ex) {
        log.error("Could not read JSON Object: {}", ex.getMessage(), ex);
      }
    }
    return null;
  }



}
