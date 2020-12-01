package com.xialuo.shop.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengliye
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Coupon对象", description="")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "卡券名")
    private String title;

    @ApiModelProperty(value = "对外名称")
    private String outerName;

    @ApiModelProperty(value = "卡券类型码")
    private String couponNo;

    @ApiModelProperty(value = "卡券类型，1：补差，2：课程卡，3：满减;4：折扣券,5：兑换券")
    private Integer couponType;

    @ApiModelProperty(value = "用户自定类型")
    private Integer customType;

    @ApiModelProperty(value = "卡券库存总量")
    private Integer quantity;

    @ApiModelProperty(value = "0-未发布,1-可用,2-作废,3-审核中")
    private Integer status;

    @ApiModelProperty(value = "卡券描述")
    private String description;

    @ApiModelProperty(value = "1：固定日期;2：未来有效期几天")
    private Integer dateType;

    @ApiModelProperty(value = "固定有效期，开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "固定有效期，结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = " 未来有效期：领取后多少天有效")
    private Integer fixedStartTerm;

    @ApiModelProperty(value = "未来有效期：有效时长是多少天")
    private Integer fixedLengthTerm;

    private LocalDateTime createTime;

    private Long creatorId;

    @ApiModelProperty(value = "创建人名称")
    private String creatorName;

    @ApiModelProperty(value = "创建人电子邮箱")
    private String creatorEmail;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户限领次数")
    private Long getLimit;

    @ApiModelProperty(value = "剩余数量")
    private Integer remainCount;

    @ApiModelProperty(value = "预算部门")
    private String budgetDept;

    @ApiModelProperty(value = "注册渠道id")
    private Long registerChannelId;

    @ApiModelProperty(value = "注册渠道名称")
    private String registerChannelName;

    @ApiModelProperty(value = "领取有效期开始时间")
    private LocalDateTime receiveBeginTime;

    @ApiModelProperty(value = "领取有效期结束时间")
    private LocalDateTime receiveEndTime;

    @ApiModelProperty(value = "是否可以被员工申请（0：否，1：是）")
    private Integer canbeApplied;

    @ApiModelProperty(value = "知识库url地址")
    private String faq;

    @ApiModelProperty(value = "创建人员工工号,R开头的,用于往OA那面发起审核流程")
    private String creatorJobNum;

    @ApiModelProperty(value = "OA审核结果，PASS:审核通过,REJECT:审核拒绝")
    private String auditResult;

    @ApiModelProperty(value = "oa信息化发起流程单号")
    private String oaFormId;

    @ApiModelProperty(value = "业务类型，OneForOne-1对1,FX-蜂校,EC-电商")
    private String bizType;

    @ApiModelProperty(value = "卡种类")
    private String cardType;

    @ApiModelProperty(value = "券成本")
    private BigDecimal couponCost;

    @ApiModelProperty(value = "制卡成本")
    private BigDecimal makeCardCost;

    @ApiModelProperty(value = "发放类型，ResourcesReplace-资源置换,ThirdPlatSell-第三方平台售卖,Give-赠送")
    private String grantType;

    @ApiModelProperty(value = "活动链接")
    private String actUrl;

    @ApiModelProperty(value = "第三方售卖平台")
    private String thirdplatSellName;

    @ApiModelProperty(value = "第三方售卖金额")
    private BigDecimal thirdplatSellPrice;

    @ApiModelProperty(value = "是否为测试券")
    private Boolean testCoupon;


}
