package com.xialuo.shop.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 微信openId
     */
    private String openid;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 微信unId
     */
    private String unionid;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 性别，1-男，2-女
     */
    private Integer gender = 2;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 民族
     */
    private String nation;

    /**
     * 微信号
     */
    private String wechatNum;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除 0否1是
     */
    private Boolean isDeleted = true;

    /**
     * U2userid
     */
    private String userId;

    /**
     * U2token
     */
    private String accessToken;

    /**
     * 通行证u2at过期时间
     */
    private Date accessTokenExpire;

    /**
     * 新东方邮箱
     */
    private String mail;
}