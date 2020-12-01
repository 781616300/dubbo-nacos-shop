package com.xialuo.shop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xialuo.shop.res.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 标准JSON返回值 status 0失败，1成功 错误码在code里
 *
 * @author caichangyong
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@ApiModel(description = "API返回值")
public class CommonResult<T> {

  public static final int SUCCESS = 1;
  public static final int FAILURE = 0;

  @ApiModelProperty(value = "状态，0失败，1成功", required = true)
  private int status;
  @ApiModelProperty(value = "消息", required = true)
  private String message;
  @ApiModelProperty(value = "数据")
  private T data;
  @ApiModelProperty(value = "业务代码，200：成功；500：服务异常；4000：登录状态无效", required = true)
  private String code;

  protected CommonResult(int status, String code, String message, T data) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 成功返回结果
   */
  public static <T> CommonResult<T> success() {
    return success(ResultCode.SUCCESS.getMessage(), null);
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   */
  public static <T> CommonResult<T> success(T data) {
    return success(ResultCode.SUCCESS.getMessage(), data);
  }

  /**
   * 成功返回结果
   *
   * @param message
   */
  public static <T> CommonResult<T> success(String message) {
    return success(message, null);
  }

  /**
   * 成功返回结果
   *
   * @param data    获取的数据
   * @param message 提示信息
   */
  public static <T> CommonResult<T> success(String message, T data) {
    return success(ResultCode.SUCCESS.getCode(), message, data);
  }

  /**
   * 成功返回结果
   *
   * @param data    获取的数据
   * @param message 提示信息
   */
  public static <T> CommonResult<T> success(String code, String message, T data) {
    return new CommonResult<>(SUCCESS, code, message, data);
  }

  /**
   * 失败返回结果
   *
   * @param code
   * @param message
   * @param data
   * @return
   */
  public static <T> CommonResult<T> failed(String code, String message, T data) {
    return new CommonResult<>(FAILURE, code, message, data);
  }

  /**
   * 失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> failed(String message) {
    return failed(ResultCode.FAILED.getCode(), message, null);
  }

  /**
   * 失败返回结果
   */
  public static <T> CommonResult<T> failed() {
    return failed(ResultCode.FAILED.getMessage());
  }


  /**
   * http错误码
   *
   * @param status  HttpStatus
   * @param message
   */
  public static <T> CommonResult<T> failed(HttpStatus status, String message) {
    return failed(String.valueOf(status.value()), message, null);
  }

}
