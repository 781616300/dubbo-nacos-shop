package com.xialuo.shop.res;

/**
 * 枚举了一些常用API操作码
 * @author
 */
public enum ResultCode {
  SIGN_INVALID("1001", "接口签名无效"),
  SIGN_EXPIRED("1002", "请求过期"),
  SIGN_PARAM_ERROR("1003", "验签参数缺失"),

  SUCCESS("200", "操作成功"),
  FAILED("500", "服务异常");
  private String code;
  private String message;

  private ResultCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

}
